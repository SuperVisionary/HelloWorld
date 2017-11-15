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
public class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("我的窗口");		//创建窗体
		f.setSize(500,400);	//设置窗体宽高
		f.setLocation(300, 200);	//设置窗体出现的位置
		//需要添加组件，要设置布局
		f.setLayout(new FlowLayout());	//设置流式布局，默认是边界布局
		Button b = new Button("按钮");		//创建按钮组件
		f.add(b);	//添加按钮
		f.setVisible(true);		//设置窗体可视化
		MywindowListener mw = new MywindowListener();
		f.addWindowListener(mw);
	}
}
//继承WindowAdapter类，重写windowClosing()方法
class MywindowListener extends WindowAdapter{
	//监听器监听事件对象做出处理
	public void windowClosing(WindowEvent e) {
		Window window = (Window)e.getComponent();	//返回事件的component对象再强转成Window类型
		window.dispose();
	}
} 
