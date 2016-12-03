package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;

import chat.controller.ChatController;
/**
 * The panel is where you chat with the bot, and where the data members that are interactable/seen are placed
 * @author joey Wrigley
 *12/2/2016
 */
public class ChatPanel extends JPanel
{
	/**
	 * creates objects to later be innitated and used
	 */
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JCheckBox chatCheckBox;
	/*
	 * inits objects and sets the controller
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot nerrrrd!");
		chatCheckBox = new JCheckBox("CHANGE TO CODE FORM", false);

		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/*
	 * setsup the chatdisplay which is used to chat with the user
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
		
	}
	
	/*
	 * sets up properties of panel and adds objects into panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatButton);
		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatCheckBox);
	}
	/*
	 * setups the auto generated code that changes orientation of all objects inside the panel
	 */
	private void setupLayout()
	{		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -76, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 209, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -29, SpringLayout.NORTH, chatButton);
	baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 34, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.NORTH, chatCheckBox, 0, SpringLayout.NORTH, chatField);
	baseLayout.putConstraint(SpringLayout.EAST, chatCheckBox, -8, SpringLayout.WEST, chatField);
	}
	/*
	 * method that gives code connection to when gui is pressed
	 * When clicked the bot will take in your code
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String personWords = chatField.getText();
				String chatbotResponse = baseController.useChatbotCheckers(personWords);
				
				chatDisplay.setText("You said: " + personWords + "\n" + "Chatbot Says: " + chatbotResponse);
				
				
			}
		});
	
	
	
		
		
//		
	chatCheckBox.addItemListener(new ItemListener()
	{
//	
		public void itemStateChanged(ItemEvent e)
		{
//			chatField.setFont(new Font("Serif",Font.BOLD,14));
//			chatDisplay.setFont(new Font("Serif",Font.BOLD,14));
//		
//			System.out.println("Checked? " + chatCheckBox.isSelected());
			
			chatField.setFont(e.getStateChange() == ItemEvent.SELECTED ? (new Font("Serif",Font.BOLD,14)) : new Font("Wingdings",Font.BOLD,14));
			chatDisplay.setFont(e.getStateChange() == ItemEvent.SELECTED ? (new Font("Serif",Font.BOLD,14)) : new Font("Wingdings",Font.BOLD,14));
	}
	});
//	
	
	}
	
}
