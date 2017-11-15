import java.awt.*;
import java.awt.event.*;
/*
 * 窗体事件？
 */
public class FrameDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("WindowEvent");
		frame.setBounds(300,200,400,300);
		frame.setVisible(true);
		//使用内部类创建WindowListener实例对象，监听窗体事件
		frame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("WindowOpened---窗体打开事件");
			}
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified---窗体标准化事件");
			}
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified---窗体取消标准化事件");
			}
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated---窗体停用事件");
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing---窗体正在关闭事件");
			}
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed---窗体关闭事件");
			}
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivate---窗体激活事件");
			}
		});
	}
}
