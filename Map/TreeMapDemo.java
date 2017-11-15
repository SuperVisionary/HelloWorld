import java.util.*;
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<String,String> tm = new TreeMap<String,String>(new MyComparator());//记得传入比较器
		tm.put("01","huang");
		tm.put("02", "zhang");
		tm.put("03", "li");
		Set<String> set = tm.keySet();//获取键的集合
		Iterator<String> it = set.iterator();//迭代键的集合
		while(it.hasNext()) {
			String key = it.next();
			String value = tm.get(key);//获取每个键对应的值
			System.out.println(key+":"+value);
		}
		Collection<String> coll = tm.values(); 
		System.out.println(coll);//只打印set集合的值
	}
}
class MyComparator implements Comparator<String>{
	public int compare(String o1,String o2) {
		return o2.compareTo(o1);
	}
}
