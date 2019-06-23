package com.njupt.dao;
import java.util.List;

import com.njupt.po.BloodTypeCheck;

/**
 * Created by huhui on 2017/12/4.
 */
public interface BloodTypeCheckDao {
    BloodTypeCheck insert(BloodTypeCheck item);

    List<BloodTypeCheck> query(BloodTypeCheck item);

    void update(BloodTypeCheck item);

    void delete(BloodTypeCheck item);

}
