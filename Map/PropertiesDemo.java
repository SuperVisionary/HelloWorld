/*
 * Hashtable������Properties
 */
import java.util.*;
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("backgroup-color", "red");
		p.setProperty("Font-size","12px");
		p.setProperty("Language", "Chinese");
		Enumeration<?> names = p.propertyNames();//���������б������м���ö��
		while(names.hasMoreElements()) {		//ѭ���������еļ�
			String key = (String)names.nextElement();
			String value = p.getProperty(key);	//��ȡ��Ӧ����ֵ
			System.out.println(key+":"+value);
		}
	}
}
