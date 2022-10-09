package DefaultPapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import RPGBOT.Tests.Programm.Page;
import RPGBOT.Tests.Programm.UI;

public class CorrectPage {
	
	private Page page;
	
	public void load() {
		
		JButton nextQuestButton = new JButton("Следующий вопрос"), 
				menuButton = new JButton("Меню"), 
				QuitButton = new JButton("Выйти");
		
		nextQuestButton.setBounds(215, 500, 150, 80);
		nextQuestButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QuestionPage qp = new QuestionPage();
				try {
					qp.open();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		menuButton.setBounds(415,500,150,80);
		menuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartPage sp = new StartPage();
				sp.openPage();
				
			}
		});
		
		QuitButton.setBounds(15, 500, 150, 80);
		QuitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UI.closeFrame();
				
			}
		});
		
		
		
		JLabel labe = new JLabel();
		labe.setText("Ого правильно!");
		labe.setBounds(215, 100, 150, 75);
		labe.setSize(110, 65);
		
		this.page = new Page();
		page.CreatePage(List.of(nextQuestButton, menuButton, QuitButton), List.of(labe));
	}
	
	public void openPage() {
		load();
		page.openPage();
	}
}
