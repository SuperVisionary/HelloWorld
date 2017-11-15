/*
 * 什么时候定义泛型类？
 * 当类中要操作的引用数据类型不确定的时候。
 * 早期定义Object来完成扩展。
 * 现在定义泛型来完成扩展。
*/
//自定义泛型
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
	//不能写成静态方法
	public void save(T temp) {
		this.temp = temp;
	}
	public T get() {
		return temp;
	}
}
class Worker{
	
}