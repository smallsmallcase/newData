package com.njupt.dao;
import java.util.List;

import com.njupt.po.FamilyHistory;

/**
 * Created by huhui on 2017/12/4.
 */
public interface FamilyHistoryDao {
    FamilyHistory insert(FamilyHistory item);

    List<FamilyHistory> query(FamilyHistory item);

    void update(FamilyHistory item);

    void delete(FamilyHistory item);

}
