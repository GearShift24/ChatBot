package chat.model;

import chat.controller.ChatController;
import twitter4j.TwitterException;


public class CTECTwitter
{
	private ChatController baseController;
	
	
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		
	}
	
}
