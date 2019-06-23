package com.njupt.dao;

import com.njupt.po.PersonHistory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class PersonHistoryDaoImpl implements PersonHistoryDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public PersonHistory insert(PersonHistory item) {
        sqlsession.insert("com.njupt.PersonHistory.savePersonHistory",item);
        return item;
    }

    @Override
    public List<PersonHistory> query(PersonHistory item) {
        return sqlsession.selectList("com.njupt.PersonHistory.queryPersonHistory",item);
    }

    @Override
    public void update(PersonHistory item) {
        sqlsession.update("com.njupt.PersonHistory.updatePersonHistory",item);
    }

    @Override
    public void delete(PersonHistory item) {
        sqlsession.delete("com.njupt.PersonHistory.deletePersonHistory",item);
    }
}
