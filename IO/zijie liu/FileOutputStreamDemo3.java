/*
 * �ļ��Ŀ���
 * �����ڵ�ǰĿ¼�´����ļ���source��target��Ȼ����source�ļ����д��һ��"demo.txt"�ļ���
 * Ȼ���ļ�������target�ļ����С�
 */
/*
 * �����ֽ����Ļ�������ȡ�ļ���
 */
import java.io.*;
public class FileOutputStreamDemo3 {
	public static void main(String[] args){
		InputStream in = null;//����in���ã�in������main������������
		OutputStream out = null;
		try {
			in = new FileInputStream("source\\demo.txt");
			out = new FileOutputStream("target\\demo.txt");
			int len;
			long begintime = System.currentTimeMillis();
			while((len=in.read())!=-1) {	//��ȡһ���ֽڲ��ж��Ƿ񶽵��ļ�ĩβ
				out.write(len);
			}
			long endtime = System.currentTimeMillis();
			System.out.println("�����ļ�ʱ��:"+(endtime-begintime)+"����");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(in!=null) {	////û��if���ᱨ����Ϊ���inΪ�գ�in.close();�����Ч,������Ϊ ����try������û��ifҲ�У���ΪinΪ�ջ��׳��쳣
				try{
					in.close();//in����������main�����ᱨ��
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(out!=null) {
				try{
					out.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
