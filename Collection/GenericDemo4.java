/*
 * 泛型类定义的泛型，在整个类有效。如果被方法使用，呢么泛型类的对象明确要操作的具体类型后，所有要操作的类型就已经固定了
 * 为了让不通过方法可以操作不同类型，而且类型还不确定，那么可以将泛型定义在方法上
 * 
 * 特殊之处：
 * 静态方法不可以访问类上定义的泛型。
 * 如果静态方法操作的应用数据不确定，可以将泛型定义在方法上。
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
