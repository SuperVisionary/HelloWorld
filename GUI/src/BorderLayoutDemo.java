import java.awt.*;
import java.awt.event.*;
public class BorderLayoutDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame("BorderLayout");//���ô����еĲ��ֹ�����ΪBorderLayout
		frame.setLayout(new BorderLayout());
		frame.setBounds(300,200,400,300);
		frame.setVisible(true);
		Button but1 = new Button("����");
		Button but2 = new Button("����");
		Button but3 = new Button("�ϲ�");
		Button but4 = new Button("����");
		Button but5 = new Button("�в�");
		frame.add(but1, BorderLayout.EAST);
		frame.add(but2, BorderLayout.WEST);
		frame.add(but3, BorderLayout.SOUTH);
		frame.add(but4, BorderLayout.NORTH);
		frame.add(but5, BorderLayout.CENTER);
	}
}
