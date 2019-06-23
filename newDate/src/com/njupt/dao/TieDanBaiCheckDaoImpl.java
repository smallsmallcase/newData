package com.njupt.dao;

import com.njupt.po.TieDanBaiCheck;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class TieDanBaiCheckDaoImpl implements TieDanBaiCheckDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public TieDanBaiCheck insert(TieDanBaiCheck item) {
        sqlsession.insert("com.njupt.TieDanBaiCheck.saveTieDanBaiCheck",item);
        return item;
    }

    @Override
    public List<TieDanBaiCheck> query(TieDanBaiCheck item) {
        return sqlsession.selectList("com.njupt.TieDanBaiCheck.queryTieDanBaiCheck",item);
    }

    @Override
    public void update(TieDanBaiCheck item) {
        sqlsession.update("com.njupt.TieDanBaiCheck.updateTieDanBaiCheck",item);
    }

    @Override
    public void delete(TieDanBaiCheck item) {
        sqlsession.delete("com.njupt.TieDanBaiCheck.deleteTieDanBaiCheck",item);
    }
}
