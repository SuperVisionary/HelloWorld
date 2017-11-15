import java.net.*;
/*
 * ����ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ��
 * ˼·��
 * 1������udpsocket����
 * 2���ṩ���ݣ��������ݷ�װ�����ݰ��С�
 * 3��ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ��
 * 4���ر���Դ��
 */
class UdpSend {
	public static void main(String[] args)throws Exception {		
		DatagramSocket ds = new DatagramSocket(8888);//�������Ͷ˶˿ڣ�������ϵͳ�Զ�����
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("110.65.96.103"),10000);
		ds.send(dp);
		ds.close();
	} 
}



class UdpRece{
	public static void main(String[] args)throws Exception {
		//����udp socket�������˵�
		DatagramSocket ds = new DatagramSocket(10000);	//������ն˼����Ķ˿�
		
		while(true) {
			//�������ݰ������ڴ洢����
			byte[] buf = new byte[1024];		
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			
			//ͨ�������receive�������յ������ݴ������ݰ���
			ds.receive(dp);	//����ʽ����
			
			//ͨ�����ݰ��ķ�����ȡ���е�����
			String ip = dp.getAddress().getHostAddress();
			
			String data = new String(dp.getData(),0,dp.getLength());
			
			int port = dp.getPort();
			
			System.out.println(ip+"::"+data+"::"+port);
		}
		
		//�ر���Դ
		//ds.close();
	}
}