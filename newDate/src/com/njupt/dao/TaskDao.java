package com.njupt.dao;
import java.util.List;
import java.util.Map;

import com.njupt.po.Task;

/**
 * Created by huhui on 2017/12/4.
 */
public interface TaskDao {
    Task insert(Task item);

    List<Task> query(Task item);

    void update(Task item);

    void delete(Task item);

    List<Task> queryByPage(Map param);

    Integer queryTotal(Task task);

    List<Map<String, Object>> queryTotalForUser();
}
