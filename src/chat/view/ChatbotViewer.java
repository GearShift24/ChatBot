package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatbotViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatbotViewer()
	{
		windowMessage = "This message is brought to you by chatbot";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbotIcon.jpg"));
		
		
	}
	
	
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon,null,"Type here Please").toString();
		
		return response;
	}
	
	
	public void displayMessage(String message)
	{
		
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public int collectUserOptions(String question)
	{
		int response = 0;
		
		JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
}
