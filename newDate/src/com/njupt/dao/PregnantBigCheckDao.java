package com.njupt.dao;
import java.util.List;

import com.njupt.po.PregnantBigCheck;

/**
 * Created by huhui on 2017/12/4.
 */
public interface PregnantBigCheckDao {
    PregnantBigCheck insert(PregnantBigCheck item);

    List<PregnantBigCheck> query(PregnantBigCheck item);

    void update(PregnantBigCheck item);

    void delete(PregnantBigCheck item);

}
