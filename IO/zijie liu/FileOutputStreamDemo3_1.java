/*
 * 改进FileOutputStreamDemo3，使用缓冲区拷贝文件。
 */
import java.io.*;
public class FileOutputStreamDemo3_1 {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream("source\\demo.txt");
			out = new FileOutputStream("target\\demo.txt");
			//定义一个int类型变量len记住读取读入缓冲区的字节数。
			int len;
			//一下是用缓冲区读写文件

			byte[] buff = new byte[1024];
			long begintime = System.currentTimeMillis();
			while((len=in.read(buff))!=-1) {	//从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
				out.write(len);//len个字节从指定 byte 数组写入此文件输出流中
			}
			long endtime = System.currentTimeMillis();
			System.out.println("拷贝文件时间："+(endtime-begintime)+"毫秒");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				in.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
