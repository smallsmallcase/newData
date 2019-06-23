package com.njupt.dao;

import com.njupt.po.ChanKeInformation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class ChanKeInformationDaoImpl implements ChanKeInformationDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public ChanKeInformation insert(ChanKeInformation item) {
        sqlsession.insert("com.njupt.ChanKeInformation.saveChanKeInformation",item);
        return item;
    }

    @Override
    public List<ChanKeInformation> query(ChanKeInformation item) {
        return sqlsession.selectList("com.njupt.ChanKeInformation.queryChanKeInformation",item);
    }

    @Override
    public void update(ChanKeInformation item) {
        sqlsession.update("com.njupt.ChanKeInformation.updateChanKeInformation",item);
    }

    @Override
    public void delete(ChanKeInformation item) {
        sqlsession.delete("com.njupt.ChanKeInformation.deleteChanKeInformation",item);
    }
}
