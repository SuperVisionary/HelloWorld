import java.io.FileOutputStream;
public class FileOutputStreamDemo2 {
	public static void main(String[] args)throws Exception {
		FileOutputStream out = new FileOutputStream("example.txt",true);//��example׷������
		String s = "��ӭ��";
		byte[] b = s.getBytes();//���ַ���ת��Ϊ�ֽ�
		out.write(b);
		out.close();
	}
}
