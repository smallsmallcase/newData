package com.njupt.dao;
import java.util.List;

import com.njupt.po.ElseDiscrible;

/**
 * Created by huhui on 2017/12/4.
 */
public interface ElseDiscribleDao {
    ElseDiscrible insert(ElseDiscrible item);

    List<ElseDiscrible> query(ElseDiscrible item);

    void update(ElseDiscrible item);

    void delete(ElseDiscrible item);

}
