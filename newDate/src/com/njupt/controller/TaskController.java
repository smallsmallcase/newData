package com.njupt.controller;

import com.njupt.po.*;
import com.njupt.service.*;
import com.njupt.service.util.DataMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by huhui on 2017/12/7.
 */
@Controller
public class TaskController {

    @Resource(name = "TaskService")
    private BasicService taskService;

    @Resource(name = "TaskService")
    private QueryByPage queryByPageForTask;

    @Resource(name = "BasicInformationService")
    private BatchQuery basicInformationService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/checkTask")
    public void checkTask(HttpServletRequest request, PrintWriter out){
        User user_information = (User) request.getSession().getAttribute("user_information");
        Task task = new Task();
        task.setUser_id(user_information.getUser_id());
        task.setFinish(0);
        List<Task> queryList = (List<Task>) taskService.query(task);
        if (queryList == null || queryList.size() == 0){
            /**
             一个controller跳转到另一个controller的方法
             return "forward:aaaa/bbbb.do";
             return "redirect:aaaa/bbbb.do";
             return new ModelAndView("forward:bbbb.do", null);
             return new ModelAndView("redirect:bbbb.do", null);
             */
            out.write("/loadNew.form");
            return;
        }
        request.getSession().setAttribute("task_id",queryList.get(queryList.size()-1).getTask_id());
        out.write("haveUnfinishedTask");
    }
    @RequestMapping("/loadTask")
    public ModelAndView loadTask(HttpServletRequest request){
        Integer task_id = (Integer) request.getSession().getAttribute("task_id");
        if (task_id != null){
            Task task = new Task();
            task.setTask_id(task_id);
            List<Task> queryList = (List<Task>) taskService.query(task);
            task = queryList.get(0);
            request.getSession().setAttribute("basic_id",task.getBasic_id());
            ModelAndView view = new ModelAndView("main");
            view.addObject("index",task.getPage_num());
            return view;
        }else {
            return new ModelAndView("main");
        }
    }
    @RequestMapping("/taskFinish")
    public void taskFinish(HttpServletRequest request,PrintWriter out){
        Integer task_id = (Integer) request.getSession().getAttribute("task_id");
        Task task = new Task();
        task.setFinish(1);
        task.setTask_id(task_id);
        taskService.update(task);
    }

    @RequestMapping("/taskList")
    public ModelAndView taskList(HttpServletRequest request,Integer currentPage){
        HttpSession session = request.getSession();
        User user_information = (User) session.getAttribute("user_information");
        Integer user_id = (user_information.getUser_id()) ;
        Task task = new Task();
        task.setUser_id(user_id);
        Page<Task> page = new Page<>();
        ArrayList<Task> list = new ArrayList<>();
        list.add(task);
        page.setDataList(list);
        page.setCurrentPage(currentPage == null||currentPage<1?1:currentPage);
        page = queryByPageForTask.queryByPage(page);
        List<Task> queryList = page.getDataList();
        if (queryList == null || queryList.size() == 0){
            String msgInfo = "还没有完成任何任务";
            ModelAndView view = new ModelAndView("msgDisplay");
            view.addObject("msgInfo",msgInfo);
            return view;
        }
        ArrayList<Integer> basic_idList = new ArrayList<>();
        for (int i = 0; i < queryList.size(); i++) {
            basic_idList.add(queryList.get(i).getBasic_id());
        }
        List<BasicInformation> basicInformationList = basicInformationService.queryByBasic_ids(basic_idList);
        Map<Integer,BasicInformation> basicInformationMap = new HashMap();
        for (BasicInformation basicInformation : basicInformationList) {
            Integer basic_id = basicInformation.getBasic_id();
            basicInformationMap.put(basic_id,basicInformation);
        }
        ArrayList<HashMap<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < queryList.size(); i++) {
            Integer basic_id = queryList.get(i).getBasic_id();
            HashMap<String, Object> tmpMap = new HashMap<>();
            BasicInformation basic= basicInformationMap.get(basic_id);
            if (basic != null){
                tmpMap.put("task_id",queryList.get(i).getTask_id());
                tmpMap.put("ad_number",basic.getAd_number());
                tmpMap.put("personname",basic.getPersonname());
                tmpMap.put("finish",queryList.get(i).getFinish());
                int percent = 100 * queryList.get(i).getPage_num() / DataMapService.table.length;
                percent = percent>100?100:percent;
                tmpMap.put("percent",percent);
                mapList.add(tmpMap);
            }
        }
        ModelAndView view = new ModelAndView("taskList");
        view.addObject("mapList",mapList);
        view.addObject("totalCount",page.getTotalCount());
        view.addObject("totalPage",page.getTotalPage());
        view.addObject("currentPage",page.getCurrentPage());
        return view;
    }

    @RequestMapping("/loadUnfinished")
    public void loadUnfinished(Integer task_id,HttpServletRequest request,PrintWriter out){
        request.getSession().setAttribute("task_id",task_id);
        if (((User)request.getSession().getAttribute("user_information")).getUser_id() == null){
            Task task = new Task();
            task.setTask_id(task_id);
            List<Task> taskList = taskService.query(task);
            if (taskList!=null&&taskList.size()!=0){
                task = taskList.get(0);
                request.getSession().setAttribute("basic_id",task.getBasic_id());
            }
            out.write("admin");
            return;
        }
        out.write("normal");
    }

    @RequestMapping("loadNew")
    public String loadNew(HttpServletRequest request){
        request.getSession().setAttribute("task_id",null);
        request.getSession().setAttribute("basic_id",null);
        return "main";
    }





}
