/*
 * toString方法把数组转换为字符串
 * asList方法把数组转换成集合
 */
import java.util.*;
public class ArraysDemo5 {
	public static void main(String[] args) {
		String[] arr = {"abc","kk","cc"};
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
	}
}
