/*
���ͣ�JDK1.5�汾�Ժ���������ԡ����ڽ����ȫ���⣬��һ����ȫ���ơ�
�ô���
1��������ʱ�ڳ��ֵ�����ClassCastException��ת�Ƶ��˱���ʱ�ڡ�
�������Ա������⡣������ʱ��������٣���ȫ��
2��������ǿ��ת�����鷳��

ͨ���ڼ��Ͽ���кܳ�����ֻҪ����<>��Ҫ���巺�͡�
*/
import java.util.*;
public class GenericDemo2 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());////����String���ͣ�ֻ�ܴ��String���ݣ�����������
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
		return o2.length()-o1.length();//�ɳ���������
	}
}
