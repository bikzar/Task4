package by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer;

import java.util.HashMap;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov Mar 24, 2019
 */
public class TextModdifier {
	private static final Logger LOGER;

	static {
		LOGER = LogManager.getRootLogger();
	}

	public static void getBackwardText(ConteinerPart conteiner) {

		LOGER.debug("Methood getBackwardText():");

		HashMap<Integer, GeneralText> childs = conteiner.getChild();

		Set<Integer> tempKeys = childs.keySet();

		Integer[] tempKeysArray = new Integer[tempKeys.size()];

		tempKeys.toArray(tempKeysArray);

		swapElements(childs, tempKeysArray);

		for (int i = 0; i < tempKeysArray.length; i++) {
			if (childs.get(i) instanceof ConteinerPart) {
				getBackwardText((ConteinerPart) childs.get(i));
			}
		}
		
		LOGER.debug("Methood getBacwardText() end");
	}

	private static void swapElements(
			HashMap<Integer, GeneralText> tempConteiner,
			Integer[] tempKeysArray) {

		for (int i = 0, j = tempKeysArray.length
				- 1; i <= j; i++, j--) {

			GeneralText buffer = tempConteiner.get(i);

			tempConteiner.put(i, tempConteiner.get(j));

			tempConteiner.put(j, buffer);
			
			changeCodeBlock(tempConteiner.get(i));
			changeCodeBlock(tempConteiner.get(j));

		}
	}

	private static void changeCodeBlock(GeneralText element) {

		if (element instanceof SimplePart
				&& element.getPartType() == TextPartType.CODEBLOCK) {
			
			LOGER.debug("changeCodeBlock() value elemetn before: " + element);
			
			SimplePart sp = (SimplePart) element;
			sp.setValue("\n" + sp.getValue());
			
			LOGER.debug("changeCodeBlock() value element after: " + element);
		}
	}
}
