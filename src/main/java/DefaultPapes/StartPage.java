package DefaultPapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import RPGBOT.Tests.Main;
import RPGBOT.Tests.Programm.Page;
import RPGBOT.Tests.Programm.UI;

public class StartPage {
	private Page page;
	public void load() {
		JButton startButton = new JButton("Start"), quitButton = new JButton("Quit");
		
		startButton.setBounds(215, 300, 200, 80);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new QuestionPage().open();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		quitButton.setBounds(215, 400, 200, 80);
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UI.closeFrame();
			}
		});
		
		List<JButton> buttons = new ArrayList<JButton>();
		buttons.add(quitButton);
		buttons.add(startButton);
		
		List<JLabel> labels = new ArrayList<JLabel>();
		JLabel label = new JLabel();
		label.setText("Это супер крутой тест хочешь пройти?");
		label.setBounds(210, 100, 250, 70);
		labels.add(label);
		
		
		this.page = new Page();
		
		page.CreatePage(buttons, labels);
		
		Main.pages_Map.put("start", page);
	}
	
	public void openPage() {
		load();
		page.openPage();
	}
}
