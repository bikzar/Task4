package by.epam.training.javaweb.voitenkov.task4.model.entity;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov March 19, 2019 Leaf class
 */
public class SimplePart extends GeneralText {
				
	private final static String DEFAULT_VALUE = "Empty Value";
	private String value;
	
	public SimplePart() {
		value = DEFAULT_VALUE;
	}

	public SimplePart(String value, TextPartType textPartType) {
		super(textPartType);
		if (value != null) {
			this.value = value;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((value == null) ? 0 : value.hashCode());
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
		SimplePart other = (SimplePart) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public GeneralText getClone() {
		return new SimplePart(value, super.getPartType());
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		if(value != null) {
			this.value = value;
		}
	}

	public String printOriginaleText() {
		return value;
	}
}
