import java.awt.*;
import java.awt.event.*;
/*
 * 制作菜单
 */
public class MyMenuDemo {
	private Frame f;
	private MenuBar mb;	//MenuBar 类封装绑定到框架的菜单栏的平台概念
	private Menu m,subMenu;		//Menu 对象是从菜单栏部署的下拉式菜单组件。
	private MenuItem closeItem,subItem;	//菜单中的所有项必须属于类 MenuItem 或其子类之一。 
	MyMenuDemo(){
		init();
	}
	public void init() {
		f = new Frame("my window");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());
		
		mb = new MenuBar();
		m = new Menu("文件"); 	//文件菜单
		subMenu = new Menu("子菜单");	//子菜单
		subItem = new MenuItem("子条目");	//子条目项	
		closeItem = new MenuItem("退出");	//退出项
		
		m.add(subMenu);	//m菜单中添加子菜单subMenu
		subMenu.add(subItem);//子菜单subMenu中添加子条目subItem
		
		m.add(closeItem);	// 将指定的菜单项添加到此菜单
		mb.add(m);	// 将指定的菜单添加到菜单栏。
		
		
		f.setMenuBar(mb);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent() {
		//事件源
		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MyMenuDemo();
	}
}
