/**
 * 
 */
package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov Mar 20, 2019 Class wich parses sentence to words
 */

public class SimplePartParser extends TextParser {

	public SimplePartParser() {
	}

	@Override
	public ConteinerPart recognize(String sentenceText) {

		String tempString = sentenceText.replaceAll("\\.", "*.*")
				.replaceAll("\\,", "*,*").replaceAll("\\!", "*!*")
				.replaceAll("\\:", "*:*").replaceAll("\\?", "*?*")
				.replaceAll("\\,", "*,*").replaceAll("\\–", "*–*")
				.replaceAll("\\s", "* *");

		String[] wordArray = tempString.split("\\*");

		ConteinerPart conteiner = new ConteinerPart(
				TextPartType.SENTENCE);

		for (String str : wordArray) {
			conteiner.add(new SimplePart(str, TextPartType.WORD));
		}

		return conteiner;
	}
}
