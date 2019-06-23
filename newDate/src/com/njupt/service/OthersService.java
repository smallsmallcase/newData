package com.njupt.service;

import com.njupt.dao.OthersDao;
import com.njupt.po.Others;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("OthersService")
@Transactional
public class OthersService implements BasicService<Others> {
    @Autowired
    private OthersDao templateDao;

    public Others insert(Others item) {
        return templateDao.insert(item);
    }

    public List<Others> query(Others item) {
        return templateDao.query(item);
    }

    public void update(Others item) {
        templateDao.update(item);
    }

    public void delete(Others item) {
        templateDao.delete(item);
    }
}
