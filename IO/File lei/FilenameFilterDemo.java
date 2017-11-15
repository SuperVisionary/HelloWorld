/*
 * 遍历"D:\\eclipse-workspace\\IO\\字节流"目录下所有以.java结尾的文件
 */
import java.io.*;
public class FilenameFilterDemo {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\字节流");//创建File对象
		//创建过滤器对象
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir,String name) {
				File currFile = new File(dir,name);
				if(currFile.isFile()&&name.endsWith(".java")) {
					return true;
				}else {
					return false;
				}
			}
		};
		//遍历过程,最好判断file对象是否存在。
		if(file.exists()) {
			String[] names = file.list(filter);		//获过滤后所有的文件名数组，String类型
			for(String name : names) {
				System.out.println(name);
			}
		}
	}
}
