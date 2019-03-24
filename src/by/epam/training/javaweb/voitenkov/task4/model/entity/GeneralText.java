/**
 * 
 */
package by.epam.training.javaweb.voitenkov.task4.model.entity;

import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov
 * Mar 21, 2019
 */

public abstract class GeneralText{
	
	private TextPartType partType;

	public GeneralText() {
		partType = TextPartType.EMPTY_TYPE;
	}
	
	public GeneralText(TextPartType textPartType) {
		if(textPartType != null) {
			this.partType = textPartType;
		}
	}
			
	public TextPartType getPartType() {
		return partType;
	}

	public void setPartType(TextPartType partType) {
		if(partType != null) {
			this.partType = partType;
		}
	}
	
	public abstract GeneralText getClone();
	public abstract String printOriginaleText();
}
