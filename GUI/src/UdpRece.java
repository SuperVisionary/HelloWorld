import java.net.*;
/*
 * 需求：通过udp传输方式，将一段文字数据发送出去。
 * 思路：
 * 1，建立udpsocket服务。
 * 2，提供数据，并将数据封装到数据包中。
 * 3，通过socket服务的发送功能，将数据包发出去。
 * 4，关闭资源。
 */
class UdpSend {
	public static void main(String[] args)throws Exception {		
		DatagramSocket ds = new DatagramSocket(8888);//给定发送端端口，不给定系统自动分配
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("110.65.96.103"),10000);
		ds.send(dp);
		ds.close();
	} 
}



class UdpRece{
	public static void main(String[] args)throws Exception {
		//创建udp socket，建立端点
		DatagramSocket ds = new DatagramSocket(10000);	//定义接收端监听的端口
		
		while(true) {
			//定义数据包，用于存储数据
			byte[] buf = new byte[1024];		
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			
			//通过服务的receive方法将收到的数据存入数据包中
			ds.receive(dp);	//阻塞式方法
			
			//通过数据包的方法获取其中的数据
			String ip = dp.getAddress().getHostAddress();
			
			String data = new String(dp.getData(),0,dp.getLength());
			
			int port = dp.getPort();
			
			System.out.println(ip+"::"+data+"::"+port);
		}
		
		//关闭资源
		//ds.close();
	}
}