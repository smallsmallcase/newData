package com.njupt.dao;

import com.njupt.po.RoutIneurineTest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class RoutIneurineTestDaoImpl implements RoutIneurineTestDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public RoutIneurineTest insert(RoutIneurineTest item) {
        sqlsession.insert("com.njupt.RoutIneurineTest.saveRoutIneurineTest",item);
        return item;
    }

    @Override
    public List<RoutIneurineTest> query(RoutIneurineTest item) {
        return sqlsession.selectList("com.njupt.RoutIneurineTest.queryRoutIneurineTest",item);
    }

    @Override
    public void update(RoutIneurineTest item) {
        sqlsession.update("com.njupt.RoutIneurineTest.updateRoutIneurineTest",item);
    }

    @Override
    public void delete(RoutIneurineTest item) {
        sqlsession.delete("com.njupt.RoutIneurineTest.deleteRoutIneurineTest",item);
    }
}
