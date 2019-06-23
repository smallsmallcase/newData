package com.njupt.dao;

import com.njupt.po.RoutineBloodTest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class RoutineBloodTestDaoImpl implements RoutineBloodTestDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public RoutineBloodTest insert(RoutineBloodTest item) {
        sqlsession.insert("com.njupt.RoutineBloodTest.saveRoutineBloodTest",item);
        return item;
    }

    @Override
    public List<RoutineBloodTest> query(RoutineBloodTest item) {
        return sqlsession.selectList("com.njupt.RoutineBloodTest.queryRoutineBloodTest",item);
    }

    @Override
    public void update(RoutineBloodTest item) {
        sqlsession.update("com.njupt.RoutineBloodTest.updateRoutineBloodTest",item);
    }

    @Override
    public void delete(RoutineBloodTest item) {
        sqlsession.delete("com.njupt.RoutineBloodTest.deleteRoutineBloodTest",item);
    }
}
