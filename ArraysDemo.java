/*
 * ��Arrays��sort()�����������������
 */
import java.util.*;
public class ArraysDemo {
	public static void main(String[] args) {
		int[] arr = {9,8,2,5,1};
		System.out.println("����ǰ");
		print(arr);
		Arrays.sort(arr);
		System.out.println("�����");
		print(arr);
	}
	public static void print(int[] arr) {
		System.out.print("[");
		for(int x = 0;x<arr.length;x++) {
			if(x!=arr.length-1)
				System.out.print(arr[x]+",");
			else {
				System.out.println(arr[x]+"]");
			}
		}
	}
}
