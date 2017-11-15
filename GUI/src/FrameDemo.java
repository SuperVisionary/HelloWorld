import java.awt.*;
import java.awt.event.*;
/*
 * �����¼���
 */
public class FrameDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("WindowEvent");
		frame.setBounds(300,200,400,300);
		frame.setVisible(true);
		//ʹ���ڲ��ഴ��WindowListenerʵ�����󣬼��������¼�
		frame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("WindowOpened---������¼�");
			}
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified---�����׼���¼�");
			}
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified---����ȡ����׼���¼�");
			}
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated---����ͣ���¼�");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing---�������ڹر��¼�");
			}
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed---����ر��¼�");
			}
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivate---���弤���¼�");
			}
		});
	}
}
