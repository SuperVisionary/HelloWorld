/**/
import java.io.*;
import java.util.*;
public class StringDemo {
	public static void main(String[] args) throws Exception{
		StringBuffer sb = new StringBuffer();
		
		String s = "HelloWorld";
	
		char[] b = s.toCharArray();

		for(int x=b.length-1;x>=0;x--) {

			if(Character.isUpperCase(b[x])) {
				String s1 = (b[x]+"").toLowerCase();
				System.out.println(s1);
				sb.append(s1);
			}
			if(Character.isLowerCase(b[x])) {
				String s1=(b[x]+"").toUpperCase();
				System.out.println(s1);
				sb.append(s1);
			}
		}

		System.out.println(sb.toString());
	}
}
