/*
 * 使用copyOfRange方法拷贝元素。
 */
import java.util.*;
public class ArraysDemo3 {
	public static void main(String[] args) {
		int[] arr = {9,2,5,6,1,8};
		int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length);//包含头不包含尾
		for(int x = 0;x<arr2.length;x++) {
			System.out.println(arr[x]);
		}
	}
}
