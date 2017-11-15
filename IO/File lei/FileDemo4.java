/*
 * 删除文件及目录
 */
import java.io.*;
public class FileDemo4 {
	public static void main(String[] args) {
		File file = new File("D:\\cn");
		deleteDir(file);
	}
	public static void deleteDir(File dir) {
		 if(dir.exists()) {
			 File[] files = dir.listFiles();//获得表示目录下 所有文件的数组， file.listFiles()返回值是File类型
			 for(File file : files) {
				 if(file.isDirectory()) {
					 deleteDir(file);
				 }else {
					 //如果是文件，直接删除
					file.delete(); 
				 }				 
			 }
			 //删除完一个目录下的文件删除目录
			 dir.delete();
		 }
	}
}
