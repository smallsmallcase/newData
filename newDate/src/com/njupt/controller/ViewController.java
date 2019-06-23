package com.njupt.controller;

import com.njupt.po.*;
import com.njupt.service.BasicService;
import com.njupt.service.TaskService;
import com.njupt.service.util.DataMapService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huhui on 2017/12/2.
 */
@Controller
public class ViewController {

    @Resource(name = "AbnormalGestationService")
    private BasicService<AbnormalGestation> AbnormalGestationService;
    @Resource(name = "BasicInformationService")
    private BasicService<BasicInformation> BasicInformationService;
    @Resource(name = "BloodTypeCheckService")
    private BasicService<BloodTypeCheck> BloodTypeCheckService;
    @Resource(name = "BodyChangeService")
    private BasicService<BodyChange> BodyChangeService;
    @Resource(name = "CfyService")
    private BasicService<Cfy> CfyService;
    @Resource(name = "ChanKeInformationService")
    private BasicService<ChanKeInformation> ChanKeInformationService;
    @Resource(name = "ElseDiscribleService")
    private BasicService<ElseDiscrible> ElseDiscribleService;
    @Resource(name = "Else_CheckService")
    private BasicService<Else_Check> Else_CheckService;
    @Resource(name = "FamilyHistoryService")
    private BasicService<FamilyHistory> FamilyHistoryService;
    @Resource(name = "JiaGongService")
    private BasicService<JiaGong> JiaGongService;
    @Resource(name = "MarryHistoryService")
    private BasicService<MarryHistory> MarryHistoryService;
    @Resource(name = "OthersService")
    private BasicService<Others> OthersService;
    @Resource(name = "PastHistoryService")
    private BasicService<PastHistory> PastHistoryService;
    @Resource(name = "PersonHistoryService")
    private BasicService<PersonHistory> PersonHistoryService;
    @Resource(name = "PregnantBigCheckService")
    private BasicService<PregnantBigCheck> PregnantBigCheckService;
    @Resource(name = "RoutIneurineTestService")
    private BasicService<RoutIneurineTest> RoutIneurineTestService;
    @Resource(name = "RoutineBloodTestService")
    private BasicService<RoutineBloodTest> RoutineBloodTestService;
    @Resource(name = "SlidTimeService")
    private BasicService<SlidTime> SlidTimeService;
    @Resource(name = "TieDanBaiCheckService")
    private BasicService<TieDanBaiCheck> TieDanBaiCheckService;
    @Resource(name = "TodayDiseaseHistoryService")
    private BasicService<TodayDiseaseHistory> TodayDiseaseHistoryService;
    @Resource(name = "VisusEightCheckService")
    private BasicService<VisusEightCheck> VisusEightCheckService;


    private Map<String, BasicService> serviceMap;

    @Autowired
    private DataMapService dataMapService;

    @Resource(name = "TaskService")
    private BasicService<Task> taskService;

    @PostConstruct
    private void init() {
        serviceMap = new HashMap<>();
        serviceMap.put("AbnormalGestation", AbnormalGestationService);
        serviceMap.put("BasicInformation", BasicInformationService);
        serviceMap.put("BloodTypeCheck", BloodTypeCheckService);
        serviceMap.put("BodyChange", BodyChangeService);
        serviceMap.put("Cfy", CfyService);
        serviceMap.put("ChanKeInformation", ChanKeInformationService);
        serviceMap.put("ElseDiscrible", ElseDiscribleService);
        serviceMap.put("Else_Check", Else_CheckService);
        serviceMap.put("FamilyHistory", FamilyHistoryService);
        serviceMap.put("JiaGong", JiaGongService);
        serviceMap.put("MarryHistory", MarryHistoryService);
        serviceMap.put("Others", OthersService);
        serviceMap.put("PastHistory", PastHistoryService);
        serviceMap.put("PersonHistory", PersonHistoryService);
        serviceMap.put("PregnantBigCheck", PregnantBigCheckService);
        serviceMap.put("RoutIneurineTest", RoutIneurineTestService);
        serviceMap.put("RoutineBloodTest", RoutineBloodTestService);
        serviceMap.put("SlidTime", SlidTimeService);
        serviceMap.put("TieDanBaiCheck", TieDanBaiCheckService);
        serviceMap.put("TodayDiseaseHistory", TodayDiseaseHistoryService);
        serviceMap.put("VisusEightCheck", VisusEightCheckService);
    }


    @RequestMapping("/view")
    public ModelAndView view(HttpServletRequest request) {
        String path = request.getParameter("path") + "";
        ModelAndView view = new ModelAndView();
        view.setViewName(path);
        return view;

    }

    @RequestMapping("/checkBox")
    public ModelAndView checkBox(Integer index, String table_type) {

        if (index == null) {
            index = 0;
        }
        String[] table = null;
        String type = "";
        if (!"optional".equals(table_type)) {
            table = DataMapService.table;
            if (index >= table.length) {
                return new ModelAndView("optional");
            }
            type = table[index];
        } else {
            table = DataMapService.tableOptional;
            type = table[index - DataMapService.table.length];
        }
        String contextTag = dataMapService.TABLENAMEMAP.get(type);
        Map<String, String> fildAndContext = dataMapService.PROPERTIESMAP.get(type);
        ModelAndView view = new ModelAndView("save");
        view.addObject("type", type);
        view.addObject("tag", contextTag);
        view.addObject("map", fildAndContext);
        view.addObject("index", index);
        view.addObject("percent", 100 * index / DataMapService.table.length);
        return view;
    }

