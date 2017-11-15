/*
 * 转换流也是一种包装流，InputStreamReader是Reader的子类，OutputStreamWriter是writer的子类。
 * 将字节流转换为字符流，为了提高效率，可以通过BufferedReader和BufferedWriter对转换流进行包装。
 */
import java.io.*;
public class InputStreamReaderDemo {
	public static void main(String[] args)throws Exception {
		FileInputStream in = new FileInputStream("src.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		FileOutputStream out = new FileOutputStream("des2.txt");
		OutputStreamWriter isw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(isw);
		String line;
		while((line=br.readLine())!=null) {
			bw.write(line);
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
