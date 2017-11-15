/*
 * �ڳ��򿪷��У�������Ҫ���ı��ļ������ݽ��ж�ȡ��
 * �������ļ���ֱ�Ӷ�ȡ�ַ������ʹ���ַ�������FileReader��
 * �ڵ�ǰĿ¼���½��ļ���reader.txt��������itcast��
 */
import java.io.*;
public class FileReaderDemo {
	public static void main(String[] args) {
		FileReader read = null;
		try {
			//����һ��FileReader����������ȡ�ļ��е��ַ�
			read = new FileReader("reader.txt");
			int ch;
			while((ch=read.read())!=-1) {
				System.out.println(ch);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				read.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
