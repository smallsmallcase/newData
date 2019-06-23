package com.njupt.dao;

import com.njupt.po.Cfy;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class CfyDaoImpl implements CfyDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public Cfy insert(Cfy item) {
        sqlsession.insert("com.njupt.Cfy.saveCfy",item);
        return item;
    }

    @Override
    public List<Cfy> query(Cfy item) {
        return sqlsession.selectList("com.njupt.Cfy.queryCfy",item);
    }

    @Override
    public void update(Cfy item) {
        sqlsession.update("com.njupt.Cfy.updateCfy",item);
    }

    @Override
    public void delete(Cfy item) {
        sqlsession.delete("com.njupt.Cfy.deleteCfy",item);
    }
}
