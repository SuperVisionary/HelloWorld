/*
 * ���Ը����кŵ���������LineNmuberReader������BufferedReader��ֱ�����ࡣ
 * �ð�����ʾ����"FileWriterDemo.java"�ļ�ʱ���Ϊ�ļ������кš�
 * ���˷��㣬ֻthrows Exception��
 */
import java.io.*;
public class LineNumberReaderDemo {
	public static void main(String[] args)throws Exception {
		FileReader  fr = new FileReader("D:\\eclipse-workspace\\IO\\�ַ���\\FileWriterDemo.java");
		FileWriter fw = new FileWriter("copy.java");
		LineNumberReader lr = new LineNumberReader(fr);	//��װ
		lr.setLineNumber(0);		//���ö�ȡ�ļ�����ʼ�к�
		String line=null;
		while((line=lr.readLine())!=null) {
			fw.write(lr.getLineNumber()+":"+line);
			fw.write("\r\n");		//д�뻻��
		}
		fr.close();
		fw.close();
		lr.close();
	}
}
