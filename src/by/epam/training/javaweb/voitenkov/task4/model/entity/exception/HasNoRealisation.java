package by.epam.training.javaweb.voitenkov.task4.model.entity.exception;

import by.epam.training.javaweb.voitenkov.task4.exception.LogicParserProjectException;

public class HasNoRealisation extends LogicParserProjectException {

	public HasNoRealisation() {
	}

	public HasNoRealisation(String message) {
		super(message);
	}

}
