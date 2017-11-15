/*
泛型：JDK1.5版本以后出现新特性。用于解决安全问题，是一个安全机制。
好处：
1，将运行时期出现的问题ClassCastException，转移到了编译时期。
方便程序员解决问题。让运行时期问题减少，安全。
2，避免了强制转换的麻烦。

通常在集合框架中很常见。只要见到<>就要定义泛型。
*/
import java.util.*;
public class GenericDemo2 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());////定义String类型，只能存放String数据，否则编译出错
		ts.add("abc123");
		ts.add("abc3");
		ts.add("abc13");
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
class LenComparator implements Comparator<String>{
	public int compare(String o1,String o2) {
		return o2.length()-o1.length();//由长到短排序
	}
}
