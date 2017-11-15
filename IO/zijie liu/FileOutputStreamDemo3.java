/*
 * 文件的拷贝
 * 首先在当前目录下创建文件夹source和target，然后在source文件夹中存放一个"demo.txt"文件。
 * 然后将文件拷贝到target文件夹中。
 */
/*
 * 运用字节流的缓冲区读取文件。
 */
import java.io.*;
public class FileOutputStreamDemo3 {
	public static void main(String[] args){
		InputStream in = null;//建立in引用，in在整个main函数内起作用
		OutputStream out = null;
		try {
			in = new FileInputStream("source\\demo.txt");
			out = new FileOutputStream("target\\demo.txt");
			int len;
			long begintime = System.currentTimeMillis();
			while((len=in.read())!=-1) {	//读取一个字节并判断是否督导文件末尾
				out.write(len);
			}
			long endtime = System.currentTimeMillis();
			System.out.println("拷贝文件时间:"+(endtime-begintime)+"毫秒");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(in!=null) {	////没有if语句会报错，因为如果in为空，in.close();语句无效,但是因为 用了try，所以没有if也行，因为in为空会抛出异常
				try{
					in.close();//in适用于整个main，不会报错
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(out!=null) {
				try{
					out.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
