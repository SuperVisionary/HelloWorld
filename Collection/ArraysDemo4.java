/*
 * fill·½·¨Ìî³äÔªËØ¡£
 */
import java.util.*;
public class ArraysDemo4 {
	public static void main(String[] args) {
		int[] arr = {9,2,5,6,1,8};
		Arrays.fill(arr,7);
		for(int x = 0;x<arr.length;x++) {
			System.out.println(arr[x]);
		}
	}
}
