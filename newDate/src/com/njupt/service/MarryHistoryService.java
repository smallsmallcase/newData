package com.njupt.service;

import com.njupt.dao.MarryHistoryDao;
import com.njupt.po.MarryHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("MarryHistoryService")
@Transactional
public class MarryHistoryService implements BasicService<MarryHistory> {
    @Autowired
    private MarryHistoryDao templateDao;

    public MarryHistory insert(MarryHistory item) {
        return templateDao.insert(item);
    }

    public List<MarryHistory> query(MarryHistory item) {
        return templateDao.query(item);
    }

    public void update(MarryHistory item) {
        templateDao.update(item);
    }

    public void delete(MarryHistory item) {
        templateDao.delete(item);
    }
}
