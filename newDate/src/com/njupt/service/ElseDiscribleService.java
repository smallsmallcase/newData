package com.njupt.service;

import com.njupt.dao.ElseDiscribleDao;
import com.njupt.po.ElseDiscrible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("ElseDiscribleService")
@Transactional
public class ElseDiscribleService implements BasicService<ElseDiscrible> {
    @Autowired
    private ElseDiscribleDao templateDao;

    public ElseDiscrible insert(ElseDiscrible item) {
        return templateDao.insert(item);
    }

    public List<ElseDiscrible> query(ElseDiscrible item) {
        return templateDao.query(item);
    }

    public void update(ElseDiscrible item) {
        templateDao.update(item);
    }

    public void delete(ElseDiscrible item) {
        templateDao.delete(item);
    }
}
