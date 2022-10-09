package DefaultPapes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;

import RPGBOT.Tests.Main;
import RPGBOT.Tests.QuestionsAPI;
import RPGBOT.Tests.Programm.Page;
import RPGBOT.Tests.Programm.UI;

public class QuestionPage {
	private Page page;
	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException {
		this.page = new Page();
		
		
		
		QuestionsAPI question =  new QuestionsAPI();
		
		Map<String, Object> questionMap = question.getRandomQuestion();
		
		List<String> answers = (List<String>) questionMap.get("Answers");
		
		List<JButton> buttonsAnswers = new ArrayList<JButton>();
		
		int y = 300;
		
		for(String s : answers) {
			
			JButton button = new JButton(s);
			button.setBounds(215, y, 150, 70);
			y += 100;
			
			buttonsAnswers.add(button);
		}
		
		for(JButton b : buttonsAnswers) {
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(question.checkAnswer(b.getText())) {
						CorrectPage cp = new CorrectPage();
						cp.openPage();
					}else {
						UnCorrectPage ucp = new UnCorrectPage();
						ucp.openPage();
					}
					
				}
			});
		}
		
		JLabel label = new JLabel();
		label.setBounds(215, 100, 300, 150);
		label.setText(questionMap.get("Question").toString());
		
		page.CreatePage(buttonsAnswers, List.of(label));
		
		Main.pages_Map.put("question", page);
	}
	public void open() throws FileNotFoundException {
		load();
		page.openPage();
	}
}
