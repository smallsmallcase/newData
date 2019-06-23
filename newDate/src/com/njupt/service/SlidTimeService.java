package com.njupt.service;

import com.njupt.dao.SlidTimeDao;
import com.njupt.po.SlidTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("SlidTimeService")
@Transactional
public class SlidTimeService implements BasicService<SlidTime> {
    @Autowired
    private SlidTimeDao templateDao;

    public SlidTime insert(SlidTime item) {
        return templateDao.insert(item);
    }

    public List<SlidTime> query(SlidTime item) {
        return templateDao.query(item);
    }

    public void update(SlidTime item) {
        templateDao.update(item);
    }

    public void delete(SlidTime item) {
        templateDao.delete(item);
    }
}
