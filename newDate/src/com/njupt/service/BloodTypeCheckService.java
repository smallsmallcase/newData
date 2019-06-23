package com.njupt.service;

import com.njupt.dao.BloodTypeCheckDao;
import com.njupt.po.BloodTypeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("BloodTypeCheckService")
@Transactional
public class BloodTypeCheckService implements BasicService<BloodTypeCheck> {
    @Autowired
    private BloodTypeCheckDao templateDao;

    public BloodTypeCheck insert(BloodTypeCheck item) {
        return templateDao.insert(item);
    }

    public List<BloodTypeCheck> query(BloodTypeCheck item) {
        return templateDao.query(item);
    }

    public void update(BloodTypeCheck item) {
        templateDao.update(item);
    }

    public void delete(BloodTypeCheck item) {
        templateDao.delete(item);
    }
}
