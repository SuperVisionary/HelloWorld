/*
 * �Ľ�FileOutputStreamDemo3��ʹ�û����������ļ���
 */
import java.io.*;
public class FileOutputStreamDemo3_1 {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream("source\\demo.txt");
			out = new FileOutputStream("target\\demo.txt");
			//����һ��int���ͱ���len��ס��ȡ���뻺�������ֽ�����
			int len;
			//һ�����û�������д�ļ�

			byte[] buff = new byte[1024];
			long begintime = System.currentTimeMillis();
			while((len=in.read(buff))!=-1) {	//�Ӵ��������н���� b.length ���ֽڵ����ݶ���һ�� byte �����С�
				out.write(len);//len���ֽڴ�ָ�� byte ����д����ļ��������
			}
			long endtime = System.currentTimeMillis();
			System.out.println("�����ļ�ʱ�䣺"+(endtime-begintime)+"����");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				in.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
