import java.net.*;
import java.io.*;
/*
 * ����һ���ı�ת����������
 * �ͻ��˸������������ı�������˻Ὣ�ı�ת�ɴ�д�ٷ��ظ��ͻ��ˡ�
 * ���ڿͻ��˿��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת��������
 * 
 * ������
 * �ͻ��ˣ�
 * ��Ȼʱ�����豸�ϵ����ݣ���ô�Ϳ���ʹ��io������������io�Ĳ���������˼����
 * Դ������¼�롣
 * Ŀ�ģ������豸����������������Ҳ�����ʱ�ı����ݣ�����ѡ���ַ�����
 * 
 * ���裺
 * 1����������
 * 2����ȡ����¼�롣
 * 3�������ݷ��͸�����ˡ�
 * 4����ȡ����˷��صĴ�д���ݡ�
 * 5������������Դ��
 * 
 * �����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺�塣
 */
class TransClient {
	public static void main(String[] args)throws Exception {
		Socket s = new Socket("110.65.96.103",10012);
		
		//�����ȡ�������ݵ�������
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		//����Ŀ�ã�������д�뵽socket����������͸���������
		BufferedWriter bufOut = 
				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//����һ��socket��ȡ������ȡ�������˷��صĴ�д��Ϣ��
		BufferedReader bufIn =
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		while((line=bufr.readLine())!=null) {
			//����over������������
			if("over".equals(line)) {
				break;
			}
			// д��һ���зָ�����������н�����û�ж�ȡ��������ʶ����һ�µȴ�
			bufOut.write(line+"\r\n");//���Բ���+"\r\n"������bufOut.newLine();������䡣
			//ˢ�º󻺳��������ݲ����
			bufOut.flush();
			
			//�ȴ��������ظ������ٶ�ȡ
			String str = bufIn.readLine();
			
			System.out.println("server:"+str);
		}
		bufr.close();
		bufIn.close();
		bufOut.close();
	}
} 

/*
 * ����ˣ�
 * Դ��socket��ȡ����
 * Ŀ�ģ�socket�������
 * �����ı���װ�Ρ�
 */
class TransServer{
	public static void main(String[] args)throws Exception {
		ServerSocket ss = new ServerSocket(10012);
		
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//��ȡsocket��ȡ���е����ݡ�
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//Ŀ�ġ�socket�����������д����д�뵽socket������������͸��ͻ��ˡ�
		//BufferedWriter bufOut = 
				//new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		
		String line = null;
		while((line=bufIn.readLine())!=null) {
			System.out.println(line);
			out.println(line.toUpperCase());
			//���ַ���ת���ɴ�д�����������
			//bufOut.write(line.toUpperCase());
			// д��һ���зָ�����������н�����û�ж�ȡ��������ʶ����һ�µȴ�
			//bufOut.newLine();
			//ˢ�º󻺳��������ݲ����
			//bufOut.flush();
			
		}
		s.close();
		ss.close();
	}
}
