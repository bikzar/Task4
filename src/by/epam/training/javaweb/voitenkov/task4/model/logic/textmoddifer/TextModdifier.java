package by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer;


import java.util.HashMap;
import java.util.Set;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;

/**
 * @author Sergey Voitenkov
 * Mar 24, 2019
 */
public class TextModdifier {

	public static void getBackwardText(ConteinerPart conteiner) {

		HashMap<Integer, GeneralText> childs = conteiner.getChild();

		Set<Integer> tempKeys = childs.keySet();

		Integer[] tempKeysArray = new Integer[tempKeys.size()];

		tempKeys.toArray(tempKeysArray);
		
		swapElements(childs, tempKeysArray);

		for(int i = 0; i < tempKeysArray.length; i++) {
			if(childs.get(i) instanceof ConteinerPart) {
				getBackwardText((ConteinerPart)childs.get(i));
			}
		}
	}

	private static void swapElements(HashMap<Integer, GeneralText> tempConteiner, Integer[] tempKeysArray) {
		
		for (int i = 0, j = tempKeysArray.length-1; i <= j; i++, j--) {
			
			GeneralText buffer = tempConteiner.get(i);
			
			tempConteiner.put(i, tempConteiner.get(j));
			
			tempConteiner.put(j, buffer);
		}
	}
}
