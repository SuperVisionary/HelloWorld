import java.net.*;
import java.io.*;
/*
 * 需求：客户端上传文件到服务器
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
		
		s.shutdownOutput();//注意：关闭客户端的输出流。相当于给六种加入一个结束标记 -1.
							//如果禁用此套接字的输出流，服务器的bufIn.readLine()还会等待接收数据
							//执行到该主函数下面的bufIn.readLine()时两边都再等待接收数据。
							//可以在服务器端while循环定义if判断语句结束循环。
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
		
		//关联到socket输入流
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out = 
				new PrintWriter(new FileWriter("server.txt"),true);
		
		String line = null;
		
		//只有客户端socket输出流禁用后即s.shutdownOutput();该循环才停止
		while((line=bufIn.readLine())!=null) {
			out.println(line);
		}
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("上传成功");
		
		out.close();
		s.close();
		ss.close();
	}
}
