package com.njupt.service;

import com.njupt.dao.BodyChangeDao;
import com.njupt.po.BodyChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("BodyChangeService")
@Transactional
public class BodyChangeService implements BasicService<BodyChange> {
    @Autowired
    private BodyChangeDao templateDao;

    public BodyChange insert(BodyChange item) {
        return templateDao.insert(item);
    }

    public List<BodyChange> query(BodyChange item) {
        return templateDao.query(item);
    }

    public void update(BodyChange item) {
        templateDao.update(item);
    }

    public void delete(BodyChange item) {
        templateDao.delete(item);
    }
}
