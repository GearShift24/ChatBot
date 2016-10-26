package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatbotViewer;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatbotViewer display;
		
	public ChatController()
	{
		stupidBot = new Chatbot("wall-e");
		display = new ChatbotViewer();
	}
	
	
		public void start()
		{
			String response = display.collectResponse("What do you wanna talk about baby? 8)");
			
			while(stupidBot.lengthChecker(response))
			{
				display.displayMessage(useChatbotCheckers(response));
				display.collectResponse("wow, you want to talk about " + response + "?  Tell me more!");
				
			}
			
			//if you put in an input it keeps going, if you have no response or null it goes here and closes the application
		}
	
	private String useChatbotCheckers(String input)
	{
		String checkedInput = "I have idea what you mean...";
		
		if(stupidBot.memeChecker(input))
		{
			checkedInput += "\nYou like memes!\n";
		}
		if(stupidBot.contentChecker(input))
		{
			checkedInput += "\nYou know my secret topic!\n";
		}
		
		
		
		return checkedInput;
	}
}


			