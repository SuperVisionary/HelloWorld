import java.net.*;
import java.io.*;
/*
 * 需求：上传图片
 * 用dos命令行运行
 */
/* 
 * 客户端。
 * 1，服务端点。
 * 2，读取客户端已有的图片数据。
 * 3，通过socket输出流将数据发给服务端。
 * 4，读取服务端反馈信息。
 * 5，关闭。
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
			
			//创建以ip命名的文件
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
			
			out.write("上传成功".getBytes());
			
			fos.close();
			s.close();
		}catch(Exception e) {
			throw new RuntimeException(ip+"上传失败");
		}
	}
}
class PicClient2{
	public static void main(String[] args)throws Exception {
		if(args.length!=1) {
			System.out.println("请选择一个jpg格式的图片");
			return;
		}
		
		File file = new File(args[0]);
		
		if(!(file.exists()&&file.isFile())) {
			System.out.println("该文件有问题，要么不存在，要么不是文件");
			return;
		}
		
		if(!file.getName().endsWith(".jpg")) {
			System.out.println("图片格式错误，请重新选择");
			return;
		}
		
		if(file.length()>1024*1024*5) {
			System.out.println("文件过大");
			return;
		}
		
		Socket s = new Socket("110.65.96.103",10015);
		
		//输出不固定文件名的文件
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
 * 服务端将每个客户端封装到一个单独的线程中，这样就可以同时处理多个客户端请求。
 * 如何定义线程？
 * 只要明确每一个客户端要在服务器执行的代码即可，将该代码存入run方法中。
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