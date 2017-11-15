/*
 * 在程序开发中，经常需要对文本文件的内容进行读取，
 * 如果想从文件中直接读取字符变可以使用字符输入流FileReader，
 * 在当前目录下新建文件“reader.txt”并输入itcast。
 */
import java.io.*;
public class FileReaderDemo {
	public static void main(String[] args) {
		FileReader read = null;
		try {
			//创建一个FileReader对象用来读取文件中的字符
			read = new FileReader("reader.txt");
			int ch;
			while((ch=read.read())!=-1) {
				System.out.println(ch);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				read.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
