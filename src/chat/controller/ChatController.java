package chat.controller;

import chat.model.Chatbot;

import chat.view.ChatFrame;
import chat.view.ChatbotViewer;
/**
 * imports the frame viewer and model to be manipulated with
 */
/**
 * The controller that gives commands to the programs other pieces MVC approach
 * @author joey Wrigley
 *12/2/2016
 */
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
	
	/**
	 * Starts up the program, ran from runner
	 */
		public void start()
		{
		

		}
	
	/**
	 * This method see if any of the checkers are activated and responds with pre-made quotes
	 * @param input The input given by the user
	 * @return  is the response by one of the checkers confirmed true that is given to the bot
	 */
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
	
	/**
	 * starts up chatbot for use
	 * @return gives back chatbot for use
	 */
	public Chatbot getChatbot()
	{
		return stupidBot;
	}
	/**
	 * grabs the frame instructions
	 * @return gives back the frame instructions
	 */
	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}
/**
 * Generates a random topic from 7 options
 * @return Is what random topic that was chosen is returned
 */
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
	
	
	public void handleErrors(Exception currentException){
		display.displayMessage("An arror has occurred. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}
}


			