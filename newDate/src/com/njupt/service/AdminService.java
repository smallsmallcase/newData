package com.njupt.service;

import com.njupt.po.AdminPo;
import com.njupt.po.Page;

/**
 * Created by huhui on 2017/12/11.
 */
public interface AdminService {
    Page<AdminPo> queryByPageForAdmin(Page<AdminPo> page);

    Page<AdminPo> queryByPageForType(Page<Integer> page);
}
