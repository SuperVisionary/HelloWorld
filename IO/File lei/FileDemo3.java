/*
 * ��ӡ"D:\\eclipse-workspace\\IO\\�ֽ���"Ŀ¼�µ��ļ�����Ŀ¼�µ��ļ�
 */
import java.io.*;	
public class FileDemo3 {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\�ֽ���");	//����File����
		fileDir(file);
	}
	public static void fileDir(File dir) {
		//��������
		File[] files = dir.listFiles();//��ñ�ʾĿ¼�� �����ļ������飬 file.listFiles()����ֵ��File����
		for(File file : files) {
			if(file.isDirectory()) {
				fileDir(file);
			}
			System.out.println(file);
		}
	}
}
