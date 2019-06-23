package com.njupt.service;

import com.njupt.dao.RoutIneurineTestDao;
import com.njupt.po.RoutIneurineTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("RoutIneurineTestService")
@Transactional
public class RoutIneurineTestService implements BasicService<RoutIneurineTest> {
    @Autowired
    private RoutIneurineTestDao templateDao;

    public RoutIneurineTest insert(RoutIneurineTest item) {
        return templateDao.insert(item);
    }

    public List<RoutIneurineTest> query(RoutIneurineTest item) {
        return templateDao.query(item);
    }

    public void update(RoutIneurineTest item) {
        templateDao.update(item);
    }

    public void delete(RoutIneurineTest item) {
        templateDao.delete(item);
    }
}
