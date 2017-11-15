import java.io.FileInputStream;
public class FileInputStreamDemo {
	public static void main(String[] args) throws Exception{
		FileInputStream in = new FileInputStream("test.txt");//D:\\eclipse-workspace\\IO\\test.txt
		int b = 0;
		while(true) {
			b=in.read();
			if(b==-1) {
				break;
			}
			System.out.println(b);
		}
		in.close();
	}
}
