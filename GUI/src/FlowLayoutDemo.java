import java.awt.*;
import java.awt.event.*;
public class FlowLayoutDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame("Layout");
		frame.setBounds(300,200,400,300);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));	//所有组件左对齐，水平间距为20，垂直间距为30
		frame.setVisible(true);
		Button but1 = new Button("第1个按钮");
		frame.add(but1);
		//下面的对吗是每点击一次“第一个按钮”就向窗体添加一个按钮
		but1.addActionListener(new ActionListener() {
			private int num = 1;
			public void actionPerformed(ActionEvent e) {
				frame.add(new Button("第"+ ++num +"个按钮"));
				frame.setVisible(true);
			}
		});
	}
}
