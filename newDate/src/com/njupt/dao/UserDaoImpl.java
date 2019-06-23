package com.njupt.dao;

import com.njupt.po.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by huhui on 2017/12/4.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSessionTemplate sqlsession;

    @Override
    public User insert(User item) {
        sqlsession.insert("com.njupt.User.saveUser",item);
        return item;
    }

    @Override
    public List<User> query(User item) {
        return sqlsession.selectList("com.njupt.User.queryUser",item);
    }

    @Override
    public void update(User item) {
        sqlsession.update("com.njupt.User.updateUser",item);
    }

    @Override
    public void delete(User item) {
        sqlsession.delete("com.njupt.User.deleteUser",item);
    }

    @Override
    public List<User> queryByIds(List<Integer> list) {
        if (list != null && list.size() >0){
            return sqlsession.selectList("com.njupt.User.queryByIds",list);
        }
        return null;
    }
}
