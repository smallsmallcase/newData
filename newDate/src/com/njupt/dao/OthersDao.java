package com.njupt.dao;
import java.util.List;

import com.njupt.po.Others;

/**
 * Created by huhui on 2017/12/4.
 */
public interface OthersDao {
    Others insert(Others item);

    List<Others> query(Others item);

    void update(Others item);

    void delete(Others item);

}
