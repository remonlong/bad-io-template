package com.bad.remon.io;

import com.bad.remon.io.templateIo.PatternConstants;
import com.bad.remon.io.templateIo.util.TemplateFileLoadUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bad.remon.io.templateIo.util.TemplateVarUtil.builderNewVal;


/**
 * 模板加载抽象类
 *
 * @author remon
 * @create 2018-06-01 15:24
 **/
public abstract class AbstractTemplate implements ResouceTemplate {

    private Map<String, String> templateMap; // 当前所有模板
    @Getter
    @Setter
    private String ext; // 文件扩展名

    public AbstractTemplate(String ext) {
        this.ext = ext;
    }


    /**
     * 加载模板且获取模板中的变量
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public Set<String> loadTemplate(String filePath) throws IOException {
        String value = TemplateFileLoadUtil.getTemplateFileValue(filePath);
        Pattern pattern = Pattern.compile(PatternConstants.VARPARRERN);
        Matcher matcher = pattern.matcher(value);
        Set<String> vars = new HashSet<String>();
        while (matcher.find()) {
            vars.add(matcher.group(1));
        }
        return vars;
    }

    /**
     * 生成模板
     *
     * @param srcPath  模板文件地址
     * @param destPath 生成文件地址
     * @param param    参数列表
     * @return
     * @throws IOException
     */
    public String genTemplate(String srcPath, String destPath, Map<String, String> param) throws IOException {
        String fileVal = TemplateFileLoadUtil.getTemplateFileValue(srcPath);
        fileVal = builderNewVal(fileVal, param);
        return TemplateFileLoadUtil.writerFile(fileVal, destPath.concat(ext));
    }

    public String getTemplate(String url) {
        return null;
    }
}
