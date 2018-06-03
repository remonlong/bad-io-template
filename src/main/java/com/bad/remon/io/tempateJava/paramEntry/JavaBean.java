package com.bad.remon.io.tempateJava.paramEntry;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * java 代码生成器模板
 *
 * @author remon
 * @create 2018-06-02 21:35
 **/
@lombok.Builder
@Getter
@Setter
@ToString
public class JavaBean {

    private String packageName; // 包名
    private String clazzName; // 类名
    private String desp;// 类注释
    private List<String> lombokAnn;// lombok 注解
    private List<FieldBean> fieldBeanList; // 字段列表

}
