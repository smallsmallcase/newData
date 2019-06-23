package com.njupt.dao;

import com.njupt.po.MarryHistory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class MarryHistoryDaoImpl implements MarryHistoryDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public MarryHistory insert(MarryHistory item) {
        sqlsession.insert("com.njupt.MarryHistory.saveMarryHistory",item);
        return item;
    }

    @Override
    public List<MarryHistory> query(MarryHistory item) {
        return sqlsession.selectList("com.njupt.MarryHistory.queryMarryHistory",item);
    }

    @Override
    public void update(MarryHistory item) {
        sqlsession.update("com.njupt.MarryHistory.updateMarryHistory",item);
    }

    @Override
    public void delete(MarryHistory item) {
        sqlsession.delete("com.njupt.MarryHistory.deleteMarryHistory",item);
    }
}
