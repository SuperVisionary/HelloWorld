/*
 * Collection�ӿ��е�toArray����������ת�����顣
 */
import java.util.*;
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("acb01");
		al.add("acb02");
		al.add("acb03");
		//��ָ�����͵����鳤��С�ڼ��ϵ�size����ô�÷������´���һ��size���ȵ����顣
		//String[] s = al.toArray(new String[0]);
		String[] s = al.toArray(new String[al.size()]);
		System.out.println(Arrays.toString(s));
	}
}
