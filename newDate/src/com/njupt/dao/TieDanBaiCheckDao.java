package com.njupt.dao;
import java.util.List;

import com.njupt.po.TieDanBaiCheck;

/**
 * Created by huhui on 2017/12/4.
 */
public interface TieDanBaiCheckDao {
    TieDanBaiCheck insert(TieDanBaiCheck item);

    List<TieDanBaiCheck> query(TieDanBaiCheck item);

    void update(TieDanBaiCheck item);

    void delete(TieDanBaiCheck item);

}
