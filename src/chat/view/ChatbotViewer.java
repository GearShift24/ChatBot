package chat.view;

import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
/**
 * imported JOptionPane to create a popout and ImageIcon to allow for an icon to be placed.
 */
/**
 * The view creates what the bot used to say and what was said back
 * @author joey Wrigley
 *12/2/2016
 */

public class ChatbotViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	/*
	 *puts a message and icon within the viewer
	 */
	public ChatbotViewer()
	{
		windowMessage = "This message is brought to you by chatbot";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.jpg"));
		
		
	}
	
	/**
	 * Collects user input and responds correspondingly. As well returns a message asking user to question again
	 * @param question takes the user input and uses it to get a response
	 * @return returns the response of the bot and a message to type here pleae
	 */
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon,null,"Type here Please").toString();
		
		return response;
	}
	
	/**
	 * displays a pre-made message
	 * @param message the preset responses made by the creator that are send to be displayed
	 */
	public void displayMessage(String message)
	{
		
		JOptionPane.showMessageDialog(null, message);
		
	}
	/**
	 * checks to see if there is user input
	 * @param question the user input
	 * @return returns if there is input or not to the bot
	 */
	public int collectUserOptions(String question)
	{
		int response = 0;
		
		JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
	

	

}
