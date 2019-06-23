package com.njupt.dao;
import java.util.List;

import com.njupt.po.User;

/**
 * Created by huhui on 2017/12/4.
 */
public interface UserDao {
    User insert(User item);

    List<User> query(User item);

    void update(User item);

    void delete(User item);

    List<User> queryByIds(List<Integer> user_idList);
}
