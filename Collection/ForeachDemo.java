/*
 * foreach循环
 * for(容器中元素类型  临时变量 : 容器变量){
			执行语句
		}
 */
import java.util.ArrayList;
public class ForeachDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("jack");
		al.add("rose");
		al.add("mike");
		for(String s : al){
			System.out.println(s);
		}
	}
}
