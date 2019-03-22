/**
 * 
 */
package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov
 * Mar 20, 2019
 */

public class SentenceParser extends TextParser {
		
	public SentenceParser(TextParser nextParser) {
		super(nextParser);
	}

	@Override
	public ConteinerPart recognize(String paragraphText) {
		
		String tempString = paragraphText.replaceAll("\\.\\s", ".*+*")
				.replaceAll("\\!\\s", "!*+*").replaceAll("\\?\\s", "?*+*");
		
		String[] sentences = tempString.split("\\*\\+\\*");
		
		ConteinerPart conteiner = new ConteinerPart(TextPartType.PARAGRAPH);
		
		for(String sentence : sentences) {
			if(nextParser != null) {
				conteiner.add(nextParser.recognize(sentence));
			}
		}
		
		return conteiner;	
	}

}
