package com.lcy.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liuweijin
 * @date 2024-11-08
 * @desc
 */
@Data
public class WebLog {
    private String description;
    private String username;
    private Long startTime;
    private Integer spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;
    //省略了getter,setter方法
}