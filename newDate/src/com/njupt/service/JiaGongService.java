package com.njupt.service;

import com.njupt.dao.JiaGongDao;
import com.njupt.po.JiaGong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("JiaGongService")
@Transactional
public class JiaGongService implements BasicService<JiaGong> {
    @Autowired
    private JiaGongDao templateDao;

    public JiaGong insert(JiaGong item) {
        return templateDao.insert(item);
    }

    public List<JiaGong> query(JiaGong item) {
        return templateDao.query(item);
    }

    public void update(JiaGong item) {
        templateDao.update(item);
    }

    public void delete(JiaGong item) {
        templateDao.delete(item);
    }
}
