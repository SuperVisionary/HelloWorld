import java.net.*;
import java.io.*;
/*
 * 每次运行都要改端口，因为接收端的端口号没有释放
 * 聊天界面，既有接收又有发送功能
 */
class Send implements Runnable{
	private DatagramSocket ds;
	public Send(DatagramSocket ds) {
		this.ds = ds;
	}
	
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			
			while((line=bufr.readLine())!=null) {
				if("886".equals(line)) {
					break;
				}
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = 
						new DatagramPacket(buf,buf.length,InetAddress.getByName("110.65.96.103"),9200);
				
				ds.send(dp);
			}
		}catch(Exception e) {
			throw new RuntimeException("发送端失败");
		}
	}
}

class Rece implements Runnable{
	private DatagramSocket ds;
	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}
	
	public void run() {
		try {
			while(true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				
				ds.receive(dp);
				
				String ip = dp.getAddress().getHostAddress();
				
				String data = new String(dp.getData(),0,dp.getLength());
				
				System.out.println(ip+"::"+data);
				
				//ds.close();	关闭会提示接收端失败
			}
		}catch(Exception e) {
			throw new RuntimeException("接收端失败");
		}
	}
}
public class ChatDemo {
	public static void main(String[] args)throws Exception {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(9200);
		
		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
	}
}
