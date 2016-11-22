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
		
		getBaseFrame();
		getChatbot();
		randomTopicGenerator();
	}
	
	
		public void start()
		{
		

		}
	
	
	public String useChatbotCheckers(String input)
	{
	String checkedInput = "";
	if(!stupidBot.quitChecker(input))
	{
		
		
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
		
		if(!stupidBot.lengthChecker(checkedInput))
		{
			checkedInput = "I have no idea what you mean about " + input;
		}
		
		int canBeRandom = (int) (Math.random() * 7);
		if(canBeRandom % 7 == 0)
		{
			checkedInput += randomTopicGenerator();
		}
	}
	
	else{
		display.displayMessage("Thanks for chatting! See you soon bb");
		System.exit(0);
		}
	
		return checkedInput;
	}
	
	
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	
	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}

	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
		case 0:
			randomTopic = ". Have you seen hugh mungas :o?";
			break;
			
		case 1:
			randomTopic =". think about shrek";
			
		case 2:
			randomTopic =". hink about politics qwith captional latters";
			break;
			
		case 3:
			randomTopic =". Think about wordssss";
			break;
			
		case 4:
			randomTopic =". Candy cheese";
			break;
			
		case 5:
			randomTopic =". Words wrods wrods";
			break;
			
		case 6:
			randomTopic =". Hehe ecks deeeeeeee";
			break;
			
		case 7:
			randomTopic =". What uuuuu what m8";
			break;
			
		default:
			randomTopic = ". This cant be happening!";
			break;
			
			

		}
		
		return randomTopic;
	}
}


			