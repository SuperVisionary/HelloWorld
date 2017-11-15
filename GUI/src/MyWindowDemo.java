import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*
 * �г�ָ��Ŀ¼���ݡ�
 * �Ի���Dialog		
 */
public class MyWindowDemo {
	private Frame f;
	private TextField tf;	//����������༭�����ı����ı������
	private Button but;
	private TextArea ta;
	
	//���������Ӧ��дDialog�ٴ����ڣ���Ϊ���û�õ�Dialog��ռ���ڴ棬Ϊ�˷�����ʾ������д
	private Dialog d;		//�Ի�����
	private Label lab;	//���岻��ֱ��д�ı���ֻ��������
	private Button okBut;
	//��������ʾ�ı��Ķ������򡣿��Խ�������Ϊ����༭��ֻ��
	MyWindowDemo(){
		init();
	}
	public void init(){
		f = new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(60);
		
		but = new Button("ת��");
		
		ta = new TextArea(25,70);
		
		
		//f��d���������壬����Ϊtrueʱ�����������d���ܽ�����������
		d = new Dialog(f,"��ʾ��Ϣ-self",true);	
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("ȷ��");
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
				//���Է�װ�ɺ���showDir()
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String dirPath = tf.getText();		//��ȡ�ı�
					File dir = new File(dirPath);
					if(dir.exists() && dir.isDirectory()) {
						ta.setText("");	//����ϴ���ʾ�����ݣ�ע�͸��п��仯�Ͷ�
						String[] names = dir.list();	//����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ
						for(String name : names) {
							ta.append(name+"\r\n");	//׷���ַ�������
						}
					}else {
						String info = "���������Ϣ��"+dirPath+"��������������";
						lab.setText(info);
						d.setVisible(true);
					}
				}
			}
		});
		
		
		but.addActionListener(new ActionListener() {
			//��������ʱ����actionPerformed()����
			public void actionPerformed(ActionEvent e) {
				//���Է�װ�ɺ���showDir()	
				String dirPath = tf.getText();		//��ȡ�ı�
				File dir = new File(dirPath);
				if(dir.exists() && dir.isDirectory()) {
					ta.setText("");	//����ϴ���ʾ�����ݣ�ע�͸��п��仯�Ͷ�
					String[] names = dir.list();	//����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ
					for(String name : names) {
						ta.append(name+"\r\n");	//׷���ַ�������
					}
				}else {
					String info = "���������Ϣ��"+dirPath+"��������������";
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
