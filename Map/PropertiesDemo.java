/*
 * Hashtable的子类Properties
 */
import java.util.*;
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("backgroup-color", "red");
		p.setProperty("Font-size","12px");
		p.setProperty("Language", "Chinese");
		Enumeration<?> names = p.propertyNames();//返回属性列表中所有键的枚举
		while(names.hasMoreElements()) {		//循环遍历所有的键
			String key = (String)names.nextElement();
			String value = p.getProperty(key);	//获取对应键的值
			System.out.println(key+":"+value);
		}
	}
}
