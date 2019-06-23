package com.njupt.dao;
import java.util.List;

import com.njupt.po.JiaGong;

/**
 * Created by huhui on 2017/12/4.
 */
public interface JiaGongDao {
    JiaGong insert(JiaGong item);

    List<JiaGong> query(JiaGong item);

    void update(JiaGong item);

    void delete(JiaGong item);

}
