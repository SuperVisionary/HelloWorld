import java.net.*;
import java.io.*;
/*
 * ���󣺿ͻ����ϴ��ļ���������
 */
class TextClient{
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("110.65.96.103",10014);
		
		BufferedReader bufr = 
				new BufferedReader(new FileReader("wuyong.txt"));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		
		while((line=bufr.readLine())!=null) {
			out.println(line);
		}
		
		s.shutdownOutput();//ע�⣺�رտͻ��˵���������൱�ڸ����ּ���һ��������� -1.
							//������ô��׽��ֵ����������������bufIn.readLine()����ȴ���������
							//ִ�е��������������bufIn.readLine()ʱ���߶��ٵȴ��������ݡ�
							//�����ڷ�������whileѭ������if�ж�������ѭ����
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		bufIn.close();
		out.close();
	}
}
class TextServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10014);
		
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//������socket������
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out = 
				new PrintWriter(new FileWriter("server.txt"),true);
		
		String line = null;
		
		//ֻ�пͻ���socket��������ú�s.shutdownOutput();��ѭ����ֹͣ
		while((line=bufIn.readLine())!=null) {
			out.println(line);
		}
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");
		
		out.close();
		s.close();
		ss.close();
	}
}
