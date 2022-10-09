package RPGBOT.Tests.Programm;


import javax.swing.JFrame;

public class UI{
	
	private static Page lastPage;
	private String windowName;
	private int[] size;
	private static JFrame frame;
	
	/**
	 * 
	 * @param WindowName
	 * @param size - Массив где 0 - Ширина, 1 - Высота
	 * 
	 */
	
	public void createWindow(String WindowName, int[] size) {
		this.windowName = WindowName;
		this.size = size;
		
		UI.frame = new JFrame(WindowName);
		
		UI.frame.setSize(size[0], size[1]);
		UI.frame.setLayout(null);
		UI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.frame.setVisible(true);
		
	}
	
	public static void closeFrame() {
		UI.frame.dispose();
	}
	
	public void clearFrame() {
		UI.frame.getContentPane().removeAll();
		UI.frame.getContentPane().repaint();
	}
	
	public void setLastPage(Page page) {
		UI.lastPage = page;
	}
	
	public Page getLastPage() {
		return lastPage;
	}
	
	public String getWindowName() {
		return windowName;
	}
	public int[] getSize(){
		return size;
	}
	public JFrame getJFrame() {
		return UI.frame;
	}
}
