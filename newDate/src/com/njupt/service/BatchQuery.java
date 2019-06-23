package com.njupt.service;

import com.njupt.po.BasicInformation;

import java.util.List;

/**
 * Created by huhui on 2017/12/7.
 */
public interface BatchQuery<T> {
     List<T> queryByBasic_ids(List<Integer> list);
}
