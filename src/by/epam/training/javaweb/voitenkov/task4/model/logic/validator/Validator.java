package by.epam.training.javaweb.voitenkov.task4.model.logic.validator;

import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov
 * Mar 20, 2019
 */
public class Validator implements Confirming {

	@Override
	public boolean isValid(String text) {
		
		if(text != null && !text.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
