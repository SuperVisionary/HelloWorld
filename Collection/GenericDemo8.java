import java.util.*;
public class GenericDemo8{
	public static void main(String[] args) {
		//ts可以接受Student类和Student的父类迭代器。
		TreeSet<Student> ts = new TreeSet<Student>(new Comp());
		ts.add(new Student("abc002"));
		ts.add(new Student("abc005"));
		ts.add(new Student("abc008"));
		
		Iterator<Student> it = ts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
		TreeSet<Worker> ts1 = new TreeSet<Worker>(new Comp());
		ts1.add(new Worker("wab--001"));
		ts1.add(new Worker("wab--009"));
		ts1.add(new Worker("wab--006"));
		
		Iterator<Worker> it1 = ts1.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next().getName());
		}
	}
}
class Comp implements Comparator<Person>{
	public int compare(Person p1,Person p2) {
		return p2.getName().compareTo(p1.getName());
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
	public String toString() {
		return "person"+name;
	}
}
class Student extends Person{
	Student(String name){
		super(name);
	}
}
class Worker extends Person{
	Worker(String name){
		super(name);
	}
}