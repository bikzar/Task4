package by.epam.training.javaweb.voitenkov.task4.model.logic.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */
public class Validator implements Confirming {

	private static final Logger LOGER;

	static {
		LOGER = LogManager.getRootLogger();
	}

	@Override
	public boolean isValid(String text) {

		LOGER.debug(
				"Class Validator methood isVAlid() parametr isEmpty: "
						+ text.isEmpty() + " isNull: "
						+ text == null);

		if (text != null && !text.isEmpty()) {
			return true;
		}

		return false;
	}
}
