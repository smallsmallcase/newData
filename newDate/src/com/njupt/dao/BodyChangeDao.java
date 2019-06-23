package com.njupt.dao;
import java.util.List;

import com.njupt.po.BodyChange;

/**
 * Created by huhui on 2017/12/4.
 */
public interface BodyChangeDao {
    BodyChange insert(BodyChange item);

    List<BodyChange> query(BodyChange item);

    void update(BodyChange item);

    void delete(BodyChange item);

}
