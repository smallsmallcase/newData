package com.njupt.dao;

import com.njupt.po.BasicInformation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class BasicInformationDaoImpl implements BasicInformationDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public BasicInformation insert(BasicInformation item) {
        sqlsession.insert("com.njupt.BasicInformation.saveBasicInformation",item);
        return item;
    }

    @Override
    public List<BasicInformation> query(BasicInformation item) {
        return sqlsession.selectList("com.njupt.BasicInformation.queryBasicInformation",item);
    }

    @Override
    public void update(BasicInformation item) {
        sqlsession.update("com.njupt.BasicInformation.updateBasicInformation",item);
    }

    @Override
    public void delete(BasicInformation item) {
        sqlsession.delete("com.njupt.BasicInformation.deleteBasicInformation",item);
    }

    @Override
    public List<BasicInformation> queryByBasic_ids(List<Integer> list) {

        return sqlsession.selectList("com.njupt.BasicInformation.selectListByBasic_id",list);
    }


}
