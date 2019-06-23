package com.njupt.service;

import com.njupt.dao.ChanKeInformationDao;
import com.njupt.po.ChanKeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("ChanKeInformationService")
@Transactional
public class ChanKeInformationService implements BasicService<ChanKeInformation> {
    @Autowired
    private ChanKeInformationDao templateDao;

    public ChanKeInformation insert(ChanKeInformation item) {
        return templateDao.insert(item);
    }

    public List<ChanKeInformation> query(ChanKeInformation item) {
        return templateDao.query(item);
    }

    public void update(ChanKeInformation item) {
        templateDao.update(item);
    }

    public void delete(ChanKeInformation item) {
        templateDao.delete(item);
    }
}
