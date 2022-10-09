package RPGBOT.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import DefaultPapes.StartPage;
import RPGBOT.Tests.Programm.Page;
import RPGBOT.Tests.Programm.UI;

public class Main {
	
	public static Map<String, Page> pages_Map = new HashMap<String, Page>();
	
	public static void main(String[] args) throws IOException {
		
		
		
		
		new StartPage().load();
		
		UI ui = new UI();
		
		int[] size = {640, 800};
		ui.createWindow("Test", size);
		pages_Map.get("start").openPage();
		
	}
}
