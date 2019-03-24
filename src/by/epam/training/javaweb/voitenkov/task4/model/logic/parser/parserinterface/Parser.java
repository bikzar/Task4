package by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface;

import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;

/**
 * @author Sergey Voitenkov
 * Mar 20, 2019
 */
public interface Parser {
	GeneralText recognize(String text);
}
