package by.epam.training.javaweb.voitenkov.task4.model.logic.reader.interfacereader;

import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception.FileNotFoundParserProjectException;

/**
 * @author Sergey Voitenkov
 * Mar 19, 2019
 * 
 */

public interface Readeble {
	String read() throws FileNotFoundParserProjectException;
}
