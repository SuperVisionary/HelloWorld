/*
 * RandomAccessFile�������࣬���Ǿ��ж�д�ļ����ݵĹ��ܣ�
 * ��������ش��ļ� ���κ�λ�ÿ�ʼִ�ж�д���ݵĲ�����
 * RandomAccessFile��ʹ��������Ҳ�г�����Ӧ�ã�����һЩ�����ʹ��ʱ��Ҫ���ѣ�����һ���м���������õĻ��ᡣ
 * ����"time.txt"�ļ�������65��Ϊ������õĴ�����
 */
import java.io.*;
public class RandomAccessFileDemo {
	public static void main(String[] args) throws Exception{
		RandomAccessFile raf = new RandomAccessFile("time.txt","rw");
		int times = 0;
		times = Integer.parseInt(raf.readLine());	//�����ݶ�ȡ����String��������ת��Ϊint��
		if(times>0) {
			//����һ�Σ���������һ��
			System.out.println("�㻹��������"+times--+"��");
			raf.seek(0);	//ʹ��¼ָ��ָ���ļ��Ŀ�ͷ
			raf.writeBytes(times+"");	//��ʣ��Ĵ������ַ�����ʽ�ٴ�д���ļ������������д���ת���ɶ�����
		}else {
			System.out.println("������ô����ѵ�");
		}
		raf.close();
	}	
}
