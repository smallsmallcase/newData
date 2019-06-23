package com.njupt.service;

import com.njupt.po.Page;
import com.njupt.po.User;

import java.util.Map;

/**
 * Created by huhui on 2017/12/8.
 */
public interface QueryByPage<T> {
    Page<T> queryByPage(Page<T> page);

    Map<User,Long>queryTotalForUser();
}
