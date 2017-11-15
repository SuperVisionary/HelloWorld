/*
 * 用FileWriter向文件writer.txt写入数据
 */
import java.io.*;
public class FileWriterDemo {
	public static void main(String[] args) {
		FileWriter write = null;
		try {
			//创建一个FileWriter对象用于向文件中写入数据
			write = new FileWriter("writer.txt");
			String str = "你好，广州";
			write.write(str);		//该write方法可以接受字符串
			write.write("\r\n");		//将输出语句换行。字符流的write都要换行。
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				write.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
