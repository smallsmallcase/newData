package com.njupt.dao;

import com.njupt.po.ElseDiscrible;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class ElseDiscribleDaoImpl implements ElseDiscribleDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public ElseDiscrible insert(ElseDiscrible item) {
        sqlsession.insert("com.njupt.ElseDiscrible.saveElseDiscrible",item);
        return item;
    }

    @Override
    public List<ElseDiscrible> query(ElseDiscrible item) {
        return sqlsession.selectList("com.njupt.ElseDiscrible.queryElseDiscrible",item);
    }

    @Override
    public void update(ElseDiscrible item) {
        sqlsession.update("com.njupt.ElseDiscrible.updateElseDiscrible",item);
    }

    @Override
    public void delete(ElseDiscrible item) {
        sqlsession.delete("com.njupt.ElseDiscrible.deleteElseDiscrible",item);
    }
}
