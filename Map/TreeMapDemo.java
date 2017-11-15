import java.util.*;
public class TreeMapDemo {
	public static void main(String[] args) {
		TreeMap<String,String> tm = new TreeMap<String,String>(new MyComparator());//�ǵô���Ƚ���
		tm.put("01","huang");
		tm.put("02", "zhang");
		tm.put("03", "li");
		Set<String> set = tm.keySet();//��ȡ���ļ���
		Iterator<String> it = set.iterator();//�������ļ���
		while(it.hasNext()) {
			String key = it.next();
			String value = tm.get(key);//��ȡÿ������Ӧ��ֵ
			System.out.println(key+":"+value);
		}
		Collection<String> coll = tm.values(); 
		System.out.println(coll);//ֻ��ӡset���ϵ�ֵ
	}
}
class MyComparator implements Comparator<String>{
	public int compare(String o1,String o2) {
		return o2.compareTo(o1);
	}
}
