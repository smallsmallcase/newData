package com.njupt.dao;
import java.util.List;

import com.njupt.po.TodayDiseaseHistory;

/**
 * Created by huhui on 2017/12/4.
 */
public interface TodayDiseaseHistoryDao {
    TodayDiseaseHistory insert(TodayDiseaseHistory item);

    List<TodayDiseaseHistory> query(TodayDiseaseHistory item);

    void update(TodayDiseaseHistory item);

    void delete(TodayDiseaseHistory item);

}
