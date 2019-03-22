/**
 * 
 */
package by.epam.training.javaweb.voitenkov.task4.model.logic.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception.FileNotFoundParserProjectException;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.interfacereader.Readeble;

/**
 * @author Sergey Voitenkov Mar 19, 2019
 */

public class MyFileReader implements Readeble {

	private String filePath = "Empty Path";

	public MyFileReader(String filePath) {
		if (filePath != null) {
			this.filePath = filePath;
		}
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String read() throws FileNotFoundParserProjectException{

		StringBuilder textFromFile = new StringBuilder();;
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader(filePath))) {

			String tempString;
			
			while ((tempString = bufferedReader.readLine()) !=null) {
				textFromFile.append(tempString).append("\n");
			}
			
			
		} catch (FileNotFoundException e) {
			throw new FileNotFoundParserProjectException(
					"Incorrect file path", e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return textFromFile.toString();
	}

}
