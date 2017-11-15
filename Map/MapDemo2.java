/*
 * Map集合取出原理：通过转换成Set集合，再通过迭代器取出。
 * map集合的第一种取出方式：
 * 1，keySet：将map中所有的键存入到Set集合。因为Set具备迭代器。
 * 所以可以迭代方式取出所有的键，再根据get方法，获取每个键对应的值。
 * 利用迭代器遍历Map中所有键值对。
 */
import java.util.*;
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
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
