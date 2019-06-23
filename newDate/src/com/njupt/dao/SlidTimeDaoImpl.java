package com.njupt.dao;

import com.njupt.po.SlidTime;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class SlidTimeDaoImpl implements SlidTimeDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public SlidTime insert(SlidTime item) {
        sqlsession.insert("com.njupt.SlidTime.saveSlidTime",item);
        return item;
    }

    @Override
    public List<SlidTime> query(SlidTime item) {
        return sqlsession.selectList("com.njupt.SlidTime.querySlidTime",item);
    }

    @Override
    public void update(SlidTime item) {
        sqlsession.update("com.njupt.SlidTime.updateSlidTime",item);
    }

    @Override
    public void delete(SlidTime item) {
        sqlsession.delete("com.njupt.SlidTime.deleteSlidTime",item);
    }
}
