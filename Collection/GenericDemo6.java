import java.util.*;
public class GenericDemo6 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("asd");
		al.add("hang");
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(4);
		al1.add(2);
		
		printColl(al);
		printColl(al1);
	}
	//public static <T> void printColl(ArrayList<T> al)
	public static void printColl(ArrayList<?> al) {
		Iterator<?> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());//不可以写it.next().length;因为类型不确定，有些对象没由长度
		}
	}
}
