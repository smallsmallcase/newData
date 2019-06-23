package com.njupt.dao;

import com.njupt.po.AdminPo;
import com.njupt.po.Page;
import org.springframework.stereotype.Repository;

/**
 * Created by huhui on 2017/12/11.
 */

public interface AdminDao {
    Page<AdminPo> queryByPageForAdmin( Page<AdminPo> page);

    Page<AdminPo> queryByPageForType(Page<Integer> page);
}
