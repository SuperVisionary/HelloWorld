import java.net.*;
import java.io.*;
/*
 * 建立一个文本转换服务器。
 * 客户端给服务器发送文本，服务端会将文本转成大写再返回给客户端。
 * 二期客户端可以不断的进行文本转换，当客户端输入over时，转换结束。
 * 
 * 分析：
 * 客户端：
 * 既然时操作设备上的数据，那么就可以使用io技术，并按照io的操作规律来思考。
 * 源：键盘录入。
 * 目的：网络设备，网络输出流。而且操作的时文本数据，可以选择字符流。
 * 
 * 步骤：
 * 1，建立服务。
 * 2，获取键盘录入。
 * 3，将数据发送给服务端。
 * 4，获取服务端返回的大写数据。
 * 5，结束，关资源。
 * 
 * 都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲。
 */
class TransClient {
	public static void main(String[] args)throws Exception {
		Socket s = new Socket("110.65.96.103",10012);
		
		//定义读取键盘数据的流对象
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		//定义目睹，将数据写入到socket输出流，发送给服务器。
		BufferedWriter bufOut = 
				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//定义一个socket读取流，读取服务器端返回的大写信息。
		BufferedReader bufIn =
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		while((line=bufr.readLine())!=null) {
			//输入over结束键盘输入
			if("over".equals(line)) {
				break;
			}
			// 写入一个行分隔符。代表改行结束，没有读取到结束标识符会一致等待
			bufOut.write(line+"\r\n");//可以不加+"\r\n"，换成bufOut.newLine();换行语句。
			//刷新后缓冲区的数据才输出
			bufOut.flush();
			
			//等待服务器回复数据再读取
			String str = bufIn.readLine();
			
			System.out.println("server:"+str);
		}
		bufr.close();
		bufIn.close();
		bufOut.close();
	}
} 

/*
 * 服务端：
 * 源：socket读取流。
 * 目的：socket输出流。
 * 都是文本，装饰。
 */
class TransServer{
	public static void main(String[] args)throws Exception {
		ServerSocket ss = new ServerSocket(10012);
		
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//读取socket读取流中的数据。
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//目的。socket输出流，将大写数据写入到socket输出流，并发送给客户端。
		//BufferedWriter bufOut = 
				//new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		String line = null;
		while((line=bufIn.readLine())!=null) {
			System.out.println(line);
			out.println(line.toUpperCase());
			//将字符串转换成大写输出到缓冲区
			//bufOut.write(line.toUpperCase());
			// 写入一个行分隔符。代表改行结束，没有读取到结束标识符会一致等待
			//bufOut.newLine();
			//刷新后缓冲区的数据才输出
			//bufOut.flush();
			
		}
		s.close();
		ss.close();
	}
}
