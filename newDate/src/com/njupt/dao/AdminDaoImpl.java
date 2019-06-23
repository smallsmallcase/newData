package com.njupt.dao;

import com.njupt.po.AdminPo;
import com.njupt.po.Page;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huhui on 2017/12/11.
 */
@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public Page<AdminPo> queryByPageForAdmin(Page<AdminPo> page) {

        Map<String, Object> map = new HashMap<>();
        List<AdminPo> dataList = page.getDataList();
        if (dataList!=null&&dataList.size()>0){
            map.put("user_id",dataList.get(0).getUser_id());
            map.put("basic_id",dataList.get(0).getBasic_id());
            map.put("task_id",dataList.get(0).getTask_id());
            map.put("finish",dataList.get(0).getFinish());
            map.put("user_name",dataList.get(0).getUser_name());
            map.put("personname",dataList.get(0).getPersonname());
            map.put("ad_number",dataList.get(0).getAd_number());
        }
        Integer total = sqlSession.selectOne("com.njupt.AdminPo.queryByPageTotalForAdmin", map);
        map.put("pageSize",page.getPageSize());
        map.put("start",(page.getCurrentPage()-1)*page.getPageSize());
        List<AdminPo> adminPoList = sqlSession.selectList("com.njupt.AdminPo.queryByPageForAdmin", map);

        page.setDataList(adminPoList);
        page.setTotalPage(total%page.getPageSize() == 0?total/page.getPageSize():total/page.getPageSize()+1);
        page.setTotalCount(total);
        return page;
    }

    @Override
    public Page<AdminPo> queryByPageForType(Page<Integer> page) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> dataList = page.getDataList();
        Integer total = null;
        List<AdminPo> adminPoList = null;
        map.put("pageSize",page.getPageSize());
        map.put("start",(page.getCurrentPage()-1)*page.getPageSize());
        if (dataList!=null&&dataList.size()>0){
            Integer type = dataList.get(0);
            if (type == 1){
                /*妊娠期糖尿病*/
                total = sqlSession.selectOne("com.njupt.HeadCount.queryDiabetesHC");
                adminPoList = sqlSession.selectList("com.njupt.AdminPo.queryByPageForDiabetes", map);
            }else if (type == 2){
                /*妊娠期高血压*/
                total = sqlSession.selectOne("com.njupt.HeadCount.queryHypertensionHC");
                adminPoList = sqlSession.selectList("com.njupt.AdminPo.queryByPageForHypertension", map);
            }else if (type == 3){
                /*同时患两种疾病*/
                total = sqlSession.selectOne("com.njupt.HeadCount.queryBothHC");
                adminPoList = sqlSession.selectList("com.njupt.AdminPo.queryByPageForBoth", map);
            }
        }
        Page<AdminPo> resultPage = new Page<>();
        resultPage.setDataList(adminPoList);
        resultPage.setTotalPage(total%page.getPageSize() == 0?total/page.getPageSize():total/page.getPageSize()+1);
        resultPage.setTotalCount(total);
        resultPage.setCurrentPage(page.getCurrentPage());
        return resultPage;
    }
}
