package chat.controller;
/**
 * The file that begins the code chain
 * @author joey
 *12/2/2016
 */
public class ChatbotRunner
/**
 * Begins the application and sets ChatController up to use it
 */
{
	public static void main (String [] args)
	{
		
		ChatController chatAppController = new ChatController();
		chatAppController.start();
	}
}
