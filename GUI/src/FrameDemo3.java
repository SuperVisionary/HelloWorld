import java.awt.*;
import java.awt.event.*;
/*
 * 键盘事件
 */
public class FrameDemo3 {
	public static void main(String[] args) {
		Frame frame = new Frame("KeyEvent");
		frame.setLayout(new FlowLayout());
		frame.setBounds(300, 200, 400, 300);
		frame.setVisible(true);
		TextField tf = new TextField(30);
		frame.add(tf);
		//为文本框添加键盘事件监听器
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();	//返回键盘对应的整数值
				String s = KeyEvent.getKeyText(KeyCode);	//返回案件的字符串描述
				System.out.println("输入的内容为："+s+",");
				System.out.println("对应的KeyCode为："+KeyCode);
			}
		});
	}
}
