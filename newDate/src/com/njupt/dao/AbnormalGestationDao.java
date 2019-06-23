package com.njupt.dao;
import java.util.List;

import com.njupt.po.AbnormalGestation;

/**
 * Created by huhui on 2017/12/4.
 */
public interface AbnormalGestationDao {
    AbnormalGestation insert(AbnormalGestation item);

    List<AbnormalGestation> query(AbnormalGestation item);

    void update(AbnormalGestation item);

    void delete(AbnormalGestation item);

}
