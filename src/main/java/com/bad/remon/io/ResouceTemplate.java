package com.bad.remon.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 模板中心资源配置类
 *
 * @author remon
 * @create 2018-06-01 14:56
 **/
public interface ResouceTemplate {


    String getTemplate(String url);

    Set<String> loadTemplate(String url) throws IOException;

    String genTemplate(String srcPath, String destPath, Map<String, String> param) throws IOException;

}
