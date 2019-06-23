package com.njupt.dao;
import java.util.List;

import com.njupt.po.RoutIneurineTest;

/**
 * Created by huhui on 2017/12/4.
 */
public interface RoutIneurineTestDao {
    RoutIneurineTest insert(RoutIneurineTest item);

    List<RoutIneurineTest> query(RoutIneurineTest item);

    void update(RoutIneurineTest item);

    void delete(RoutIneurineTest item);

}
