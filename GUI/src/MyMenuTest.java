import java.awt.*;
import java.awt.event.*;
import java.io.*;
/*
 * 制作菜单里的打开文件和保存文件
 */
public class MyMenuTest {
	private Frame f;
	//TextArea 对象是显示文本的多行区域
	private TextArea ta;
	private MenuBar bar;
	private Menu fileMenu;
	private MenuItem openItem,saveItem,closeItem;
	//FileDialog 类显示一个对话框窗口，用户可以从中选择文件
	private FileDialog openDia,saveDia;
	private File file;
	MyMenuTest(){
		//初始化
		init();
	}
	public void init() {
		f=new Frame("my window");
		f.setBounds(300,100,650,600);
		
		ta = new TextArea();
		
		bar = new MenuBar();
		fileMenu = new Menu("文件");
		
		openItem = new MenuItem("打开");
		saveItem = new MenuItem("保存");
		closeItem = new MenuItem("退出");
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem); 
		fileMenu.add(closeItem);
		bar.add(fileMenu);
		
		f.setMenuBar(bar);
		
		openDia = new FileDialog(f,"我要打开",FileDialog.LOAD);
		saveDia = new FileDialog(f,"我要保存",FileDialog.SAVE);
		
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
		
		//点击打开条目时弹出对话窗口
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
					throw new RuntimeException("读取失败");
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
