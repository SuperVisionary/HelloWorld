import java.awt.*;
import java.awt.event.*;
/*
 * ����ͼ�λ�����
 * 1,����Frame����
 * 2���Դ�����л�������
 * 3���������
 * 4�������ͨ�������add������ӵ������С�
 * 5���ô�����ʾ��ͨ��setVisible(true);
 */
public class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("�ҵĴ���");		//��������
		f.setSize(500,400);	//���ô�����
		f.setLocation(300, 200);	//���ô�����ֵ�λ��
		//��Ҫ��������Ҫ���ò���
		f.setLayout(new FlowLayout());	//������ʽ���֣�Ĭ���Ǳ߽粼��
		Button b = new Button("��ť");		//������ť���
		f.add(b);	//��Ӱ�ť
		f.setVisible(true);		//���ô�����ӻ�
		MywindowListener mw = new MywindowListener();
		f.addWindowListener(mw);
	}
}
//�̳�WindowAdapter�࣬��дwindowClosing()����
class MywindowListener extends WindowAdapter{
	//�����������¼�������������
	public void windowClosing(WindowEvent e) {
		Window window = (Window)e.getComponent();	//�����¼���component������ǿת��Window����
		window.dispose();
	}
} 
