package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatbotViewer;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatbotViewer display;
	private ChatFrame chatFrame;	
	
	public ChatController()
	{
		stupidBot = new Chatbot("wall-e");
		display = new ChatbotViewer();
		chatFrame = new ChatFrame(this);
	}
	
	
		public void start()
		{
			String response = display.collectResponse("What do you wanna talk about baby? 8)");
			
			while(stupidBot.lengthChecker(response))
			{
				display.displayMessage(useChatbotCheckers(response));
				response = display.collectResponse("wow, you want to talk about " + response + "?  Tell me more!");
			
				
			}
			
			//if you put in an input it keeps going, if you have no response or null it goes here and closes the application
			
			getBaseFrame();
			getChatbot();
		}
	
		public Chatbot getChatbot()
		{
			return stupidBot;
		}
		
		public ChatFrame getBaseFrame()
		{
			return chatFrame;
		}
		
//		public String communicateWithChatbot(String userText)
//		{
//			String botText = "";
//			
//			
//			
//			return botText;
//		}
//		
	public String useChatbotCheckers(String input)
	{
		
		String checkedInput = "";
		
		if(stupidBot.memeChecker(input))
		{
			checkedInput += "\nYou like memes!\n";
		}
		if(stupidBot.contentChecker(input))
		{
			checkedInput += "\nYou know my secret topic!\n";
		}
		if(stupidBot.politicalTopicChecker(input))
		{
			checkedInput += "\n you enjoy politics";
		}
		if(stupidBot.twitterChecker(input))
		{
			checkedInput += "\n you are using twitter methinks";
		}
		
		if(stupidBot.quitChecker(input))
		{
			System.exit(0);
		}
		if(checkedInput.length() == 0)
		{
			checkedInput = "I have no idea what you mean about " + input;
		}
	
		return checkedInput;

	}
}


			