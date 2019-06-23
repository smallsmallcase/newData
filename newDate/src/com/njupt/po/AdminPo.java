package com.njupt.po;

import lombok.Data;

/**
 * Created by huhui on 2017/12/11.
 */
@Data
public class AdminPo {
    private Integer user_id;
    private String user_name;
    private Integer basic_id;
    private String personname;
    private String ad_number;
    private Integer task_id;
    private Integer finish;
    private int page_num;
}
