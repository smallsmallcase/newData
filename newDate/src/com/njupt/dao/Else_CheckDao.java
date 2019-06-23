package com.njupt.dao;
import java.util.List;

import com.njupt.po.Else_Check;

/**
 * Created by huhui on 2017/12/4.
 */
public interface Else_CheckDao {
    Else_Check insert(Else_Check item);

    List<Else_Check> query(Else_Check item);

    void update(Else_Check item);

    void delete(Else_Check item);

}
