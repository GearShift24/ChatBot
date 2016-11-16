package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot nerrrrd!");

		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setLineWrap(true);
		
	}
	
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatButton);
		this.add(chatDisplay);
		this.add(chatField);
	}
	
	private void setupLayout()
	{		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -76, SpringLayout.EAST, this);
	baseLayout.putConstraint(SpringLayout.EAST, chatDisplay, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 209, SpringLayout.NORTH, this);
	baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -29, SpringLayout.NORTH, chatButton);
	baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatButton);
	baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 34, SpringLayout.NORTH, this);
	}
	
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
	}
}
