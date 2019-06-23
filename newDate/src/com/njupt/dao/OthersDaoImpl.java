package com.njupt.dao;

import com.njupt.po.Others;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class OthersDaoImpl implements OthersDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public Others insert(Others item) {
        sqlsession.insert("com.njupt.Others.saveOthers",item);
        return item;
    }

    @Override
    public List<Others> query(Others item) {
        return sqlsession.selectList("com.njupt.Others.queryOthers",item);
    }

    @Override
    public void update(Others item) {
        sqlsession.update("com.njupt.Others.updateOthers",item);
    }

    @Override
    public void delete(Others item) {
        sqlsession.delete("com.njupt.Others.deleteOthers",item);
    }
}
