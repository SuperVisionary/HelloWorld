/*
 * �������ڽӿ���
 */
import java.util.*;
public class GenericDemo5 {
	public static void main(String[] args) {
		InterImpl<Integer> i = new InterImpl<>();
		i.show(5);
	}
}
interface Inter<T>{
	void show(T t);
}

class InterImpl<T> implements Inter<T>{
	//Ҫ��publicȨ��
	public void show(T t) {
		System.out.println(t);
	}
}
