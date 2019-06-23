package com.njupt.dao;

import com.njupt.po.BloodTypeCheck;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class BloodTypeCheckDaoImpl implements BloodTypeCheckDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public BloodTypeCheck insert(BloodTypeCheck item) {
        sqlsession.insert("com.njupt.BloodTypeCheck.saveBloodTypeCheck",item);
        return item;
    }

    @Override
    public List<BloodTypeCheck> query(BloodTypeCheck item) {
        return sqlsession.selectList("com.njupt.BloodTypeCheck.queryBloodTypeCheck",item);
    }

    @Override
    public void update(BloodTypeCheck item) {
        sqlsession.update("com.njupt.BloodTypeCheck.updateBloodTypeCheck",item);
    }

    @Override
    public void delete(BloodTypeCheck item) {
        sqlsession.delete("com.njupt.BloodTypeCheck.deleteBloodTypeCheck",item);
    }
}
