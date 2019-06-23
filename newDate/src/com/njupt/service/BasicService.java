package com.njupt.service;

import java.util.List;

/**
 * Created by huhui on 2017/12/5.
 */
public interface BasicService <T>{
    T insert(T item);
    List<T> query(T item);
    void update(T item);
    void delete(T item);
}
