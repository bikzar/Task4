package by.epam.training.javaweb.voitenkov.task4.model.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import by.epam.training.javaweb.voitenkov.task4.model.appinterface.Text;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov March 19, 2019 Composite class
 */

public class ConteinerPart extends GeneralText {

	private Map<Integer, Text> childs;
	private int key;

	{
		childs = new HashMap<>();
	}

	public ConteinerPart() {
	}
	
	public ConteinerPart(TextPartType textPartType){
		super(textPartType);
	}

	public ConteinerPart(Map<Integer, Text> conteinerPart) {
		if (conteinerPart != null && checkMap()) {
			childs = conteinerPart;
		}
	}

	@Override
	public void add(Text element) {
		childs.put(key, element);
		key++;
	}

	@Override
	public void removeLast() {
		childs.remove(key - 1);
	}

	@Override
	public Text[] getChild() {

		return null;
	}

	private boolean checkMap() {

		for (Integer key : childs.keySet()) {
			if (childs.get(key) instanceof ConteinerPart) {
				ConteinerPart conteinerPart = (ConteinerPart) childs
						.get(key);
				if (!conteinerPart.checkMap()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((childs == null) ? 0 : childs.hashCode());
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConteinerPart other = (ConteinerPart) obj;
		if (childs == null) {
			if (other.childs != null) {
				return false;
			}
		} else if (!childs.equals(other.childs)) {
			return false;
		}
		if (key != other.key) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		
		StringBuilder resualt = new StringBuilder();

		Set<Integer> keySet = childs.keySet();
		
		for(Integer index : keySet ) {
				resualt.append(childs.get(index).toString());
		}
		
		return resualt.toString();
	}
}
