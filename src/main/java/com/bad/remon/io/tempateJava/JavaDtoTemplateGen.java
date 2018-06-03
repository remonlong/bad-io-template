package com.bad.remon.io.tempateJava;

import com.bad.remon.io.tempateJava.paramEntry.FieldBean;
import com.bad.remon.io.tempateJava.paramEntry.JavaBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据返回Bean
 * @author remon
 * @create 2018-06-02 23:20
 **/
public class JavaDtoTemplateGen extends JavaTemplateGen {

    /**
     * 生成java dto bean
     *
     * @param genUrl
     * @return
     * @throws IOException
     */
    public String genJavaDtoBean(String genUrl, String[] ignore) throws IOException {
        Map<String, String> paramMap = super.getMap();
        List<FieldBean> fieldBeanList = getJavaBean().getFieldBeanList();

        StringBuffer fiedList = new StringBuffer("");
        for (FieldBean bean : fieldBeanList) {
            boolean exists = false;
            for (String str : ignore) {
                if (bean.getFieldName().equals(str)) {
                    exists = true;
                }
            }
            if (!exists)
                fiedList.append(bean.getModification()).append(" ").append(bean.getClazz().getName()).append(" ").append(bean.getFieldName()).append(" ; ").append("\r\n");
        }
        String clazzName = getJavaBean().getClazzName().concat("DTO");
        paramMap.put("fieldBeanList", fiedList.toString());
        paramMap.put("clazzName", clazzName);
        return super.genPojoBeanTemplate(genJavaFileName(clazzName), paramMap);
    }

    public static void main(String[] args) throws IOException {

        // Class<?> clazz = Override.class;


        JavaDtoTemplateGen javaTemplateGen = new JavaDtoTemplateGen();
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
        javaTemplateGen.genJavaBean("C:\\Users\\admin\\Desktop\\");
        javaTemplateGen.genJavaDtoBean("C:\\Users\\admin\\Desktop\\", new String[]{"id"});
    }


}
