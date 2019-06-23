package com.njupt.dao;
import java.util.List;

import com.njupt.po.Cfy;

/**
 * Created by huhui on 2017/12/4.
 */
public interface CfyDao {
    Cfy insert(Cfy item);

    List<Cfy> query(Cfy item);

    void update(Cfy item);

    void delete(Cfy item);

}
