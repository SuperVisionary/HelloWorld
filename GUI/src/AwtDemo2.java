import java.awt.*;
import java.awt.event.*;
/*
 * 创建图形化界面
 * 1,创建Frame窗体
 * 2，对窗体进行基本设置
 * 3，定义组件
 * 4，将组件通过窗体的add方法添加到窗体中。
 * 5，让窗体显示，通过setVisible(true);
 */
public class AwtDemo2 {
	public static void main(String[] args) {
		Frame f = new Frame("我的窗口");		//创建窗体
		f.setSize(500,400);	//设置窗体宽高
		f.setLocation(300, 200);	//设置窗体出现的位置
		f.setLayout(new FlowLayout());	//设置流式布局，默认是边界布局
		Button b = new Button("按钮");		//创建按钮组件
		f.add(b);	//添加按钮
		f.setVisible(true);		//设置窗体可视化
		//窗体组件添加窗体监听器
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//按钮组件添加鼠标监听器
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
