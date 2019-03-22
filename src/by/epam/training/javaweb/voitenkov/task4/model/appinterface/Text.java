package by.epam.training.javaweb.voitenkov.task4.model.appinterface;

import by.epam.training.javaweb.voitenkov.task4.exception.LogicParserProjectException;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov
 * March 19, 2019
 * Interface for realisation Composite pattern
 */

public interface Text {
	void add(Text element) throws LogicParserProjectException;
	void removeLast()throws LogicParserProjectException;
	public void setPartType(TextPartType partType);
	public TextPartType getPartType();	
	Text[] getChild() throws LogicParserProjectException;
	
}
