import java.awt.*;
import java.awt.event.*;
/*
 * ����¼�
 */
public class FrameDemo2 {
	public static void main(String[] args) {
		final Frame frame = new Frame("WindowEvent");
		frame.setLayout(new FlowLayout());
		frame.setSize(400,300);
		frame.setLocation(300, 200);
		frame.setVisible(true);
		Button but = new Button("��ť");
		frame.add(but);
		but.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased---���ſ��¼�");
			}
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed---��갴���¼�");
			}
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited---����Ƴ���ť�¼�");
			}
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered---�����밴ť�����¼�");
			}
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==e.BUTTON1) {
					System.out.println("�������¼�");
				}
				if(e.getButton()==e.BUTTON2) {
					System.out.println("����м������¼�");
				}
				if(e.getButton()==e.BUTTON3) {
					System.out.println("����һ��¼�");
				}
			}
		});
	}
}
