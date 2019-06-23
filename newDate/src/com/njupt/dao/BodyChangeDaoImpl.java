package com.njupt.dao;

import com.njupt.po.BodyChange;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class BodyChangeDaoImpl implements BodyChangeDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public BodyChange insert(BodyChange item) {
        sqlsession.insert("com.njupt.BodyChange.saveBodyChange",item);
        return item;
    }

    @Override
    public List<BodyChange> query(BodyChange item) {
        return sqlsession.selectList("com.njupt.BodyChange.queryBodyChange",item);
    }

    @Override
    public void update(BodyChange item) {
        sqlsession.update("com.njupt.BodyChange.updateBodyChange",item);
    }

    @Override
    public void delete(BodyChange item) {
        sqlsession.delete("com.njupt.BodyChange.deleteBodyChange",item);
    }
}
