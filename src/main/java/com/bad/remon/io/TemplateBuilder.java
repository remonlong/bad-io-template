package com.bad.remon.io;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

/**
 * 构建模板信息类
 *
 * @author remon
 * @create 2018-06-01 15:44
 **/
public class TemplateBuilder extends AbstractTemplate {

    public TemplateBuilder(String ext) {
        super(ext);
    }

    public String getTemplate(String url) {
        return null;
    }

    public String genPojoBeanTemplate(String genUrl, Map<String, String> map) throws IOException {
        String templatePath = this.getClass().getClassLoader().getResource("Pojo.bad").getPath();
        templatePath = URLDecoder.decode(templatePath, "utf-8");
        return this.genTemplate(templatePath, genUrl, map);
    }

}
