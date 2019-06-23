package com.njupt.dao;

import com.njupt.po.FamilyHistory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class FamilyHistoryDaoImpl implements FamilyHistoryDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public FamilyHistory insert(FamilyHistory item) {
        sqlsession.insert("com.njupt.FamilyHistory.saveFamilyHistory",item);
        return item;
    }

    @Override
    public List<FamilyHistory> query(FamilyHistory item) {
        return sqlsession.selectList("com.njupt.FamilyHistory.queryFamilyHistory",item);
    }

    @Override
    public void update(FamilyHistory item) {
        sqlsession.update("com.njupt.FamilyHistory.updateFamilyHistory",item);
    }

    @Override
    public void delete(FamilyHistory item) {
        sqlsession.delete("com.njupt.FamilyHistory.deleteFamilyHistory",item);
    }
}
