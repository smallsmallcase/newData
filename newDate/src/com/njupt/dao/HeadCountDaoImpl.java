package com.njupt.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by huhui on 2017/12/12.
 */
@Repository
public class HeadCountDaoImpl implements HeadCountDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public int queryDiabetesHC() {
        return sqlSession.selectOne("com.njupt.HeadCount.queryDiabetesHC");
    }

    @Override
    public int queryHypertensionHC() {

        return sqlSession.selectOne("com.njupt.HeadCount.queryHypertensionHC");
    }

    @Override
    public int queryBothHC() {

        return sqlSession.selectOne("com.njupt.HeadCount.queryBothHC");
    }
}
