package com.njupt.dao;
import java.util.List;

import com.njupt.po.VisusEightCheck;

/**
 * Created by huhui on 2017/12/4.
 */
public interface VisusEightCheckDao {
    VisusEightCheck insert(VisusEightCheck item);

    List<VisusEightCheck> query(VisusEightCheck item);

    void update(VisusEightCheck item);

    void delete(VisusEightCheck item);

}
