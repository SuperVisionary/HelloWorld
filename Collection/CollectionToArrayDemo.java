/*
 * Collection接口中的toArray方法将集合转成数组。
 */
import java.util.*;
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("acb01");
		al.add("acb02");
		al.add("acb03");
		//当指定类型的数组长度小于集合的size，那么该方法内新创建一个size长度的数组。
		//String[] s = al.toArray(new String[0]);
		String[] s = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(s));
	}
}
