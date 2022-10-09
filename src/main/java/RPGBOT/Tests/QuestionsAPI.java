package RPGBOT.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class QuestionsAPI {
	
	private static File file;
	private static char[] BanSymbols = {'@','?','&','!','#','$'};
	private Map<String, Object> lastQuestion;
	
	public static void createQuestion(String Question, List<String> answers, String category, String CorrectAnswer) throws IOException {
		
		Map<String, Object> data = new HashMap<>();
		
		data.put("Question", Question);
		data.put("Answers", answers);
		data.put("Category", category);
		data.put("CorrectAnswer", CorrectAnswer);
		
		String fileQuestionName = Question.replace(' ', '_');
		for(int i=0; i<BanSymbols.length; i++) {
			fileQuestionName = fileQuestionName.replace(BanSymbols[i], '_');
		}
		
		//"C:" + File.separator + "Users" + File.separator + "dimam" + File.separator + "OneDrive" + File.separator + "Рабочий стол" + File.separator + "Проекты" + File.separator + "Вопросы"
		//"C:" + File.separator +"Users" + File.separator + System.getProperty("user.name") + File.separator +"AppData" + File.separator + "Roaming" + File.separator + "JavaQuestions"
		
		String Source = "C:" + File.separator +"Users" + File.separator + System.getProperty("user.name") 
		+ File.separator +"AppData" + File.separator + "Roaming" 
			+ File.separator + "JavaQuestions" + File.separator + fileQuestionName + ".yml";
		file = new File(Source);
		
		PrintWriter writer = new PrintWriter(file);
		
		Yaml yaml = new Yaml();
		yaml.dump(data, writer);
	}
	
	public Map<String, Object> getRandomQuestion() throws FileNotFoundException {
		File path = new File("C:" + File.separator +"Users" + File.separator + System.getProperty("user.name") 
		+ File.separator +"AppData" + File.separator + "Roaming" + File.separator + "JavaQuestions");
		
		List<String> questions = new ArrayList<String>();
		
		for(String s : path.list()) {
			questions.add(s);
		}
		
		
		int randomQuestionNumber = 0+(int)(Math.random()*questions.size());
		
		File fileQuestion = new File("C:" + File.separator +"Users" + File.separator + System.getProperty("user.name") 
		+ File.separator + "AppData" + File.separator + "Roaming" + File.separator + "JavaQuestions" + File.separator +
				questions.get(randomQuestionNumber));
		
		Yaml yaml = new Yaml();
		
		lastQuestion = yaml.load(new FileInputStream(fileQuestion));
		return yaml.load(new FileInputStream(fileQuestion));
	}
	
	public boolean checkAnswer(String answer) {
		if(answer.toLowerCase().equalsIgnoreCase(lastQuestion.get("CorrectAnswer").toString().toLowerCase())) {
			return true;
		}
		return false;
	}
	
	
	
}
