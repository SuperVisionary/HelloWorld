import java.io.FileOutputStream;
public class FileOutputStreamDemo2 {
	public static void main(String[] args)throws Exception {
		FileOutputStream out = new FileOutputStream("example.txt",true);//往example追加内容
		String s = "欢迎你";
		byte[] b = s.getBytes();//将字符串转换为字节
		out.write(b);
		out.close();
	}
}
