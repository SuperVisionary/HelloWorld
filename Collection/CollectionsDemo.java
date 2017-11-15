/*
 * Collections.binarySearch方法才用二分法排序原理。
 * 使用binarySearch方法前提是集合元素必须是有序的。
 * Collections常用方法：max,min,binarySearch,sort,swap,reverse.
 */
import java.util.*;
public class CollectionsDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("abcc");
		list.add("kkk");
		list.add("qq");
		list.add("zz");
		System.out.println(Collections.binarySearch(list, "abcc"));//用binarySearch方法获取
		System.out.println(halfSearch(list,"abcc"));//用自定义halfSearch获取
		System.out.println(halfSearch(list,"abb"));
	}
	
	public static int halfSearch(ArrayList<String> list,String key) {
		int max,mid,min;
		max = list.size()-1;
		min = 0;
		while(min<=max) {
			mid = (max+min)/2;
			String str = list.get(mid);
			int num = str.compareTo(key);
			if(num>0) {
				max = mid-1;
			}
			else if(num<0) {
				min = mid+1;
			}
			else
				return mid;
		}
		return -min-1;//min表示插入点
	}
}
