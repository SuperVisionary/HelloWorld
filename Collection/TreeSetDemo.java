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
//ѧ���಻�߱��Ƚ��ԣ��ýӿ�ǿ����ѧ���߱��Ƚ���
class Student implements Comparable{
	private String name;
	private int age;
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	//��дcompareTo������ʹStudent�߱��Ƚ���
	public int compareTo(Object obj) {
		if(!(obj instanceof Student)) {
			throw new RuntimeException("����ѧ������");
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
		return -1;//д��if(this.age < s.age)return -1;����ȱ�ٷ���ֵ
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