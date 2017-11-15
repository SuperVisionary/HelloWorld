import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * ����Socket���񣬲�ָ��Ҫ���ӵ������Ͷ˿�
 */
class TcpClient{
	public static void main(String[] args)throws Exception {
		//�����ͻ��˵�socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("110.65.96.103",10010);
		
		//Ϊ�˷������ݣ�Ӧ�û�ȡsocket���е������
		OutputStream out = s.getOutputStream();
		
		out.write("tcp ge men lai le".getBytes());
		
		s.close();//�رտͻ���
	}
}


/*
 * ���󣺶���˵�������ݲ���ӡ�ڿ���̨�ϡ�
 * 
 * ����ˣ�
 * 1����������˵�socket����ServerSocket();
 * 	������һ���˿ڡ�
 * 2����ȡ���ӹ����Ŀͻ��˶���
 * 	ͨ��ServerSocket��accept���������û�����Ӿͻ�ȣ������������������ʽ��
 * 3���ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ���ÿͻ��˶���Ķ�ȡ������ȡ������������
 * 4���رշ���ˣ���ѡ������
 */
 class  TcpServer{
	public static void main(String[] args) throws Exception{
		//���������socket���񣬲�����һ���˿ڡ�
		ServerSocket ss = new ServerSocket(10010);
		
		//ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//��ȡ�ͻ��˷����������ݣ���ôҪʹ�ÿͻ��˶���Ķ�ȡ������ȡ
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();//�رտͻ���
		ss.close();//��ѡ����
	}
}
