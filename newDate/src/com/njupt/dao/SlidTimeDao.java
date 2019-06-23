package com.njupt.dao;
import java.util.List;

import com.njupt.po.SlidTime;

/**
 * Created by huhui on 2017/12/4.
 */
public interface SlidTimeDao {
    SlidTime insert(SlidTime item);

    List<SlidTime> query(SlidTime item);

    void update(SlidTime item);

    void delete(SlidTime item);

}
