package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * @author Cody
 * Henrichsen * @version 1.0 10/14/15
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyboardMashList;
	private String userName;
	private String content;
	private String quit;

	/**
	 * * Creates an instance of the Chatbot with the supplied username.  
	 * @userName The username for the chatbot.
	 * 
	 */
	/**
	 */
	public Chatbot(String userName)
	{
		memesList = new ArrayList<String>();
		buildMemesList();
		politicalTopicList = new ArrayList<String>();
		buildPoliticalTopicsList();
		keyboardMashList = new ArrayList<String>();
		buildKeyboardMashList();

		
		content = new String("Anything");
		this.content ="games";
		
		this.userName = userName;
		this.quit = "quit";
	}
/**
 * creates a list of memes that is later used to check if the user inputed anything in the list
 */
	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("joey salads");
		memesList.add("chuck norris");
		memesList.add("elf");
		memesList.add("dwight");
		memesList.add("the cake is a lie");
		memesList.add("shrek");
		memesList.add("hugh mungas");
		memesList.add("lank");
		memesList.add("mario");
		memesList.add("link");
		memesList.add("excuse me princess");
		memesList.add("mah boy");
	}
/**
 * creates a list of political topics that is later used to check if the user inputed anything in the list
 */
	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("liberal");
		politicalTopicList.add("conservative");
		politicalTopicList.add("debate");
		politicalTopicList.add("superpreditor");
		politicalTopicList.add("bernie");
		politicalTopicList.add("hacking");
		politicalTopicList.add("ballot");
		politicalTopicList.add("russia");

	}
/**
 * creates a list of keyboardMashing that is later used to check if the user inputed anything in the list
 */
	private void buildKeyboardMashList()
	{
		keyboardMashList.add("sdf");
		keyboardMashList.add("dfg");
		keyboardMashList.add("cvb");
		keyboardMashList.add(",./");
	}


	
	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLegnth = false;
		
		if(currentInput != null && !currentInput.equals(""))
		{
			hasLegnth = true;
		}
			return hasLegnth;
		
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
	
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;
		
		for ( int index =0; index <politicalTopicList.size(); index++)
		
		if(currentInput.equals(politicalTopicList.get(index)))
		{
			hasPolitical = true;
		}
				
		return hasPolitical;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		
		for ( int index =0; index <memesList.size(); index++)
		
		if(currentInput.equalsIgnoreCase(memesList.get(index)))
		{
			isMeme = true;
		}
		
		
		return isMeme;
		
	}

	/**
	 * checks to see if the user input is key mashing. 
	 * returns true if it finds a matchand false if it doesnt
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a keyboard mash
	 */
	public boolean keyboardMashChecker(String currentInput)
		{	boolean isMash = false;
				for( int index =0; index <keyboardMashList.size(); index++)
				
					if(currentInput.contains(keyboardMashList.get(index)))
					{
						isMash = true;
					}
				return isMash;
		}
	/**
	 * checks to see if user input is the quit command
	 * returns true if it finds a matchand false if it doesnt
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is the command to quit
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		if(currentInput.equals(quit))
		{
			hasQuit = true;
			
		}
		
		return hasQuit;
		
	}
	/**
	 * checks to see if user input is html
	 * returns true if it finds a matchand false if it doesnt
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a html input
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		boolean isHTML = false;
		
		if(currentInput.indexOf("<") == 0 && currentInput.indexOf(">") == 2 || currentInput.indexOf(">") == 21)   																				
				{
			if(currentInput.indexOf("B") == 1 || currentInput.indexOf("I") == 1 || currentInput.indexOf("A") == 1 || currentInput.indexOf("A HREF=\"sdfs.html\"") == 1)
			{
				if(currentInput.lastIndexOf(">") == 0  && currentInput.lastIndexOf("<") == 3 && currentInput.lastIndexOf("/") == 2)
				{
					if(currentInput.lastIndexOf("B") == 1 || currentInput.lastIndexOf("i") == 1 || currentInput.lastIndexOf("a") == 1 )
					{
						isHTML = true;
					}
				}
			}
				}
		
		//for p with no end tag
		
		if(currentInput.indexOf("<") == 0 && currentInput.indexOf(">") == 2)
				{
			if(currentInput.indexOf("P") == 1)	
			{
				isHTML = true;
			}
				}
		
		
//		if(currentInput.indexOf("<") == 0 && currentInput.indexOf(">") == 2 && currentInput.indexOf("b") == 1)
//		{
//			if(currentInput.indexOf(">", 9) == 0 && currentInput.indexOf("B",8) == 0 && currentInput.indexOf("/",7) == 0 && currentInput.indexOf("<",6) == 0)	
//			{
//		isHTML = true;
//			}
//		}
				
		return isHTML;
		
	}
	
	
	/**
	 * checks to see if the user input is about twitter
	 * returns true if it finds a matchand false if it doesnt
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a twitter handle
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean hasTwitterResponse = false;
		
		if(currentInput.substring(0).equalsIgnoreCase("#dw35 f") || currentInput.substring(0).equalsIgnoreCase("@d4d sretsf "))
		{
			hasTwitterResponse = true;
		}
		
		return hasTwitterResponse;
	}

	
	/**
		 * * Returns the username for this Chatbot instance. * 
		 * returns true if it finds a matchand false if it doesnt
		 * 
		 * @return The username area for this Chatbot instance.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	/**
	 * getter method for the keyboardMaster object
	 * @return refrence to keyboardmashlist
	 */
	public ArrayList<String> getKeyboardMashList()
	{
		return keyboardMashList;
	}
	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	
}
