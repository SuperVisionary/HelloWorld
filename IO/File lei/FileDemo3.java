/*
 * 打印"D:\\eclipse-workspace\\IO\\字节流"目录下的文件和子目录下的文件
 */
import java.io.*;	
public class FileDemo3 {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\字节流");	//创建File对象
		fileDir(file);
	}
	public static void fileDir(File dir) {
		//遍历过程
		File[] files = dir.listFiles();//获得表示目录下 所有文件的数组， file.listFiles()返回值是File类型
		for(File file : files) {
			if(file.isDirectory()) {
				fileDir(file);
			}
			System.out.println(file);
		}
	}
}
