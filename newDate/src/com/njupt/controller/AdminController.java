package com.njupt.controller;

import com.njupt.po.AdminPo;
import com.njupt.po.HeadCount;
import com.njupt.po.Page;
import com.njupt.po.User;
import com.njupt.service.AdminService;
import com.njupt.service.HeadCountService;
import com.njupt.service.QueryByPage;
import com.njupt.service.util.DataMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by huhui on 2017/12/11.
 */

@Controller
public class AdminController {


    @Resource(name = "TaskService")
    private QueryByPage queryByPageForTask;
    @Autowired
    private AdminService adminService;

    @Autowired
    private HeadCountService headCountService;

    @RequestMapping("/countTask")
    public ModelAndView countTask(){
        Map<User,Long> map = queryByPageForTask.queryTotalForUser();
        Collection<Long> values = map.values();
        long total = 0L;
        for (long item : values) {
            total+= item;
        }
        HeadCount headCount = headCountService.getHeadCount();
        ModelAndView view = new ModelAndView("admin");
        view.addObject("total",total);
        view.addObject("map",map);
        /*妊娠糖尿病人数*/
        view.addObject("diabetesHC",headCount.getDiabetesHC());
        /*妊娠高血压人数*/
        view.addObject("hypertensionHC",headCount.getHypertensionHC());
        view.addObject("bothHC",headCount.getBothHC());
        view.addObject("healthHC",total-headCount.getDiabetesHC()-headCount.getHypertensionHC()+headCount.getBothHC());
        return view;
    }

    @RequestMapping("/taskListForAdmin")
    public ModelAndView taskListForAdmin(HttpServletRequest request, Integer currentPage, AdminPo adminPo){
        Page<AdminPo> page = new Page<>();
        ArrayList<AdminPo> adminPos = new ArrayList<>();
        if (adminPo.getPersonname() != null && adminPo.getPersonname().trim().length() == 0){
            adminPo.setPersonname(null);
        }
        if (adminPo.getUser_name() != null && adminPo.getUser_name().trim().length() == 0){
            adminPo.setUser_name(null);
        }
        adminPos.add(adminPo);
        page.setDataList(adminPos);
        page.setCurrentPage(currentPage == null ?1:currentPage);
        Page<AdminPo> adminPoPage = adminService.queryByPageForAdmin(page);
        List<AdminPo> dataList = adminPoPage.getDataList();
        if (dataList == null || dataList.size() == 0){
            ModelAndView view = new ModelAndView("msgDisplay");
            view.addObject("msgInfo","没有满足条件的查询结果");
            return view;
        }
        ArrayList<HashMap<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            Integer basic_id = dataList.get(i).getBasic_id();
            HashMap<String, Object> tmpMap = new HashMap<>();
            tmpMap.put("task_id",dataList.get(i).getTask_id());
            tmpMap.put("ad_number",dataList.get(i).getAd_number());
            tmpMap.put("personname",dataList.get(i).getPersonname());
            tmpMap.put("finish",dataList.get(i).getFinish());
            tmpMap.put("percent",100*dataList.get(i).getPage_num()/ DataMapService.table.length);
            mapList.add(tmpMap);
        }

        ModelAndView view = new ModelAndView("taskList");
        view.addObject("mapList", mapList);
        view.addObject("totalCount",adminPoPage.getTotalCount());
        view.addObject("totalPage",adminPoPage.getTotalPage());
        view.addObject("currentPage",adminPoPage.getCurrentPage());
        return view;
    }


    @RequestMapping("/taskListForType")
    public ModelAndView taskListForType(HttpServletRequest request, Integer currentPage, Integer type){
        Page<Integer> page = new Page<>();
        ArrayList<Integer> is = new ArrayList<>();
        is.add(type);
        page.setDataList(is);
        page.setCurrentPage(currentPage == null ?1:currentPage);
        Page<AdminPo> adminPoPage = adminService.queryByPageForType(page);
        List<AdminPo> dataList = adminPoPage.getDataList();
        if (dataList == null || dataList.size() == 0){
            ModelAndView view = new ModelAndView("msgDisplay");
            view.addObject("msgInfo","没有满足条件的查询结果");
            return view;
        }
        ArrayList<HashMap<String, Object>> mapList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            Integer basic_id = dataList.get(i).getBasic_id();
            HashMap<String, Object> tmpMap = new HashMap<>();
            tmpMap.put("task_id",dataList.get(i).getTask_id());
            tmpMap.put("ad_number",dataList.get(i).getAd_number());
            tmpMap.put("personname",dataList.get(i).getPersonname());
            tmpMap.put("finish",dataList.get(i).getFinish());
            tmpMap.put("percent",100*dataList.get(i).getPage_num()/ DataMapService.table.length);
            mapList.add(tmpMap);
        }

        ModelAndView view = new ModelAndView("taskListForType");
        view.addObject("mapList", mapList);
        view.addObject("totalCount",adminPoPage.getTotalCount());
        view.addObject("totalPage",adminPoPage.getTotalPage());
        view.addObject("currentPage",adminPoPage.getCurrentPage());
        view.addObject("type",type);
        return view;
    }
}
