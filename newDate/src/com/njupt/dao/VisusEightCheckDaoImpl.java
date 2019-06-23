package com.njupt.dao;

import com.njupt.po.VisusEightCheck;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class VisusEightCheckDaoImpl implements VisusEightCheckDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public VisusEightCheck insert(VisusEightCheck item) {
        sqlsession.insert("com.njupt.VisusEightCheck.saveVisusEightCheck",item);
        return item;
    }

    @Override
    public List<VisusEightCheck> query(VisusEightCheck item) {
        return sqlsession.selectList("com.njupt.VisusEightCheck.queryVisusEightCheck",item);
    }

    @Override
    public void update(VisusEightCheck item) {
        sqlsession.update("com.njupt.VisusEightCheck.updateVisusEightCheck",item);
    }

    @Override
    public void delete(VisusEightCheck item) {
        sqlsession.delete("com.njupt.VisusEightCheck.deleteVisusEightCheck",item);
    }
}
