# bad-io-template
java 代码生成器

 Map<String, String> map = new HashMap<String, String>();
 map.put("fiedList", "中国人");
 map.put("packageName", "com.bad.remon.io");
 TemplateBuilder builder = new TemplateBuilder(".java");
 // builder.genTemplate("C:\\Users\\admin\\Desktop\\模板文档.txt", "C:\\Users\\admin\\Desktop\\testCode.txt", map);
 builder.genPojoBeanTemplate("C:\\Users\\admin\\Desktop\\testCode.txt", map);

即可生生成一个简单的java bean 
