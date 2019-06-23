package com.njupt.po;

import lombok.Data;

/**
 * Created by huhui on 2017/12/6.
 */
@Data
public class Task {
    /*任务id*/
    private Integer task_id;
    /*录入id*/
    private Integer basic_id;
    /*用户id*/
    private Integer user_id;
    /*任务进度*/
    private Integer page_num;
    /*是否完成*/
    private Integer finish;
}
