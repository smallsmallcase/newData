package com.njupt.dao;
import java.util.List;

import com.njupt.po.RoutineBloodTest;

/**
 * Created by huhui on 2017/12/4.
 */
public interface RoutineBloodTestDao {
    RoutineBloodTest insert(RoutineBloodTest item);

    List<RoutineBloodTest> query(RoutineBloodTest item);

    void update(RoutineBloodTest item);

    void delete(RoutineBloodTest item);

}
