/*
 * 遍历D:\eclipse-workspace\IO\字节流目录下的所有文件和目录。
 * 使用foreach打印file
 */
import java.io.*;
public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\字节流");
		//遍历过程
		if(file.isDirectory()) {
			String[] names = file.list();	//获取目录下所有文件的文件名,String类型
			for(String name : names) {
				System.out.println(name);
			}
		}
	}
}
