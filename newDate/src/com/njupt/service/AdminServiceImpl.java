package com.njupt.service;

import com.njupt.dao.AdminDao;
import com.njupt.po.AdminPo;
import com.njupt.po.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huhui on 2017/12/11.
 */
@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Page<AdminPo> queryByPageForAdmin(Page<AdminPo> page) {
        return adminDao.queryByPageForAdmin(page);
    }

    @Override
    public Page<AdminPo> queryByPageForType(Page<Integer> page) {
        return  adminDao.queryByPageForType(page);
    }
}
