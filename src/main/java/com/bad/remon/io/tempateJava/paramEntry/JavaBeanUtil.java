package com.bad.remon.io.tempateJava.paramEntry;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 16 进制数据转化成对应的java bean
 */
public class JavaBeanUtil<T extends Object> {

    /**
     * byte bean 转 成java bean
     *
     * @param t javaBean 的一个实例
     * @return
     */
    public Map<String, String> convert2JavaBean(T t) {

        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String firstChar = (fieldName.charAt(0) + "").toUpperCase();
            String methodName = fieldName.substring(1, fieldName.length());

            Method tm = null;
            field.setAccessible(true);
            try {
                tm = t.getClass().getMethod("get".concat(firstChar).concat(methodName));
                Object o = tm.invoke(t);
                if (o instanceof String)
                    map.put(fieldName, (String) o);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
