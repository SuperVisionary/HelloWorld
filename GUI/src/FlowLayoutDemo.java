import java.awt.*;
import java.awt.event.*;
public class FlowLayoutDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame("Layout");
		frame.setBounds(300,200,400,300);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));	//�����������룬ˮƽ���Ϊ20����ֱ���Ϊ30
		frame.setVisible(true);
		Button but1 = new Button("��1����ť");
		frame.add(but1);
		//����Ķ�����ÿ���һ�Ρ���һ����ť�����������һ����ť
		but1.addActionListener(new ActionListener() {
			private int num = 1;
			public void actionPerformed(ActionEvent e) {
				frame.add(new Button("��"+ ++num +"����ť"));
				frame.setVisible(true);
			}
		});
	}
}
