package com.njupt.service;

import com.njupt.dao.VisusEightCheckDao;
import com.njupt.po.VisusEightCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("VisusEightCheckService")
@Transactional
public class VisusEightCheckService implements BasicService<VisusEightCheck> {
    @Autowired
    private VisusEightCheckDao templateDao;

    public VisusEightCheck insert(VisusEightCheck item) {
        return templateDao.insert(item);
    }

    public List<VisusEightCheck> query(VisusEightCheck item) {
        return templateDao.query(item);
    }

    public void update(VisusEightCheck item) {
        templateDao.update(item);
    }

    public void delete(VisusEightCheck item) {
        templateDao.delete(item);
    }
}
