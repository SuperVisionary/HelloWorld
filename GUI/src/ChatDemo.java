import java.net.*;
import java.io.*;
/*
 * ÿ�����ж�Ҫ�Ķ˿ڣ���Ϊ���ն˵Ķ˿ں�û���ͷ�
 * ������棬���н������з��͹���
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
			throw new RuntimeException("���Ͷ�ʧ��");
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
				
				//ds.close();	�رջ���ʾ���ն�ʧ��
			}
		}catch(Exception e) {
			throw new RuntimeException("���ն�ʧ��");
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
