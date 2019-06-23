package com.njupt.service;

import com.njupt.dao.PastHistoryDao;
import com.njupt.po.PastHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("PastHistoryService")
@Transactional
public class PastHistoryService implements BasicService<PastHistory> {
    @Autowired
    private PastHistoryDao templateDao;

    public PastHistory insert(PastHistory item) {
        return templateDao.insert(item);
    }

    public List<PastHistory> query(PastHistory item) {
        return templateDao.query(item);
    }

    public void update(PastHistory item) {
        templateDao.update(item);
    }

    public void delete(PastHistory item) {
        templateDao.delete(item);
    }
}
