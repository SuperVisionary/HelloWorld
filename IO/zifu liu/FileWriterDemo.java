/*
 * ��FileWriter���ļ�writer.txtд������
 */
import java.io.*;
public class FileWriterDemo {
	public static void main(String[] args) {
		FileWriter write = null;
		try {
			//����һ��FileWriter�����������ļ���д������
			write = new FileWriter("writer.txt");
			String str = "��ã�����";
			write.write(str);		//��write�������Խ����ַ���
			write.write("\r\n");		//�������任�С��ַ�����write��Ҫ���С�
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				write.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
