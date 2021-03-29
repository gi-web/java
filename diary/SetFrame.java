package diary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class SetFrame extends JFrame{
public SetFrame() {
	createMenu();
	setSize(200,300); setVisible(true);
}
void createMenu() { 
	JMenuBar mb = new JMenuBar(); // 메뉴바 생성
	JMenuItem [] menuItem = new JMenuItem [4];
	String[] itemTitle = {"폰트", "테마", "로그아웃", "종료"};
	JMenu screenMenu = new JMenu("");
	screenMenu.setIcon(new ImageIcon(MFrame.class.getResource("/Diary/SET.png")));
	MenuActionListener listener = new MenuActionListener(); 
	for(int i=0; i<menuItem.length; i++) {
		menuItem[i] = new JMenuItem(itemTitle[i]); 
		menuItem[i].addActionListener(listener);
		screenMenu.add(menuItem[i]);
}
	mb.setBounds(100,50,50,10);
	mb.add(screenMenu); 
	setJMenuBar(mb); 
}
class MenuActionListener implements ActionListener { 
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand(); 
		switch(cmd) { // 메뉴 아이템의 종류 구분
			case "Exit" :
				System.exit(0); break;
				}
			}
		}
public static void main(String[] args) {
	new SetFrame();
}
}
