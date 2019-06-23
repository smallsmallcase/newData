package com.njupt.po;

import lombok.Data;

import java.util.List;

/**
 * Created by huhui on 2017/12/8.
 */
@Data
public class Page<T>{
    private Integer pageSize = 10;
    private Integer currentPage = 0;
    private Integer totalCount;
    private Integer totalPage;
    private List<T> dataList;
}
