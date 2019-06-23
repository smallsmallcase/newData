package com.njupt.dao;
import java.util.List;

import com.njupt.po.ChanKeInformation;

/**
 * Created by huhui on 2017/12/4.
 */
public interface ChanKeInformationDao {
    ChanKeInformation insert(ChanKeInformation item);

    List<ChanKeInformation> query(ChanKeInformation item);

    void update(ChanKeInformation item);

    void delete(ChanKeInformation item);

}
