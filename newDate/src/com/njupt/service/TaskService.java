package com.njupt.service;

import com.njupt.dao.TaskDao;
import com.njupt.dao.UserDao;
import com.njupt.po.Page;
import com.njupt.po.Task;
import com.njupt.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("TaskService")
@Transactional
public class TaskService implements BasicService<Task> ,QueryByPage<Task>{
    @Autowired
    private TaskDao templateDao;

    @Autowired
    private UserDao userDao;

    public Task insert(Task item) {
        return templateDao.insert(item);
    }

    public List<Task> query(Task item) {
        return templateDao.query(item);
    }

    public void update(Task item) {
        templateDao.update(item);
    }

    public void delete(Task item) {
        templateDao.delete(item);
    }


    @Override
    public Page<Task> queryByPage(Page<Task> page) {
        Integer currentPage = page.getCurrentPage();
        Integer pageSize = page.getPageSize();
        Task task = new Task();
        List<Task> dataList = page.getDataList();
        if (dataList != null&&!dataList.isEmpty()){
            task = dataList.get(0);
        }
        HashMap<String, Object> param = new HashMap<>();
        param.put("pageSize",pageSize);
        param.put("start",(currentPage-1)*pageSize);
        param.put("user_id",task.getUser_id());
        List<Task> taskList = templateDao.queryByPage(param);
        int totalCount = templateDao.queryTotal(task);


        page.setDataList(taskList);
        page.setTotalCount(totalCount);
        page.setTotalPage(
                page.getTotalCount()%page.getPageSize() == 0
                        ?page.getTotalCount()/page.getPageSize()
                        :page.getTotalCount()/page.getPageSize()+1);
        return page;
    }

    @Override
    public Map<User, Long> queryTotalForUser() {
        Map<Integer, Long> mapTmp = new HashMap<>();
        List<Integer> user_idList = new ArrayList<>();
        List<Map<String, Object>> mapList = templateDao.queryTotalForUser();
        for (Map<String,Object> item:mapList) {
            mapTmp.put((Integer) item.get("user_id"), (long)item.get("count(user_id)"));
            user_idList.add((Integer) item.get("user_id"));
        }
        List<User> userList = userDao.queryByIds(user_idList);
        HashMap<User, Long> result = new HashMap<>();
       if (userList != null&&!userList.isEmpty()){
           for (User user:userList) {
               Integer user_id = user.getUser_id();
               result.put(user,mapTmp.get(user_id));
           }
       }
        return result;
    }
}
