package com.njupt.service;

import com.njupt.dao.FamilyHistoryDao;
import com.njupt.po.FamilyHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("FamilyHistoryService")
@Transactional
public class FamilyHistoryService implements BasicService<FamilyHistory> {
    @Autowired
    private FamilyHistoryDao templateDao;

    public FamilyHistory insert(FamilyHistory item) {
        return templateDao.insert(item);
    }

    public List<FamilyHistory> query(FamilyHistory item) {
        return templateDao.query(item);
    }

    public void update(FamilyHistory item) {
        templateDao.update(item);
    }

    public void delete(FamilyHistory item) {
        templateDao.delete(item);
    }
}
