import java.awt.*;
import java.awt.event.*;
/*
 * �����˵�
 */
public class MyMenuDemo {
	private Frame f;
	private MenuBar mb;	//MenuBar ���װ�󶨵���ܵĲ˵�����ƽ̨����
	private Menu m,subMenu;		//Menu �����ǴӲ˵������������ʽ�˵������
	private MenuItem closeItem,subItem;	//�˵��е���������������� MenuItem ��������֮һ�� 
	MyMenuDemo(){
		init();
	}
	public void init() {
		f = new Frame("my window");
		f.setBounds(300,100,500,600);
		f.setLayout(new FlowLayout());
		
		mb = new MenuBar();
		m = new Menu("�ļ�"); 	//�ļ��˵�
		subMenu = new Menu("�Ӳ˵�");	//�Ӳ˵�
		subItem = new MenuItem("����Ŀ");	//����Ŀ��	
		closeItem = new MenuItem("�˳�");	//�˳���
		
		m.add(subMenu);	//m�˵�������Ӳ˵�subMenu
		subMenu.add(subItem);//�Ӳ˵�subMenu���������ĿsubItem
		
		m.add(closeItem);	// ��ָ���Ĳ˵�����ӵ��˲˵�
		mb.add(m);	// ��ָ���Ĳ˵���ӵ��˵�����
		
		
		f.setMenuBar(mb);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent() {
		//�¼�Դ
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
