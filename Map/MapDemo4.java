import java.util.*;
public class MapDemo4 {
	public static void main(String[] args) {
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("01","huang");
		map.put("02", "zhang");
		map.put("03", "li");
		Set<String> set = map.keySet();//获取键的集合
		Iterator<String> it = set.iterator();//迭代键的集合
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);//获取每个键对应的值
			System.out.println(key+":"+value);
		}
		Collection<String> coll = map.values(); 
		System.out.println(coll);//只打印set集合的值
	}
}
