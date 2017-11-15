import java.net.*;
import java.io.*;
/*
 * 需求：上传图片
 */
/* 
 * 客户端。
 * 1，服务端点。
 * 2，读取客户端已有的图片数据。
 * 3，通过socket输出流将数据发给服务端。
 * 4，读取服务端反馈信息。
 * 5，关闭。
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
 * 服务器
 * 
 * 这个服务端有局限性。当A客户端连接上以后，被服务端获取到，服务端执行具体流程。
 * 这时B客户端连接进来只有等待。
 * 因为服务器端还没有处理完A客户端的请求，还要循环回来执行下一次accpet()方法。
 * 所以暂时获取不到B客户端对象。PicServer2对其改进
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
			
			out.write("上传成功".getBytes());
			
			fos.close();
			s.close();
		}
		
	}
}
