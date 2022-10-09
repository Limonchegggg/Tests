package RPGBOT.Tests.Programm;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Page {
	private List<JButton> buttons;
	private List<JTextField> textFields;
	private List<JLabel> label;
	
	public void CreatePage(List<JButton> buttons) {
		this.buttons = buttons;
	}
	public void CreatePage(List<JButton> buttons, List<JLabel> label) {
		this.buttons = buttons;
		this.label = label;
	}
	
	public void openPage() {
		UI ui = new UI();
		if(ui.getLastPage() != null) {
			ui.clearFrame();
		}
		if(buttons != null) {
			for(JButton b : buttons) {
				ui.getJFrame().add(b);
			}
		}
		if(label != null) {
			for(JLabel l : label) {
				ui.getJFrame().add(l);
			}
		}
		ui.setLastPage(this);
	}

	public List<JButton> getButtons() {
		return buttons;
	}

	public List<JTextField> getTextFields() {
		return textFields;
	}

	public List<JLabel> getLabel() {
		return label;
	}
	
}
