package com.njupt.dao;
import java.util.List;

import com.njupt.po.PastHistory;

/**
 * Created by huhui on 2017/12/4.
 */
public interface PastHistoryDao {
    PastHistory insert(PastHistory item);

    List<PastHistory> query(PastHistory item);

    void update(PastHistory item);

    void delete(PastHistory item);

}
