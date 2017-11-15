import java.util.*;
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Student("lisi05",20));
		ts.add(new Student("lisi06",22));
		ts.add(new Student("lisi01",20));
		ts.add(new Student("lisi03",23));
		ts.add(new Student("lisi01",25));
		
		Iterator it = ts.iterator();
		while(it.hasNext()) {
			Student stu = (Student)it.next();
			System.out.println(stu.getName()+"---"+stu.getAge());
		}
	}
}
//学生类不具备比较性，该接口强制让学生具备比较性
class Student implements Comparable{
	private String name;
	private int age;
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	//重写compareTo方法，使Student具备比较性
	public int compareTo(Object obj) {
		if(!(obj instanceof Student)) {
			throw new RuntimeException("不是学生对象");
		}
		Student s = (Student)obj;
		System.out.println(this.name+"---compare---"+s.name);
		/*
		if(this.age > s.age) {
			return 1;
		}
		if(this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;//写成if(this.age < s.age)return -1;报错，缺少返回值
		*/
		if(this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return this.age-s.age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}