package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatbotViewer
{

	
	
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question);
		
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
