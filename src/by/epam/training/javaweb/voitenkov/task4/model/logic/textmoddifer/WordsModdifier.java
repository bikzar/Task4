package by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov Mar 23, 2019
 */

public class WordsModdifier {

	private static final Logger LOGER;

	static {
		LOGER = LogManager.getRootLogger();
	}

	public static void removeVowels(ConteinerPart conteiner) {

		for (GeneralText element : conteiner.getChild().values()) {

			if (element instanceof ConteinerPart) {

				removeVowels((ConteinerPart) element);

			} else {

				SimplePart tempElement = (SimplePart) element;

				String removeVowelsPattern = "[aeiouAEIOU]";

				if (tempElement.getPartType() == TextPartType.WORD) {
					
					LOGER.debug("removVowels() word befor remove: " + tempElement);
					
					tempElement.setValue(tempElement.getValue()
							.replaceAll(removeVowelsPattern, ""));
					
					LOGER.debug("removVowels() word after remove: " + tempElement);
				}
			}
		}
	}
}
