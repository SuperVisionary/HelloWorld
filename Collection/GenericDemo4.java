/*
 * �����ඨ��ķ��ͣ�����������Ч�����������ʹ�ã���ô������Ķ�����ȷҪ�����ľ������ͺ�����Ҫ���������;��Ѿ��̶���
 * Ϊ���ò�ͨ���������Բ�����ͬ���ͣ��������ͻ���ȷ������ô���Խ����Ͷ����ڷ�����
 * 
 * ����֮����
 * ��̬���������Է������϶���ķ��͡�
 * �����̬����������Ӧ�����ݲ�ȷ�������Խ����Ͷ����ڷ����ϡ�
 */
import java.util.*;
public class GenericDemo4 {
	public static void main(String[] args) {
		Demo<String> d = new Demo<String>();
		d.show("haha");
		d.print(new Integer(5));
		Demo.method("heihei");
	}
}
class Demo<T>{
	public void show(T t) {
		System.out.println("show--"+t);
	}
	public <T> void print(T t) {
		System.out.println("print--"+t);
	}
	public static <T> void method(T t) {
		System.out.println("method--"+t);
	}
}
