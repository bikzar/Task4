package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import by.epam.training.javaweb.voitenkov.task4.model.appinterface.Text;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface.Parser;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */
public abstract class TextParser implements Parser {
	
	protected TextParser nextParser;
	
	public TextParser() {
	}
	
	public TextParser(TextParser nextParser) {
		if(nextParser != null) {
			this.nextParser = nextParser;
		}
	}
	
	public abstract Text recognize(String text);

}
