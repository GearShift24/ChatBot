package chat.controller;

import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileController 
{
	
public static void saveFile(ChatController baseController, String fileName, String contents)
{
	try
	{
		File saveFile;
		if(fileName.length() > 5)
		{
			saveFile = new File(fileName + ".txt.");
		}
		else
		{
			saveFile = new File("bloop.txt");
		}
		FileWriter saveFileWriter = new FileWriter(saveFile);
		saveFileWriter.write(contents);
		saveFileWriter.close();
		JOptionPane.showMessageDialog(baseController.getBaseFrame(),"save succeded!");
	}
	catch(IOException error)
	{
		baseController.handleErrors(error);
	}
}
//
//public static String readFile(ChatController baseController, String fileName)
//{
//	
//}

}
