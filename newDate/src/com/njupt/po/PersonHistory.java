package com.njupt.po;

import lombok.Data;

/**
 * Created by huhui on 2017/12/2.
 */
@Data
public class PersonHistory {
    private Integer basic_id;
    private String smokehistory;
    private String drinkhistory;
    private String touchhistory;
    private String zhiyouhistory;
    private String else_like;
    private Integer person_id;
}
