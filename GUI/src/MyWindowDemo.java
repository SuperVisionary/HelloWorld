import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*
 * 列出指定目录内容。
 * 对话框Dialog		
 */
public class MyWindowDemo {
	private Frame f;
	private TextField tf;	//对象是允许编辑单行文本的文本组件。
	private Button but;
	private TextArea ta;
	
	//正常情况不应该写Dialog再床体内，因为如果没用到Dialog会占用内存，为了方便演示才这样写
	private Dialog d;		//对话框窗体
	private Label lab;	//窗体不能直接写文本，只能添加组件
	private Button okBut;
	//对象是显示文本的多行区域。可以将它设置为允许编辑或只读
	MyWindowDemo(){
		init();
	}
	public void init(){
		f = new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(60);
		
		but = new Button("转到");
		
		ta = new TextArea(25,70);
		
		
		//f是d的所属窗体，设置为true时，必须操作完d操能进行其他操作
		d = new Dialog(f,"提示信息-self",true);	
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("确定");
		d.add(lab);
		d.add(okBut);
		
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
	}
	private void myEvent() {
		okBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});
		
		
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				//可以封装成寒素showDir()
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String dirPath = tf.getText();		//获取文本
					File dir = new File(dirPath);
					if(dir.exists() && dir.isDirectory()) {
						ta.setText("");	//清空上次显示的内容，注释改行看变化就懂
						String[] names = dir.list();	//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目
						for(String name : names) {
							ta.append(name+"\r\n");	//追加字符串后换行
						}
					}else {
						String info = "您输入的信息："+dirPath+"有误，请重新输入";
						lab.setText(info);
						d.setVisible(true);
					}
				}
			}
		});
		
		
		but.addActionListener(new ActionListener() {
			//发生操作时调用actionPerformed()方法
			public void actionPerformed(ActionEvent e) {
				//可以封装成寒素showDir()	
				String dirPath = tf.getText();		//获取文本
				File dir = new File(dirPath);
				if(dir.exists() && dir.isDirectory()) {
					ta.setText("");	//清空上次显示的内容，注释改行看变化就懂
					String[] names = dir.list();	//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目
					for(String name : names) {
						ta.append(name+"\r\n");	//追加字符串后换行
					}
				}else {
					String info = "您输入的信息："+dirPath+"有误，请重新输入";
					lab.setText(info);
					d.setVisible(true);
				}
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MyWindowDemo();
	}
}
