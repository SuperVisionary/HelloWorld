/*
 * 可以跟踪行号的输入流：LineNmuberReader，它是BufferedReader的直接子类。
 * 该案例演示拷贝"FileWriterDemo.java"文件时如何为文件加上行号。
 * 问了方便，只throws Exception。
 */
import java.io.*;
public class LineNumberReaderDemo {
	public static void main(String[] args)throws Exception {
		FileReader  fr = new FileReader("D:\\eclipse-workspace\\IO\\字符流\\FileWriterDemo.java");
		FileWriter fw = new FileWriter("copy.java");
		LineNumberReader lr = new LineNumberReader(fr);	//包装
		lr.setLineNumber(0);		//设置读取文件的起始行号
		String line=null;
		while((line=lr.readLine())!=null) {
			fw.write(lr.getLineNumber()+":"+line);
			fw.write("\r\n");		//写入换行
		}
		fr.close();
		fw.close();
		lr.close();
	}
}
