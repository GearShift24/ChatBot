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
		if(stupidBot.inputHTMLChecker(input))
		{
			checkedInput += "\n YOU ARE USING A WEBSITE URL AINT YOU, U WOT M8?";
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
			randomTopic =". Think about politics qwith captional latters";
			break;
			
		case 3:
			randomTopic =". Think about a certian nintendo character";
			break;
			
		case 4:
			randomTopic =". Think of a chocolate Factory";
			break;
			
		case 5:
			randomTopic =". Think of the ussr";
			break;
			
		case 6:
			randomTopic =". TRY MASHING!";
			break;
			
		case 7:
			randomTopic =". Think about a green frog.";
			break;
			
		default:
			randomTopic = ". Think king harkanian!";
			break;
			
			

		}
		
		return randomTopic;
	}
}


			