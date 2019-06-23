package com.njupt.dao;

import com.njupt.po.Page;
import com.njupt.po.Task;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public Task insert(Task item) {
        sqlsession.insert("com.njupt.Task.saveTask",item);
        return item;
    }

    @Override
    public List<Task> query(Task item) {
        return sqlsession.selectList("com.njupt.Task.queryTask",item);
    }

    @Override
    public void update(Task item) {
        sqlsession.update("com.njupt.Task.updateTask",item);
    }

    @Override
    public void delete(Task item) {
        sqlsession.delete("com.njupt.Task.deleteTask",item);
    }

    @Override
    public List<Task> queryByPage(Map param) {
        return sqlsession.selectList("com.njupt.Task.queryByPage",param);
    }

    @Override
    public Integer queryTotal(Task task) {
        return sqlsession.selectOne("com.njupt.Task.queryTotal",task);
    }

    @Override
    public List<Map<String, Object>> queryTotalForUser() {
        return sqlsession.selectList("com.njupt.Task.queryTotalForUser");
    }
}
