/*
 * 使用带缓冲区的包装流BufferedReader和BufferedWriter有效地提高读写数据的效率。
 * 读取src.txt文本的内容并写入des.txt文本中。
 */
import java.io.*;
public class BufferedWriterDemo {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("src.txt"));
			bw = new BufferedWriter(new FileWriter("des.txt"));
			String str;
			while((str=br.readLine())!=null) {	//每次读取一行文本，判断是否到文件末尾
				bw.write(str);
				bw.newLine();	//写入一个换行符，该方法会根据不同的操作系统生成相应的换行符,否则第二行会接着第一行写入文件
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
				bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
