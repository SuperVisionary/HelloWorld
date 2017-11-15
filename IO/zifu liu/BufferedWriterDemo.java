/*
 * ʹ�ô��������İ�װ��BufferedReader��BufferedWriter��Ч����߶�д���ݵ�Ч�ʡ�
 * ��ȡsrc.txt�ı������ݲ�д��des.txt�ı��С�
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
			while((str=br.readLine())!=null) {	//ÿ�ζ�ȡһ���ı����ж��Ƿ��ļ�ĩβ
				bw.write(str);
				bw.newLine();	//д��һ�����з����÷�������ݲ�ͬ�Ĳ���ϵͳ������Ӧ�Ļ��з�,����ڶ��л���ŵ�һ��д���ļ�
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
