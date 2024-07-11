import bean.Cat;
import bean.Person;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatTest {
    
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("哈哈");
        Cat cat = new Cat();
        cat.setName("咪咪");
        cat.setMaster(person);
        String str = "{master.name}养了一只{name}"; // 哈哈养了一只咪咪
        System.out.println(format(str, BeanUtil.beanToMap(cat)));
    }
    
    public static String format(String template, Map<String, Object> params) {
        MetaObject metaObject = MetaObject.forObject(params, new DefaultObjectFactory(),
                new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        Pattern pattern = Pattern.compile("\\{.+?}");
        Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            String group = matcher.group();
            String field = group.substring(1, group.length() - 1);
            Object value = metaObject.getValue(field);
            template = template.replace(group, ObjectUtil.defaultIfNull(value, "").toString());
        }
        return template;
    }
}
