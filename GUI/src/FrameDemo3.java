import java.awt.*;
import java.awt.event.*;
/*
 * �����¼�
 */
public class FrameDemo3 {
	public static void main(String[] args) {
		Frame frame = new Frame("KeyEvent");
		frame.setLayout(new FlowLayout());
		frame.setBounds(300, 200, 400, 300);
		frame.setVisible(true);
		TextField tf = new TextField(30);
		frame.add(tf);
		//Ϊ�ı�����Ӽ����¼�������
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();	//���ؼ��̶�Ӧ������ֵ
				String s = KeyEvent.getKeyText(KeyCode);	//���ذ������ַ�������
				System.out.println("���������Ϊ��"+s+",");
				System.out.println("��Ӧ��KeyCodeΪ��"+KeyCode);
			}
		});
	}
}
