/*
 * ɾ���ļ���Ŀ¼
 */
import java.io.*;
public class FileDemo4 {
	public static void main(String[] args) {
		File file = new File("D:\\cn");
		deleteDir(file);
	}
	public static void deleteDir(File dir) {
		 if(dir.exists()) {
			 File[] files = dir.listFiles();//��ñ�ʾĿ¼�� �����ļ������飬 file.listFiles()����ֵ��File����
			 for(File file : files) {
				 if(file.isDirectory()) {
					 deleteDir(file);
				 }else {
					 //������ļ���ֱ��ɾ��
					file.delete(); 
				 }				 
			 }
			 //ɾ����һ��Ŀ¼�µ��ļ�ɾ��Ŀ¼
			 dir.delete();
		 }
	}
}
