package chat.view;


import javax.swing.JFrame;

import chat.controller.ChatController;
import java.awt.Dimension;
/**
 * imports Jframe for the basic frame, the controller to controll the frame, and dimensions to choose dimensions
 */
/**
 * The frame creates the area where a panel can be places and sets size / visibility 
 * @author joey Wrigley
 *12/2/2016
 */
public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	/**
	 * Runs the frame and creates a panel to be used
	 * @param baseController the controller used for creating the GUI
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	/**
	 * sets up the dimensions of the frame and makes it visible
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Fem-Shep Chat");
		this.setSize(new Dimension(1280,720));
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
