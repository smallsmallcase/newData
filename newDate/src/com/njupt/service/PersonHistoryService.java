package com.njupt.service;

import com.njupt.dao.PersonHistoryDao;
import com.njupt.po.PersonHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("PersonHistoryService")
@Transactional
public class PersonHistoryService implements BasicService<PersonHistory> {
    @Autowired
    private PersonHistoryDao templateDao;

    public PersonHistory insert(PersonHistory item) {
        return templateDao.insert(item);
    }

    public List<PersonHistory> query(PersonHistory item) {
        return templateDao.query(item);
    }

    public void update(PersonHistory item) {
        templateDao.update(item);
    }

    public void delete(PersonHistory item) {
        templateDao.delete(item);
    }
}
