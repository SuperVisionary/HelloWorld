/*
 * ����D:\eclipse-workspace\IO\�ֽ���Ŀ¼�µ������ļ���Ŀ¼��
 * ʹ��foreach��ӡfile
 */
import java.io.*;
public class FileDemo2 {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\�ֽ���");
		//��������
		if(file.isDirectory()) {
			String[] names = file.list();	//��ȡĿ¼�������ļ����ļ���,String����
			for(String name : names) {
				System.out.println(name);
			}
		}
	}
}
