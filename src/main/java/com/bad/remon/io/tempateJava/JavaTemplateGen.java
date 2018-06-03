package com.bad.remon.io.tempateJava;

import com.bad.remon.io.AbstractTemplate;
import com.bad.remon.io.TemplateBuilder;
import com.bad.remon.io.tempateJava.paramEntry.FieldBean;
import com.bad.remon.io.tempateJava.paramEntry.JavaBean;
import com.bad.remon.io.tempateJava.paramEntry.JavaBeanUtil;
import com.bad.remon.io.tempateJava.paramEntry.LombokAnn;
import com.bad.remon.io.templateIo.util.TemplateFileLoadUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * java 模板生成器
 *
 * @author remon
 * @create 2018-06-02 20:24
 **/
public class JavaTemplateGen extends TemplateBuilder {

    @Getter
    @Setter
    private JavaBean javaBean;

    @Getter
    private Map<String, String> map;

    @Getter
    private String srcPath;

    public JavaTemplateGen() {
        super(".java");
    }

    /**
     * 生成java bean
     *
     * @param srcPath
     * @return
     * @throws IOException
     */
    public String genJavaBean(String srcPath) throws IOException {

        this.srcPath = srcPath;

        // TemplateBuilder templateBuilder = new TemplateBuilder(getExt());
        JavaBeanUtil<JavaBean> javaBeanJavaBeanUtil = new JavaBeanUtil<JavaBean>();
        Map<String, String> map = javaBeanJavaBeanUtil.convert2JavaBean(javaBean);
        List<FieldBean> fieldBeanList = javaBean.getFieldBeanList();
        if (fieldBeanList.size() <= 0)
            throw new RuntimeException(" fieldBeanList must not null ");
        StringBuffer fiedList = new StringBuffer("");
        for (FieldBean bean : fieldBeanList) {
            fiedList.append(bean.getModification()).append(" ").append(bean.getClazz().getName()).append(" ").append(bean.getFieldName()).append(" ; ").append("\r\n");
        }
        map.put("fieldBeanList", fiedList.toString());

        StringBuffer lomAnnBuf = new StringBuffer(" ");
        for (String lomAnn : javaBean.getLombokAnn()) {
            lomAnnBuf.append(lomAnn).append("\r\n");
        }
        map.put("lombokAnn", lomAnnBuf.toString());
        this.map = map;

        return super.genPojoBeanTemplate(genJavaFileName(), map);
    }

    /**
     * 获取当前类的信息生成对应目录
     *
     * @return
     */
    public String genJavaFileName() throws IOException {
        return genJavaFileName(javaBean.getClazzName());
    }

    /**
     * 获取当前类的信息生成对应目录
     *
     * @return
     */
    public String genJavaFileName(String className) throws IOException {
        String src = srcPath;
        String packagePath = javaBean.getPackageName().replace(".", "\\");
        String genPath = src + "\\" + packagePath.concat("\\");
        TemplateFileLoadUtil.genDir(genPath);
        return genPath.concat(className);
    }

    public static void main(String[] args) throws IOException {
        JavaTemplateGen javaTemplateGen = new JavaTemplateGen();
        List<FieldBean> fieldBeans = new ArrayList<FieldBean>();
        FieldBean fieldBean = new FieldBean();
        fieldBean.setFieldName("id");
        fieldBean.setModification("private");
        fieldBean.setClazz(int.class);

        FieldBean fieldBean1 = new FieldBean();
        fieldBean1.setFieldName("userName");
        fieldBean1.setModification("private");
        fieldBean1.setClazz(String.class);


        FieldBean fieldBean2 = new FieldBean();
        fieldBean2.setFieldName("password");
        fieldBean2.setModification("private");
        fieldBean2.setClazz(String.class);

        fieldBeans.add(fieldBean2);

        fieldBeans.add(fieldBean1);
        fieldBeans.add(fieldBean);

        List<String> lombokAnns = new ArrayList<String>();
        lombokAnns.add("@lombok.ToString");
        lombokAnns.add("@lombok.Getter");
        lombokAnns.add("@lombok.Setter");

        JavaBean javaBean = JavaBean.builder()
                .desp("这只是一个注释而已")
                .packageName("com.remon")
                .clazzName("TestGen")
                .fieldBeanList(fieldBeans)
                .lombokAnn(lombokAnns)
                .build();
        javaTemplateGen.setJavaBean(javaBean);
        javaTemplateGen.genJavaBean("C:\\Users\\admin\\Desktop\\testCode.java");
    }


}
