/*
 * map集合的第一种取出方式：
 * 2，Set<Map.Entry<k,v>> entrySet:将map集合中的映射关系存入到了Set集合中。
 * 而这个关系的数据类型就是Map.Entry
 */
import java.util.*;
public class MapDemo3 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("01","huang");
		map.put("02", "zhang");
		map.put("03", "li");
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String,String>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			Object key = me.getKey();
			Object value = me.getValue();
			System.out.println(key+":"+value);
		}
		
	}
}
