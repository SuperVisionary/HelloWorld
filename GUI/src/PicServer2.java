import java.net.*;
import java.io.*;
/*
 * �����ϴ�ͼƬ
 * ��dos����������
 */
/* 
 * �ͻ��ˡ�
 * 1������˵㡣
 * 2����ȡ�ͻ������е�ͼƬ���ݡ�
 * 3��ͨ��socket����������ݷ�������ˡ�
 * 4����ȡ����˷�����Ϣ��
 * 5���رա�
 */
class PicThread implements Runnable{
	private Socket s; 
	PicThread(Socket s){
		this.s = s;
	}
	public void run() {
		int count = 1;
		String ip = s.getInetAddress().getHostAddress();
		try {
			System.out.println(ip+"...connected");
			
			InputStream in = s.getInputStream();
			
			//������ip�������ļ�
			File file = new File(ip+"("+(count)+")"+".jpg");
			
			while(file.exists()) {
				file = new File(ip+"("+(count++)+")"+".jpg");
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			
			while((len=in.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			
			OutputStream out = s.getOutputStream();
			
			out.write("�ϴ��ɹ�".getBytes());
			
			fos.close();
			s.close();
		}catch(Exception e) {
			throw new RuntimeException(ip+"�ϴ�ʧ��");
		}
	}
}
class PicClient2{
	public static void main(String[] args)throws Exception {
		if(args.length!=1) {
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;
		}
		
		File file = new File(args[0]);
		
		if(!(file.exists()&&file.isFile())) {
			System.out.println("���ļ������⣬Ҫô�����ڣ�Ҫô�����ļ�");
			return;
		}
		
		if(!file.getName().endsWith(".jpg")) {
			System.out.println("ͼƬ��ʽ����������ѡ��");
			return;
		}
		
		if(file.length()>1024*1024*5) {
			System.out.println("�ļ�����");
			return;
		}
		
		Socket s = new Socket("110.65.96.103",10015);
		
		//������̶��ļ������ļ�
		FileInputStream fis = new FileInputStream(file);
		
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
 * ����˽�ÿ���ͻ��˷�װ��һ���������߳��У������Ϳ���ͬʱ�������ͻ�������
 * ��ζ����̣߳�
 * ֻҪ��ȷÿһ���ͻ���Ҫ�ڷ�����ִ�еĴ��뼴�ɣ����ô������run�����С�
 */
class PicServer2 {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(10015);
		
		while(true) {
			Socket s = ss.accept();
		
			new Thread(new PicThread(s)).start(); 
		}
		
	}
}