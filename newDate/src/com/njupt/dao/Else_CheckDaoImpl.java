package com.njupt.dao;

import com.njupt.po.Else_Check;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class Else_CheckDaoImpl implements Else_CheckDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public Else_Check insert(Else_Check item) {
        sqlsession.insert("com.njupt.Else_Check.saveElse_Check",item);
        return item;
    }

    @Override
    public List<Else_Check> query(Else_Check item) {
        return sqlsession.selectList("com.njupt.Else_Check.queryElse_Check",item);
    }

    @Override
    public void update(Else_Check item) {
        sqlsession.update("com.njupt.Else_Check.updateElse_Check",item);
    }

    @Override
    public void delete(Else_Check item) {
        sqlsession.delete("com.njupt.Else_Check.deleteElse_Check",item);
    }
}
