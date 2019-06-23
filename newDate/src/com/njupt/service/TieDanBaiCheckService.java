package com.njupt.service;

import com.njupt.dao.TieDanBaiCheckDao;
import com.njupt.po.TieDanBaiCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("TieDanBaiCheckService")
@Transactional
public class TieDanBaiCheckService implements BasicService<TieDanBaiCheck> {
    @Autowired
    private TieDanBaiCheckDao templateDao;

    public TieDanBaiCheck insert(TieDanBaiCheck item) {
        return templateDao.insert(item);
    }

    public List<TieDanBaiCheck> query(TieDanBaiCheck item) {
        return templateDao.query(item);
    }

    public void update(TieDanBaiCheck item) {
        templateDao.update(item);
    }

    public void delete(TieDanBaiCheck item) {
        templateDao.delete(item);
    }
}
