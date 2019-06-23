package com.njupt.service;

import com.njupt.dao.UserDao;
import com.njupt.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huhui on 2017/12/4.
 */
@Service("UserService")
@Transactional
public class UserService implements BasicService<User> {
    @Autowired
    private UserDao templateDao;

    public User insert(User item) {
        return templateDao.insert(item);
    }

    public List<User> query(User item) {
        return templateDao.query(item);
    }

    public void update(User item) {
        templateDao.update(item);
    }

    public void delete(User item) {
        templateDao.delete(item);
    }
}
