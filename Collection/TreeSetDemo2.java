import java.util.*;

public class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyCompare());
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
		if(this.age > s.age) {
			return 1;
		}
		if(this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;//写成if(this.age < s.age)return -1;报错，缺少返回值
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
//Comparator还有equals方法，但是不需要覆盖，因为MyCompare默认继承了Object类
class MyCompare implements Comparator{
	public int compare(Object o1,Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		int num = s1.getName().compareTo(s2.getName());
		if(num==0) {
			/*
			if(s1.getAge()>s2.getAge()) {
				return 1;
			}
			if(s1.getAge()==s2.getAge()) {
				return 0;
			}
				return -1;
			*/
			//return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
			return s1.getAge()-s2.getAge();//能直接相减的直接相减
		}
		return num;
	}
}