package com.bad.remon.io.templateIo.util;

import java.util.Map;

/**
 * 模板变量工具类
 *
 * @author remon
 * @create 2018-06-01 18:22
 **/
public class TemplateVarUtil {

    /**
     * 替换新变量
     *
     * @param val
     * @param map
     * @return
     */
    public static String builderNewVal(String val, Map<String, String> map) {
        for (String str : map.keySet()) {
            val = val.replaceAll("\\$\\{" + str + "\\}", map.get(str));
        }
        return val;
    }

}
