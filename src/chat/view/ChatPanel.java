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
	
	private JButton sendTweetButton;
	private JButton searchTwitterButton;
	private JButton saveChatButton;
	private JButton loadChatButton;
	
	private JScrollPane chatPane;
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
		chatCheckBox = new JCheckBox("Change Font", false);
		chatPane = new JScrollPane();

		
		
		
		
		
		sendTweetButton = new JButton("send A Tweet");
		searchTwitterButton = new JButton("Search Twitter");
		saveChatButton = new JButton("save chat");
		loadChatButton = new JButton("load chat");
		
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
		
		chatPane.setViewportView(chatDisplay);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
		
		this.add(sendTweetButton);
		this.add(searchTwitterButton);
		this.add(saveChatButton);
		this.add(loadChatButton);
		
		
		this.add(chatPane);
		
		
		
	}
	/*
	 * setups the auto generated code that changes orientation of all objects inside the panel
	 */
	private void setupLayout()
	{
	baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 34, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -264, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.EAST, chatField, -301, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, loadChatButton, 0, SpringLayout.NORTH, sendTweetButton);
	baseLayout.putConstraint(SpringLayout.EAST, loadChatButton, 0, SpringLayout.EAST, chatField);
	baseLayout.putConstraint(SpringLayout.NORTH, saveChatButton, 0, SpringLayout.NORTH, searchTwitterButton);
	baseLayout.putConstraint(SpringLayout.EAST, saveChatButton, 0, SpringLayout.EAST, chatField);
	baseLayout.putConstraint(SpringLayout.NORTH, sendTweetButton, 6, SpringLayout.SOUTH, searchTwitterButton);
	baseLayout.putConstraint(SpringLayout.WEST, sendTweetButton, 0, SpringLayout.WEST, searchTwitterButton);
	baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, 80, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, searchTwitterButton, -153, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.NORTH, chatField, 17, SpringLayout.SOUTH, chatPane);
	baseLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
	baseLayout.putConstraint(SpringLayout.WEST, chatPane, 89, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.EAST, chatPane, -307, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 51, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -311, SpringLayout.SOUTH, this);
	baseLayout.putConstraint(SpringLayout.NORTH, chatCheckBox, 10, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.WEST, chatCheckBox, 502, SpringLayout.WEST, this);
	baseLayout.putConstraint(SpringLayout.EAST, chatCheckBox, -10, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 19, SpringLayout.SOUTH, chatField);
	baseLayout.putConstraint(SpringLayout.WEST, chatButton, 136, SpringLayout.WEST, this);
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
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText(currentText + "\nYou said: " + personWords + "\n" + "Chatbot Says: " + chatbotResponse +"\n");
				chatDisplay.setCaretPosition(chatDisplay.getCaretPosition());
				chatField.setText("");
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
