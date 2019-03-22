package by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception;

import by.epam.training.javaweb.voitenkov.task4.exception.TecnicalParserProjectException;

/**
 * @author Sergey Voitenkov
 * Mar 20, 2019
 */
@SuppressWarnings("serial")
public class FileNotFoundParserProjectException
		extends TecnicalParserProjectException {

	public FileNotFoundParserProjectException() {
		super();
	}

	public FileNotFoundParserProjectException(String message,
			Throwable cause) {
		super(message, cause);
	}

	public FileNotFoundParserProjectException(String message) {
		super(message);
	}

	public FileNotFoundParserProjectException(Throwable cause) {
		super(cause);
	}
}
