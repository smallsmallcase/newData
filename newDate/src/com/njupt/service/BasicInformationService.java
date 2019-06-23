package com.njupt.service;

import com.njupt.dao.BasicInformationDao;
import com.njupt.po.BasicInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("BasicInformationService")
@Transactional
public class BasicInformationService implements BasicService<BasicInformation>,BatchQuery<BasicInformation> {
    @Autowired
    private BasicInformationDao templateDao;

    public BasicInformation insert(BasicInformation item) {
        return templateDao.insert(item);
    }

    public List<BasicInformation> query(BasicInformation item) {
        return templateDao.query(item);
    }

    public void update(BasicInformation item) {
        templateDao.update(item);
    }

    public void delete(BasicInformation item) {
        templateDao.delete(item);
    }

    public List<BasicInformation> queryByBasic_ids(List<Integer> list) {

        return templateDao.queryByBasic_ids(list);
    }

}
