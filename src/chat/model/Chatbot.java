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
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
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
		memesList.add("pewdiepie");
		memesList.add("lank");
		memesList.add("mario");
		memesList.add("link");
		memesList.add("excuse me princess");
		memesList.add("mah boy");
	}

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
	 *            The supplied String to be 
. * @return Whether it
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
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
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
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		if(currentInput.equals(quit))
		{
			hasQuit = true;
			
		}
		
		return hasQuit;
		
	}
	
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