    @RequestMapping("/save")
    public void save(@RequestParam Map<String, String> map, HttpServletRequest request, PrintWriter out) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Integer basic_id = (Integer) request.getSession().getAttribute("basic_id");
        map.put("basic_id", String.valueOf(basic_id));
        String className = map.get("className");
        BasicService service = serviceMap.get(className);
        Object value = mapBean(className, map);

        Object result = service.insert(value);
        int index = Integer.parseInt(map.get("index"));
        Task task = new Task();

        if (index == 0) {
            basic_id = ((BasicInformation) result).getBasic_id();
            task.setFinish(0);
            User user = (User) request.getSession().getAttribute("user_information");
            task.setUser_id(user.getUser_id());
            task.setBasic_id(basic_id);
            task.setPage_num(1);
            task = taskService.insert(task);
            request.getSession().setAttribute("task_id", task.getTask_id());
            request.getSession().setAttribute("basic_id", basic_id);

        } else {
            task.setTask_id((Integer) request.getSession().getAttribute("task_id"));
            task.setPage_num(index + 1);
            if (index >= dataMapService.table.length - 1) {
                out.write("finished");
            }
            taskService.update(task);
        }
    }


    @RequestMapping("/query")
    public ModelAndView query(@RequestParam Map<String, String> map, HttpServletRequest request) {
        String className = map.get("className");
        map.put("basic_id", String.valueOf(request.getSession().getAttribute("basic_id")));
        Object value = mapBean(className, map);
        BasicService service = serviceMap.get(className);
        List result = (List) service.query(value);
        ModelAndView view = new ModelAndView();
        if (result.size() == 0) {
            view.setViewName("msgDisplay");
            view.addObject("msgInfo", "此表还未填写");
            return view;
        }
        view.setViewName("queryOrUpdate");
        view.addObject("list", result);

        String contextTag = dataMapService.TABLENAMEMAP.get(className);
        Map<String, String> fildAndContext = dataMapService.PROPERTIESMAP.get(className);
        view.addObject("primaryKey", DataMapService.PRIMARYKEYMAP.get(className));
        view.addObject("type", className);
        view.addObject("tag", contextTag);
        view.addObject("map", fildAndContext);
        return view;
    }

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam Map<String, String> map, HttpServletRequest request) {
        String className = map.get("className");
        Object value = mapBean(className, map);
        BasicService service = serviceMap.get(className);
        service.update(value);
        HashMap<String, String> tmpMap = new HashMap<>();
        tmpMap.put("className", className);
        return query(tmpMap, request);
    }

    @RequestMapping("/deleteOne")
    public ModelAndView deleteOne(@RequestParam Map<String, String> map, HttpServletRequest request) {
        String className = map.get("className");
        Object value = mapBean(className, map);
        BasicService service = serviceMap.get(className);
        service.delete(value);
        HashMap<String, String> tmpMap = new HashMap<>();
        tmpMap.put("className", className);

        Task task = new Task();
        task.setTask_id((Integer) request.getSession().getAttribute("task_id"));
        List<Task> query = taskService.query(task);
        if (query != null && query.size() > 0) {
            task.setPage_num(query.get(0).getPage_num() - 1);
        }
        taskService.update(task);
        return query(tmpMap, request);
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam Map<String, String> map) {
        String className = map.get("className");
        Object value = mapBean(className, map);
        BasicService service = serviceMap.get(className);
        service.delete(value);
        return new ModelAndView("success");
    }

    @RequestMapping("/queryInfo")
    public ModelAndView queryInfo(HttpServletRequest request) {
        Integer basic_id = (Integer) request.getSession().getAttribute("basic_id");
        if (basic_id == null) {
            Integer task_id = (Integer) request.getSession().getAttribute("task_id");
            if (task_id == null) {
                ModelAndView view = new ModelAndView("msgDisplay");
                view.addObject("msgInfo", "当前没有任务在执行");
                return view;
            }
            Task task = new Task();
            task.setTask_id(task_id);
            List<Task> taskLsit = taskService.query(task);
            if (taskLsit != null && taskLsit.size() > 0) {
                basic_id = taskLsit.get(0).getBasic_id();
                request.getSession().setAttribute("basic_id", basic_id);
            }
        }
        ModelAndView view = new ModelAndView("queryInfo");
        view.addObject("map", DataMapService.TABLENAMEMAP);
        return view;
    }

    /**
     * 将map转为指定的对象
     *
     * @param className 类名
     * @param map       参数map
     * @return 转换后的对象
     */
    private Object mapBean(String className, Map<String, String> map) {
        Object value = null;
        try {
            Class classTemp = Class.forName("com.njupt.po." + className);
            value = classTemp.newInstance();
            BeanUtils.populate(value, map);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
