import java.util.Arrays;

/*
 * ʹ��Arrays��binarySearch��������Ԫ�ص�
 */
public class ArraysDemo2 {
	public static void main(String[] args) {
		int[] arr = {9,2,5,6,1,8};
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, 8));
	}
}
