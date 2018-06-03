import com.bad.remon.io.TemplateBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 模板加载测试类
 *
 * @author remon
 * @create 2018-06-01 15:44
 **/
public class TemplateLoadTest {

    public static void main(String[] args) throws IOException {
        /*TemplateBuilder builder = new TemplateBuilder();
        Set<String> stringSet = builder.loadTemplate("C:\\Users\\admin\\Desktop\\模板文档.txt");
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
			
			
			
			
        }*/
        Map<String, String> map = new HashMap<String, String>();
        map.put("fiedList", "中国人");
        map.put("packageName", "com.bad.remon.io");
        TemplateBuilder builder = new TemplateBuilder();
        // builder.genTemplate("C:\\Users\\admin\\Desktop\\模板文档.txt", "C:\\Users\\admin\\Desktop\\testCode.txt", map);
        builder.genPojoBeanTemplate("C:\\Users\\admin\\Desktop\\testCode.txt", map);
    }

}
