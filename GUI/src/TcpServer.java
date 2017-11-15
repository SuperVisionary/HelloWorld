import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 创建Socket服务，并指定要连接的主机和端口
 */
class TcpClient{
	public static void main(String[] args)throws Exception {
		//创建客户端的socket服务，指定目的主机和端口
		Socket s = new Socket("110.65.96.103",10010);
		
		//为了发送数据，应该获取socket流中的输出流
		OutputStream out = s.getOutputStream();
		
		out.write("tcp ge men lai le".getBytes());
		
		s.close();//关闭客户端
	}
}


/*
 * 需求：定义端点接收数据并打印在控制台上。
 * 
 * 服务端：
 * 1，建立服务端的socket服务。ServerSocket();
 * 	并监听一个端口。
 * 2，获取链接过来的客户端对象。
 * 	通过ServerSocket的accept方法。如果没有连接就会等，所以这个方法是阻塞式的
 * 3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据
 * 4，关闭服务端（可选操作）
 */
 class  TcpServer{
	public static void main(String[] args) throws Exception{
		//建立服务端socket服务，并监听一个端口。
		ServerSocket ss = new ServerSocket(10010);
		
		//通过accept方法获取连接过来的客户端对象
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//获取客户端发过来的数据，那么要使用客户端对象的读取流来读取
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();//关闭客户端
		ss.close();//可选操作
	}
}
