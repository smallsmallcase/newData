package com.njupt.dao;

import com.njupt.po.PregnantBigCheck;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class PregnantBigCheckDaoImpl implements PregnantBigCheckDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public PregnantBigCheck insert(PregnantBigCheck item) {
        sqlsession.insert("com.njupt.PregnantBigCheck.savePregnantBigCheck",item);
        return item;
    }

    @Override
    public List<PregnantBigCheck> query(PregnantBigCheck item) {
        return sqlsession.selectList("com.njupt.PregnantBigCheck.queryPregnantBigCheck",item);
    }

    @Override
    public void update(PregnantBigCheck item) {
        sqlsession.update("com.njupt.PregnantBigCheck.updatePregnantBigCheck",item);
    }

    @Override
    public void delete(PregnantBigCheck item) {
        sqlsession.delete("com.njupt.PregnantBigCheck.deletePregnantBigCheck",item);
    }
}
