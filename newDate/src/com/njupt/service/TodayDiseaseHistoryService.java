package com.njupt.service;

import com.njupt.dao.TodayDiseaseHistoryDao;
import com.njupt.po.TodayDiseaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("TodayDiseaseHistoryService")
@Transactional
public class TodayDiseaseHistoryService implements BasicService<TodayDiseaseHistory> {
    @Autowired
    private TodayDiseaseHistoryDao templateDao;

    public TodayDiseaseHistory insert(TodayDiseaseHistory item) {
        return templateDao.insert(item);
    }

    public List<TodayDiseaseHistory> query(TodayDiseaseHistory item) {
        return templateDao.query(item);
    }

    public void update(TodayDiseaseHistory item) {
        templateDao.update(item);
    }

    public void delete(TodayDiseaseHistory item) {
        templateDao.delete(item);
    }
}
