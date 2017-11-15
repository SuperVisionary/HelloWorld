import java.util.*;
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new StrLenComparator());
		ts.add("ad");
		ts.add("ach");
		ts.add("egch");
		ts.add("aaa");
		ts.add("ncach");
		ts.add("h");
		
		Iterator it = ts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
class StrLenComparator implements Comparator{
	public int compare(Object o1,Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
		if(s1.length()==s2.length()) {
			return s1.compareTo(s2);
		}
		return s1.length()-s2.length();
	}
}