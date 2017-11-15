/*
 * RandomAccessFile不是流类，但是具有读写文件数据的功能，
 * 可以随机地从文件 的任何位置开始执行读写数据的操作。
 * RandomAccessFile在使劲开发中也有常见的应用，例如一些软件在使用时需要付费，但是一般有几次免费试用的机会。
 * 创建"time.txt"文件并输入65作为软件试用的次数。
 */
import java.io.*;
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("time.txt","rw");
		int times = 0;
		times = Integer.parseInt(raf.readLine());	//将数据读取到的String类型数据转换为int型
		if(times>0) {
			//试用一次，次数减少一次
			System.out.println("你还可以试用"+times--+"次");
			raf.seek(0);	//使记录指针指向文件的开头
			raf.writeBytes(times+"");	//将剩余的次数以字符串形式再次写入文件，如果以整形写入会转换成二进制
		}else {
			System.out.println("软件试用次数已到");
		}
		raf.close();
	}	
}
