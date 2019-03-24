package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov Mar 20, 2019 Class witch parses sentence to words
 */

public class SimplePartParser extends TextParser {

	public SimplePartParser(Confirming validator) {
		super(null, validator, "\\*", TextPartType.SENTENCE);
	}

	@Override
	public String refactText(String text) {

		return text.replaceAll("\\.", "*.*").replaceAll("\\,", "*,*")
				.replaceAll("\\!", "*!*").replaceAll("\\:", "*:*")
				.replaceAll("\\?", "*?*").replaceAll("\\,", "*,*")
				.replaceAll("\\–+", "*–*").replaceAll("\\s", "* *")
				.replaceAll("\\-", "*-*");
	}

	@Override
	public void fillConteiner(ConteinerPart conteiner, String text) {

		if (text.matches("\\w+")) {
			conteiner.add(new SimplePart(text, TextPartType.WORD));
		} else {
			conteiner.add(new SimplePart(text, TextPartType.SIMBOL));
		}
	}
}
