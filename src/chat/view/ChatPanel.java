package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;

import chat.controller.ChatController;
/**
 * imported many awt and swing files to change design and shape of GUI. Imported controller to allow control of panel.
 */
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
	
	private JScrollPane chatScroll;
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
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -264, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -301, SpringLayout.EAST, this);
		chatButton = new JButton("Chat with the bot nerrrrd!");
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 19, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 136, SpringLayout.WEST, this);
		chatCheckBox = new JCheckBox("CHANGE TO CODE FORM", false);
		baseLayout.putConstraint(SpringLayout.NORTH, chatCheckBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatCheckBox, 502, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatCheckBox, -10, SpringLayout.EAST, this);
		chatScroll = new JScrollPane();
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 17, SpringLayout.SOUTH, chatScroll);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatScroll);
		baseLayout.putConstraint(SpringLayout.WEST, chatScroll, 89, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatScroll, -307, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatScroll, 51, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatScroll, -311, SpringLayout.SOUTH, this);
		chatScroll.setViewportView(chatDisplay);
		
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
		this.setPreferredSize(new Dimension(700, 450));
		this.setBackground(Color.MAGENTA);
		this.add(chatButton);
//		this.add(chatDisplay);
		this.add(chatField);
		this.add(chatCheckBox);
		
		
		
		this.add(chatScroll);
	
		
		
	}
	/*
	 * setups the auto generated code that changes orientation of all objects inside the panel
	 */
	private void setupLayout()
	{
	baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 34, SpringLayout.NORTH, this);
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
