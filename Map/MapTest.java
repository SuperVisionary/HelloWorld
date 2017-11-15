/*
 * 重点理解
 * Student类既具备可比性也重写了hashCode方法和equals方法，保证元素唯一
 */
import java.util.*;
public class MapTest {
	public static void main(String[] args) {
		HashMap<Student,String> hm = new HashMap<Student,String>();
		
		hm.put(new Student("lisi1",21),"北京");
		hm.put(new Student("lisi2",22),"上海");
		hm.put(new Student("lisi3",23),"广东");
		hm.put(new Student("lisi4",24),"深圳");
		
		Set<Student> keySet = hm.keySet();
		Iterator<Student> it = keySet.iterator(); 
		while(it.hasNext()) {
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+":"+addr);
		}
	}
}
//类如果能产生多个对象的话，最好让它具备可比性。
class Student implements Comparable<Student>{
	private String name;
	private int age;
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	public int compareTo(Student s) {
		if(this.age>s.age) {
			return 1;
		}
		if(this.age==s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;
	}
	public int hashCode() {
		return name.hashCode()+age*12;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) {
			throw new ClassCastException("类型不匹配");//ClassCastException是RuntimeExcepiton子类
		}
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age == s.age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return name+":"+age;
	}
}
class Person{
	
}
