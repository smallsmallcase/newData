package com.njupt.service;

import com.njupt.dao.RoutineBloodTestDao;
import com.njupt.po.RoutineBloodTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("RoutineBloodTestService")
@Transactional
public class RoutineBloodTestService implements BasicService<RoutineBloodTest> {
    @Autowired
    private RoutineBloodTestDao templateDao;

    public RoutineBloodTest insert(RoutineBloodTest item) {
        return templateDao.insert(item);
    }

    public List<RoutineBloodTest> query(RoutineBloodTest item) {
        return templateDao.query(item);
    }

    public void update(RoutineBloodTest item) {
        templateDao.update(item);
    }

    public void delete(RoutineBloodTest item) {
        templateDao.delete(item);
    }
}
