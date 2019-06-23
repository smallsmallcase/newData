package com.njupt.service;

import com.njupt.dao.PregnantBigCheckDao;
import com.njupt.po.PregnantBigCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("PregnantBigCheckService")
@Transactional
public class PregnantBigCheckService implements BasicService<PregnantBigCheck> {
    @Autowired
    private PregnantBigCheckDao templateDao;

    public PregnantBigCheck insert(PregnantBigCheck item) {
        return templateDao.insert(item);
    }

    public List<PregnantBigCheck> query(PregnantBigCheck item) {
        return templateDao.query(item);
    }

    public void update(PregnantBigCheck item) {
        templateDao.update(item);
    }

    public void delete(PregnantBigCheck item) {
        templateDao.delete(item);
    }
}
