/*
 * ʲôʱ���巺���ࣿ
 * ������Ҫ�����������������Ͳ�ȷ����ʱ��
 * ���ڶ���Object�������չ��
 * ���ڶ��巺���������չ��
*/
//�Զ��巺��
import java.util.*;
public class GenericDemo3 {
	public static void main(String[] args) {
		Tool<Integer> tool = new Tool<Integer>();
		tool.save(1);
		tool.get();
		
		Tool<Worker> tool2 = new Tool<Worker>();
		tool2.save(new Worker());
		tool2.get();
		
		Integer i = tool.get();
		System.out.println(i);
		Worker w = tool2.get();
		System.out.println(w);
	}
}
class Tool<T>{
	private T temp;
	//����д�ɾ�̬����
	public void save(T temp) {
		this.temp = temp;
	}
	public T get() {
		return temp;
	}
}
class Worker{
	
}