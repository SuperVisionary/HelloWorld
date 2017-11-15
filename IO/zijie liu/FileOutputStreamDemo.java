import java.io.FileOutputStream;
public class FileOutputStreamDemo {
	public static void main(String[] args)throws Exception {
		FileOutputStream out = new FileOutputStream("example.txt");
		String s = "黄泽维";
		int a = 37;
		byte[] b = s.getBytes();
		out.write(a);
		for(int x=0;x<b.length;x++) {
			out.write(b[x]);
		}
		out.write(b);//和for循环效果一样
		out.close();
	}
}
