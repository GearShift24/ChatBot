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
	private ArrayList<String> politicalTopicsList;
	private String userName;
	private String content;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		memesList = new ArrayList<String>();
		buildMemesList();
		politicalTopicsList = new ArrayList<String>();
		buildPoliticalTopicsList();
		
		content = new String("Anything");
		this.content ="Computer Games";
		
		this.userName = userName;
		
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
		memesList.add("trump");
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
		politicalTopicsList.add("Democrat");
		politicalTopicsList.add("Republican");
		politicalTopicsList.add("11/8/16");
		politicalTopicsList.add("conservative");
		politicalTopicsList.add("Clinton");
		politicalTopicsList.add("Trump");
		politicalTopicsList.add("Kaine");
		politicalTopicsList.add("Pence");
		politicalTopicsList.add("Stein");
		politicalTopicsList.add("Johnson");
		politicalTopicsList.add("election");
		politicalTopicsList.add("liberal");
		politicalTopicsList.add("conservative");
		politicalTopicsList.add("debate");
		politicalTopicsList.add("superpreditor");
		politicalTopicsList.add("bernie");
		politicalTopicsList.add("hacking");
		politicalTopicsList.add("ballot");
		politicalTopicsList.add("russia");

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
		
		if(currentInput.contains(content))
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
		
	
			for(String politicalTopicChecker : politicalTopicsList)
			{
				String cancer = politicalTopicsList.get(0);
				if(currentInput.equalsIgnoreCase("Democrat"))
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
		
		
		
		return false;
		
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return null;
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
