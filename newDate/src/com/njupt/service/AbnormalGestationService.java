package com.njupt.service;

import com.njupt.dao.AbnormalGestationDao;
import com.njupt.po.AbnormalGestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("AbnormalGestationService")
@Transactional
public class AbnormalGestationService implements BasicService<AbnormalGestation> {
    @Autowired
    private AbnormalGestationDao templateDao;

    public AbnormalGestation insert(AbnormalGestation item) {
        return templateDao.insert(item);
    }

    public List<AbnormalGestation> query(AbnormalGestation item) {
        return templateDao.query(item);
    }

    public void update(AbnormalGestation item) {
        templateDao.update(item);
    }

    public void delete(AbnormalGestation item) {
        templateDao.delete(item);
    }
}
