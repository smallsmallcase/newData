package com.njupt.dao;

import com.njupt.po.JiaGong;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class JiaGongDaoImpl implements JiaGongDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public JiaGong insert(JiaGong item) {
        sqlsession.insert("com.njupt.JiaGong.saveJiaGong",item);
        return item;
    }

    @Override
    public List<JiaGong> query(JiaGong item) {
        return sqlsession.selectList("com.njupt.JiaGong.queryJiaGong",item);
    }

    @Override
    public void update(JiaGong item) {
        sqlsession.update("com.njupt.JiaGong.updateJiaGong",item);
    }

    @Override
    public void delete(JiaGong item) {
        sqlsession.delete("com.njupt.JiaGong.deleteJiaGong",item);
    }
}
