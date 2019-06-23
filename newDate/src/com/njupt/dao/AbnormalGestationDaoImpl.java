package com.njupt.dao;

import com.njupt.po.AbnormalGestation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class AbnormalGestationDaoImpl implements AbnormalGestationDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public AbnormalGestation insert(AbnormalGestation item) {
        sqlsession.insert("com.njupt.AbnormalGestation.saveAbnormalGestation",item);
        return item;
    }

    @Override
    public List<AbnormalGestation> query(AbnormalGestation item) {
        return sqlsession.selectList("com.njupt.AbnormalGestation.queryAbnormalGestation",item);
    }

    @Override
    public void update(AbnormalGestation item) {
        sqlsession.update("com.njupt.AbnormalGestation.updateAbnormalGestation",item);
    }

    @Override
    public void delete(AbnormalGestation item) {
        sqlsession.delete("com.njupt.AbnormalGestation.deleteAbnormalGestation",item);
    }
}
