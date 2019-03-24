/**
 * 
 */
package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */

public class SentenceParser extends TextParser {

	public SentenceParser(TextParser nextParser,Confirming validator) {
		super(nextParser, validator, "\\*\\+\\*",
				TextPartType.PARAGRAPH);
	}

	@Override
	public String refactText(String text) {

		return text.replaceAll("\\.\\s", ".*+*")
				.replaceAll("\\!\\s", "!*+*")
				.replaceAll("\\?\\s", "?*+*");
	}

	@Override
	public void fillConteiner(ConteinerPart conteiner, String text) {

		if (super.getNextTextParser() != null) {

			TextParser nextTextParser = super.getNextTextParser();

			ConteinerPart childs = nextTextParser.recognize(text);

			conteiner.add(childs);
		}
	}
}
