package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatbotViwer;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatbotViwer display;
		
	public ChatController()
	{
		stupidBot = new Chatbot("wall-e");
		display = new ChatbotViwer();
	}
	
	
		public void start()
		{
			String response = "words";
			
			while(stupidBot.lengthChecker(response))
			{
				
				response = display.collectResponse("What do you wanna talk about fammmmmiliiiaaaa???????");
			}
			
			//if you put in an input it keeps going, if you have no response or null it goes here and closes the application
		}
	
	
}


			