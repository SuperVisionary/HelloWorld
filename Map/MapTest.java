/*
 * �ص����
 * Student��Ⱦ߱��ɱ���Ҳ��д��hashCode������equals��������֤Ԫ��Ψһ
 */
import java.util.*;
public class MapTest {
	public static void main(String[] args) {
		HashMap<Student,String> hm = new HashMap<Student,String>();
		
		hm.put(new Student("lisi1",21),"����");
		hm.put(new Student("lisi2",22),"�Ϻ�");
		hm.put(new Student("lisi3",23),"�㶫");
		hm.put(new Student("lisi4",24),"����");
		
		Set<Student> keySet = hm.keySet();
		Iterator<Student> it = keySet.iterator(); 
		while(it.hasNext()) {
			Student stu = it.next();
			String addr = hm.get(stu);
			System.out.println(stu+":"+addr);
		}
	}
}
//������ܲ����������Ļ�����������߱��ɱ��ԡ�
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
			throw new ClassCastException("���Ͳ�ƥ��");//ClassCastException��RuntimeExcepiton����
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
