/*
 * ����"D:\\eclipse-workspace\\IO\\�ֽ���"Ŀ¼��������.java��β���ļ�
 */
import java.io.*;
public class FilenameFilterDemo {
	public static void main(String[] args) {
		File file = new File("D:\\eclipse-workspace\\IO\\�ֽ���");//����File����
		//��������������
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir,String name) {
				File currFile = new File(dir,name);
				if(currFile.isFile()&&name.endsWith(".java")) {
					return true;
				}else {
					return false;
				}
			}
		};
		//��������,����ж�file�����Ƿ���ڡ�
		if(file.exists()) {
			String[] names = file.list(filter);		//����˺����е��ļ������飬String����
			for(String name : names) {
				System.out.println(name);
			}
		}
	}
}
