import java.net.*;
import java.io.*;
/*
 * �����ϴ�ͼƬ
 */
/* 
 * �ͻ��ˡ�
 * 1������˵㡣
 * 2����ȡ�ͻ������е�ͼƬ���ݡ�
 * 3��ͨ��socket����������ݷ�������ˡ�
 * 4����ȡ����˷�����Ϣ��
 * 5���رա�
 */
class PicClient{
	public static void main(String[] args)throws Exception {
		Socket s = new Socket("110.65.96.103",10015);
		
		FileInputStream fis = new FileInputStream("pic.jpg");
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;		
		while((len=fis.read(buf))!=-1) {
			out.write(buf,0,len);
		}		
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		
		byte[] bufIn = new byte[1024];
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		
		fis.close();
		s.close();
	}
}

/*
 * ������
 * 
 * ���������о����ԡ���A�ͻ����������Ժ󣬱�����˻�ȡ���������ִ�о������̡�
 * ��ʱB�ͻ������ӽ���ֻ�еȴ���
 * ��Ϊ�������˻�û�д�����A�ͻ��˵����󣬻�Ҫѭ������ִ����һ��accpet()������
 * ������ʱ��ȡ����B�ͻ��˶���PicServer2����Ľ�
 */
class PicServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10015);
		
		while(true) {
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip+"...connected");
			
			InputStream in = s.getInputStream();
			
			FileOutputStream fos = new FileOutputStream("server.jpg");
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			
			while((len=in.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			
			OutputStream out = s.getOutputStream();
			
			out.write("�ϴ��ɹ�".getBytes());
			
			fos.close();
			s.close();
		}
		
	}
}
