import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*
 * �����˵���Ĵ��ļ��ͱ����ļ�
 */
public class MyMenuTest {
	private Frame f;
	//TextArea ��������ʾ�ı��Ķ�������
	private TextArea ta;
	private MenuBar bar;
	private Menu fileMenu;
	private MenuItem openItem,saveItem,closeItem;
	//FileDialog ����ʾһ���Ի��򴰿ڣ��û����Դ���ѡ���ļ�
	private FileDialog openDia,saveDia;
	private File file;
	MyMenuTest(){
		//��ʼ��
		init();
	}
	public void init() {
		f=new Frame("my window");
		f.setBounds(300,100,650,600);
		
		ta = new TextArea();
		
		bar = new MenuBar();
		fileMenu = new Menu("�ļ�");
		
		openItem = new MenuItem("��");
		saveItem = new MenuItem("����");
		closeItem = new MenuItem("�˳�");
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem); 
		fileMenu.add(closeItem);
		bar.add(fileMenu);
		
		f.setMenuBar(bar);
		
		openDia = new FileDialog(f,"��Ҫ��",FileDialog.LOAD);
		saveDia = new FileDialog(f,"��Ҫ����",FileDialog.SAVE);
		
		f.add(ta);
		myEvent();
		f.setVisible(true);
	}
	private void myEvent() {
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file==null) {
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if(dirPath==null || fileName==null) {
						return;
					}
					file = new File(dirPath,fileName);
				}
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(file));
					String text = ta.getText();
					bw.write(text);
					bw.flush();
					bw.close();
				}catch(IOException ex) {
					throw new RuntimeException();
				}
			}
		});
		
		//�������Ŀʱ�����Ի�����
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				if(dirPath==null || fileName==null) {
					return; 
				}
				ta.setText("");
				file = new File(dirPath,fileName);
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line = null;
					while((line=br.readLine())!=null) {
						ta.append(line+"\r\n");
					}
					br.close();
				}catch(IOException ex) {
					throw new RuntimeException("��ȡʧ��");
				}
			}
		});
		
		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new MyMenuTest();
	}
}
