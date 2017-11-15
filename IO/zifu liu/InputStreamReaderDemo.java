/*
 * ת����Ҳ��һ�ְ�װ����InputStreamReader��Reader�����࣬OutputStreamWriter��writer�����ࡣ
 * ���ֽ���ת��Ϊ�ַ�����Ϊ�����Ч�ʣ�����ͨ��BufferedReader��BufferedWriter��ת�������а�װ��
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
