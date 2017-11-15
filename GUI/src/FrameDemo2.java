import java.awt.*;
import java.awt.event.*;
/*
 * 鼠标事件
 */
public class FrameDemo2 {
	public static void main(String[] args) {
		final Frame frame = new Frame("WindowEvent");
		frame.setLayout(new FlowLayout());
		frame.setSize(400,300);
		frame.setLocation(300, 200);
		frame.setVisible(true);
		Button but = new Button("按钮");
		frame.add(but);
		but.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased---鼠标放开事件");
			}
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed---鼠标按下事件");
			}
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited---鼠标移出按钮事件");
			}
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered---鼠标进入按钮区域事件");
			}
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==e.BUTTON1) {
					System.out.println("鼠标左击事件");
				}
				if(e.getButton()==e.BUTTON2) {
					System.out.println("鼠标中间键点击事件");
				}
				if(e.getButton()==e.BUTTON3) {
					System.out.println("鼠标右击事件");
				}
			}
		});
	}
}
