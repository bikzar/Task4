package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;

import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface.Parser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */
public abstract class TextParser implements Parser {

	private String splitPattern;
	private TextPartType textPartType;
	private TextParser nextParser;
	private Confirming validator;

	public TextParser(TextParser nextParser, Confirming validator,
			String splitPattern, TextPartType textPartType) {

		this.nextParser = nextParser;

		if (validator != null && splitPattern != null && textPartType != null) {
			this.validator = validator;
			this.splitPattern = splitPattern;
			this.textPartType = textPartType;
		}
	}

	public TextParser getNextTextParser() {
		return nextParser;
	}

	public ConteinerPart recognize(String text) {

		if (validator.isValid(text)) {

			String tempString = refactText(text);

			String[] textPartArray = tempString.split(splitPattern);

			ConteinerPart conteiner = new ConteinerPart(textPartType);

			for (String textPart : textPartArray) {
				fillConteiner(conteiner, textPart);
			}

			return conteiner;
		}

		return new ConteinerPart(TextPartType.EMPTY_TYPE);
	}

	public abstract String refactText(String text);

	public abstract void fillConteiner(ConteinerPart conteiner,
			String text);
}
