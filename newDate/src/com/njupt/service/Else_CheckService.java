package com.njupt.service;

import com.njupt.dao.Else_CheckDao;
import com.njupt.po.Else_Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("Else_CheckService")
@Transactional
public class Else_CheckService implements BasicService<Else_Check> {
    @Autowired
    private Else_CheckDao templateDao;

    public Else_Check insert(Else_Check item) {
        return templateDao.insert(item);
    }

    public List<Else_Check> query(Else_Check item) {
        return templateDao.query(item);
    }

    public void update(Else_Check item) {
        templateDao.update(item);
    }

    public void delete(Else_Check item) {
        templateDao.delete(item);
    }
}
