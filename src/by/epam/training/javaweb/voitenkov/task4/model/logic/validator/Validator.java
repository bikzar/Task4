package by.epam.training.javaweb.voitenkov.task4.model.logic.validator;

/**
 * @author Sergey Voitenkov
 * Mar 20, 2019
 */
public class Validator {

	public Validator() {
	}

	public boolean isValid(String text) {
		
		if(text != null && !text.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
