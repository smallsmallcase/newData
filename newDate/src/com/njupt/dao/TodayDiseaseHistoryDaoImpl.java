package com.njupt.dao;

import com.njupt.po.TodayDiseaseHistory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class TodayDiseaseHistoryDaoImpl implements TodayDiseaseHistoryDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public TodayDiseaseHistory insert(TodayDiseaseHistory item) {
        sqlsession.insert("com.njupt.TodayDiseaseHistory.saveTodayDiseaseHistory",item);
        return item;
    }

    @Override
    public List<TodayDiseaseHistory> query(TodayDiseaseHistory item) {
        return sqlsession.selectList("com.njupt.TodayDiseaseHistory.queryTodayDiseaseHistory",item);
    }

    @Override
    public void update(TodayDiseaseHistory item) {
        sqlsession.update("com.njupt.TodayDiseaseHistory.updateTodayDiseaseHistory",item);
    }

    @Override
    public void delete(TodayDiseaseHistory item) {
        sqlsession.delete("com.njupt.TodayDiseaseHistory.deleteTodayDiseaseHistory",item);
    }
}
