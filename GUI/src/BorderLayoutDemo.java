import java.awt.*;
import java.awt.event.*;
public class BorderLayoutDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame("BorderLayout");//设置窗体中的布局管理器为BorderLayout
		frame.setLayout(new BorderLayout());
		frame.setBounds(300,200,400,300);
		frame.setVisible(true);
		Button but1 = new Button("东部");
		Button but2 = new Button("西部");
		Button but3 = new Button("南部");
		Button but4 = new Button("北部");
		Button but5 = new Button("中部");
		frame.add(but1, BorderLayout.EAST);
		frame.add(but2, BorderLayout.WEST);
		frame.add(but3, BorderLayout.SOUTH);
		frame.add(but4, BorderLayout.NORTH);
		frame.add(but5, BorderLayout.CENTER);
	}
}
