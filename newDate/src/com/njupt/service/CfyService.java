package com.njupt.service;

import com.njupt.dao.CfyDao;
import com.njupt.po.Cfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("CfyService")
@Transactional
public class CfyService implements BasicService<Cfy> {
    @Autowired
    private CfyDao templateDao;

    public Cfy insert(Cfy item) {
        return templateDao.insert(item);
    }

    public List<Cfy> query(Cfy item) {
        return templateDao.query(item);
    }

    public void update(Cfy item) {
        templateDao.update(item);
    }

    public void delete(Cfy item) {
        templateDao.delete(item);
    }
}
