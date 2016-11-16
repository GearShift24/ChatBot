package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JCheckBox chatCheckBox;
	
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
		this.add(chatCheckBox);
	}
	
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
