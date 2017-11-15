import java.awt.*;
import java.awt.event.*;
public class GridLayoutDemo {
	public static void main(String[] args) {
		Frame frame = new Frame("GrilLayout");
		frame.setLayout(new GridLayout(3,3));
		frame.setBounds(400,300,400,400);
		frame.setVisible(true);
		//添加9个按钮到GridLayout中
		for(int i=1;i<=9;i++) {
			Button but = new Button("but"+i);
			frame.add(but);
		}
	}
}
