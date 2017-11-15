import java.util.Arrays;

/*
 * 使用Arrays的binarySearch方法查找元素的
 */
public class ArraysDemo2 {
	public static void main(String[] args) {
		int[] arr = {9,2,5,6,1,8};
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, 8));
	}
}
