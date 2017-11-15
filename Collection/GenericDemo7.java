/*
 * ?通配符。也可以理解为占有符。
 * 泛型的限定：
 * ? extends E:可以接收E类型或者E的子类型。上限。
 * ? super E:可以接收E类型或者E的父类型。下限。
 */
import java.util.*;
public class GenericDemo7 {
	public static void main(String[] args) {
		ArrayList<Person> al = new ArrayList<Person>();
		al.add(new Person("zhang"));
		al.add(new Person("hao"));
		ArrayList<Student> al1 = new ArrayList<Student>();
		al1.add(new Student("huang"));
		al1.add(new Student("li"));

		printColl(al);
		printColl(al1);
	}
	public static void printColl(ArrayList<? extends Person> al) {
		Iterator<? extends Person> it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
	}
}
class Person{
	private String name;
	Person(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class Student extends Person{
	Student(String name){
		super(name);
	}
}