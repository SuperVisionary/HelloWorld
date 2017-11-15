import java.net.*;
import java.io.*;
/*
 * ��ʾtcp�Ĵ���Ŀͻ��˺ͷ���˵Ļ��á�
 * 
 * ���󣺿ͻ��˸�����˷������ݣ�������յ��󣬸��ͻ��˷�����Ϣ��
 */


/*
 * �ͻ��ˣ�
 * 1������socket����ָ��Ҫ���������Ͷ˿ڡ�
 * 2����ȡsocket���е��������������д�������У�ͨ�����緢�͸�����ˡ�
 * 3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ��
 * 4���رտͻ�����Դ��
 */
class TcpClient2{
	public static void main(String[] args)throws Exception {
		Socket s = new Socket("110.65.96.103",10006);
		
		OutputStream out = s.getOutputStream();
		
		out.write("����ˣ����".getBytes());
		
		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024]; 
		
		//������˻ظ���Ϣʱ��ִ���������䡣����Է�û�з������ݣ��͵ȴ�
		int len = in.read(buf);//��ȡ��socket��
		
		System.out.println(new String(buf,0,len));
		
		s.close();
	}
}
class TcpServer2 {
	public static void main(String[] args)throws Exception {
		ServerSocket ss = new ServerSocket(10006);
		
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		
		System.out.println(ip+"...connected");
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		//����˽��յ�����ʱҪ���ж�ȡ
		int len = in.read(buf);	//
		
		System.out.println(new String(buf,0,len));
		
		OutputStream out = s.getOutputStream();
		
		out.write("�����յ�,��Ҳ�� ".getBytes());
		s.close();
		ss.close();
	}
}
