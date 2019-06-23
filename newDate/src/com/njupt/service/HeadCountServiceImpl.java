package com.njupt.service;

import com.njupt.dao.HeadCountDao;
import com.njupt.po.HeadCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huhui on 2017/12/12.
 */
@Service
public class HeadCountServiceImpl implements HeadCountService {
    @Autowired
    private HeadCountDao headCountDao;
    @Override
    public HeadCount getHeadCount() {
        int diabetesHC = headCountDao.queryDiabetesHC();
        int hypertensionHC = headCountDao.queryHypertensionHC();
        int bothHC = headCountDao.queryBothHC();

        HeadCount headCount = new HeadCount();
        headCount.setDiabetesHC(diabetesHC);
        headCount.setHypertensionHC(hypertensionHC);
        headCount.setBothHC(bothHC);
        return headCount;
    }
}
