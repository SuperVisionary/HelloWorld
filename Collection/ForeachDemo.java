/*
 * foreachѭ��
 * for(������Ԫ������  ��ʱ���� : ��������){
			ִ�����
		}
 */
import java.util.ArrayList;
public class ForeachDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("jack");
		al.add("rose");
		al.add("mike");
		for(String s : al){
			System.out.println(s);
		}
	}
}
