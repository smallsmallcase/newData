package com.njupt.dao;

import com.njupt.po.PastHistory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class PastHistoryDaoImpl implements PastHistoryDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public PastHistory insert(PastHistory item) {
        sqlsession.insert("com.njupt.PastHistory.savePastHistory",item);
        return item;
    }

    @Override
    public List<PastHistory> query(PastHistory item) {
        return sqlsession.selectList("com.njupt.PastHistory.queryPastHistory",item);
    }

    @Override
    public void update(PastHistory item) {
        sqlsession.update("com.njupt.PastHistory.updatePastHistory",item);
    }

    @Override
    public void delete(PastHistory item) {
        sqlsession.delete("com.njupt.PastHistory.deletePastHistory",item);
    }
}
