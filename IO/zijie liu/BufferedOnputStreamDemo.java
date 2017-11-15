/*
 * �ֽڻ����� BufferedOnputStream����������ͨ���ײ㱻��װ���ֽ������豸���й����ġ�
 * װ�����ģʽ����װ�ࣩ˼�롣
 */
import java.io.*;
public class BufferedOnputStreamDemo {
	public static void main(String[] args) throws Exception{
		
		//����һ������������������
		BufferedInputStream bis = null; 
		//����һ�����������������
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("src.txt"));
			bos = new BufferedOutputStream(new FileOutputStream("src2.txt"));
			int len;
			long begintime = System.currentTimeMillis();
			while((len=bis.read())!=-1) {
				bos.write(len);
			}
			long endtime = System.currentTimeMillis();
			System.out.println("�����ļ�ʱ�䣺"+(endtime-begintime)+"����");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			bis.close();
			bos.close();
		}
		
	}
}
