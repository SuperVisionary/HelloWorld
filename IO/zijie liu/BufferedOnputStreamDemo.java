/*
 * 字节缓冲流 BufferedOnputStream，缓冲流是通过底层被包装的字节流于设备进行关联的。
 * 装饰设计模式（包装类）思想。
 */
import java.io.*;
public class BufferedOnputStreamDemo {
	public static void main(String[] args) throws Exception{
		
		//创建一个带缓冲区的输入流
		BufferedInputStream bis = null; 
		//创建一个带缓冲区的输出流
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("src.txt"));
			bos = new BufferedOutputStream(new FileOutputStream("src2.txt"));
			int len;
			long begintime = System.currentTimeMillis();
			while((len=bis.read())!=-1) {
				bos.write(len);
			}
			long endtime = System.currentTimeMillis();
			System.out.println("拷贝文件时间："+(endtime-begintime)+"毫秒");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			bis.close();
			bos.close();
		}
		
	}
}
