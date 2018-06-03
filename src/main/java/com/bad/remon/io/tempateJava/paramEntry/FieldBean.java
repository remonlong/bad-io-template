package com.bad.remon.io.tempateJava.paramEntry;

/**
 * java 字段bean
 *
 * @author remon
 * @create 2018-06-02 21:59
 **/
public class FieldBean {

    private String modification;// 访问修饰符
    private String fieldName; // 字段名
    private Class<?> clazz;// 字段对应数据类型

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
