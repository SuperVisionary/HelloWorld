import java.util.*;
public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();//����String���ͣ�ֻ�ܴ��String���ݣ�����������
		
		al.add("abc123");
		al.add("abc3");
		al.add("abc13");
		
		Iterator<String> it = al.iterator();//��Ҫ����String����
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s+":"+s.length());
		}
	}
}
