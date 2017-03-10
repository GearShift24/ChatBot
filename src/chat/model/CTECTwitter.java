package chat.model;

import chat.controller.ChatController;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Twitter;
import twitter4j.Status;
import java.text.DecimalFormat;
import java.util.*;
import twitter4j.*;
import java.util.Scanner;

public class CTECTwitter
{
	private ChatController baseController;
	private Twitter chatbotTwitter;
	private List<Status> searchedTweets;
	private List<String> tweetedWords;

	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		searchedTweets = new ArrayList<Status>();
		tweetedWords = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		
	}
	public void sendTweet(String textToTweet)
	{
		try
		{
			chatbotTwitter.updateStatus(textToTweet);
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private String [] createIgnoredWordArray()
	{
		String [] boringWords;
		
		int wordCount = 0;
		Scanner wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		while(wordScanner.hasNextLine())
		{
		wordScanner.nextLine();
		wordCount++;
		}
		boringWords = new String [wordCount];		
		wordScanner.close();
		wordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = wordScanner.nextLine();
		}
		wordScanner.close();
		return boringWords;
		
	}
	

private void collectTweets(String username)
{
	searchedTweets.clear();
	tweetedWords.clear();
	
	Paging statusPage = new Paging(1,100);
	int page = 1;
	
	while(page <= 10)
	{
		statusPage.setPage(page);
		try{
		searchedTweets.addAll(chatbotTwitter.getUserTimeline(username, statusPage));
		}
		catch(TwitterException searchTweetError)
		{
		
			baseController.handleErrors(searchTweetError);
		}
		
		page++;
	}
}


public String getMostCommonWord(String user)
{
	String results = "";
	collectTweets(user);
	turnStatusesToWords();
	
	removeAllBoringWords();
	removeEmptyText();
	
	results +=  calculatePopularWordAndCount();	
	return results;
}


private void removeEmptyText()
{
	for(int index = tweetedWords.size() -1; index >= 0; index--)
	{
		if(tweetedWords.get(index).trim().equals(""))
		{
			tweetedWords.remove(index);
		}
	 }
   }


	private void removeAllBoringWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			String [] boringWords = createIgnoredWordArray();
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
				tweetedWords.remove(index);
				index--;
				boringIndex = boringWords.length;
				}
			}
		}
	}


	private void turnStatusesToWords()
	{
		for(Status currentStatus : searchedTweets)
		{
			String tweetText = currentStatus.getText();
			String [] tweetWords = tweetText.split(" ");
			for(int index = 0; index < tweetWords.length; index++)
			{
				tweetedWords.add(removePunctuation(tweetWords[index]));
			}
			
		}
	}
	
	private String calculatePopularWordAndCount()
	{
		String information = "";
		String mostPopular = "";
		int popularIndex = -1;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)) )
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
					{
					popularIndex = index;
					popularCount = currentPopularity;
					mostPopular = tweetedWords.get(index);
					}
		}
		
		information = " " + mostPopular + ", and it occured " + popularCount +  " times out of " + tweetedWords.size() + ", AKA " + (DecimalFormat.getPercentInstance().format(((double) popularCount)/tweetedWords.size()));
		return information;
	}
	
	
	
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,`?!:;(){}[]<>";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	
	
	
	
	
	
	
	public String memeInvestigation()	//I want this to compare 2 locations and see who memes more.
	{
		String results = "";
		int memers1 = 0;
		int memers2 = 0;
		
		for(int index = 0; index < baseController.getChatbot().getMemesList().size(); index++)
		{
			Query query = new Query(baseController.getChatbot().getMemesList().get(index));
			query.setCount(1000);
			query.setGeoCode(new GeoLocation(baseController.getlocation1x, location1y), 10, Query.KILOMETERS);
			query.setSince("2017-3");
			
			try
			{
				QueryResult result = chatbotTwitter.search(query);
				memers1 +=  result.getCount();
			}
			catch (TwitterException error)
			{
				error.printStackTrace();
			}
		}
		
		
		for(int index = 0; index < baseController.getChatbot().getMemesList().size(); index++)
		{
			Query query = new Query(baseController.getChatbot().getMemesList().get(index));
			query.setCount(1000);
			query.setGeoCode(new GeoLocation(location2x, location2y), 10, Query.KILOMETERS);
			query.setSince("2017-3");
			
			try
			{
				QueryResult result = chatbotTwitter.search(query);
				memers2 +=  result.getCount();
			}
			catch (TwitterException error)
			{
				error.printStackTrace();
			}
		}


		
		
//	
		
		
		results = "The first place CTEC had " + memers1 + " memers,  compared to the second place which had " + memers2 + " memers";
		
		return results;
	}
}

