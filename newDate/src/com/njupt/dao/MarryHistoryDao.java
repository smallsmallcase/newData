package com.njupt.dao;
import java.util.List;

import com.njupt.po.MarryHistory;

/**
 * Created by huhui on 2017/12/4.
 */
public interface MarryHistoryDao {
    MarryHistory insert(MarryHistory item);

    List<MarryHistory> query(MarryHistory item);

    void update(MarryHistory item);

    void delete(MarryHistory item);

}
