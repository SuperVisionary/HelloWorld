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
public class AwtDemo2 {
	public static void main(String[] args) {
		Frame f = new Frame("�ҵĴ���");		//��������
		f.setSize(500,400);	//���ô�����
		f.setLocation(300, 200);	//���ô�����ֵ�λ��
		f.setLayout(new FlowLayout());	//������ʽ���֣�Ĭ���Ǳ߽粼��
		Button b = new Button("��ť");		//������ť���
		f.add(b);	//��Ӱ�ť
		f.setVisible(true);		//���ô�����ӻ�
		//���������Ӵ��������
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//��ť��������������
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
