package com.njupt.dao;
import java.util.List;

import com.njupt.po.PersonHistory;

/**
 * Created by huhui on 2017/12/4.
 */
public interface PersonHistoryDao {
    PersonHistory insert(PersonHistory item);

    List<PersonHistory> query(PersonHistory item);

    void update(PersonHistory item);

    void delete(PersonHistory item);

}
