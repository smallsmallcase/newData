package com.njupt.dao;

import com.njupt.po.BasicInformation;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
public interface BasicInformationDao {
    BasicInformation insert(BasicInformation item);

    List<BasicInformation> query(BasicInformation item);

    void update(BasicInformation item);

    void delete(BasicInformation item);

    List<BasicInformation> queryByBasic_ids(List<Integer> list);

}
