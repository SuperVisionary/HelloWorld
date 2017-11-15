import java.util.*;
public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();//定义String类型，只能存放String数据，否则编译出错
		
		al.add("abc123");
		al.add("abc3");
		al.add("abc13");
		
		Iterator<String> it = al.iterator();//需要定义String类型
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s+":"+s.length());
		}
	}
}
