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
		if(this.age > s.age) {
			return 1;
		}
		if(this.age == s.age) {
			return this.name.compareTo(s.name);
		}
		return -1;//д��if(this.age < s.age)return -1;����ȱ�ٷ���ֵ
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
//Comparator����equals���������ǲ���Ҫ���ǣ���ΪMyCompareĬ�ϼ̳���Object��
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
			return s1.getAge()-s2.getAge();//��ֱ�������ֱ�����
		}
		return num;
	}
}