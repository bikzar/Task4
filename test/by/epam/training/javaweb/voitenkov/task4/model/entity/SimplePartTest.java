package by.epam.training.javaweb.voitenkov.task4.model.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov
 * Mar 19, 2019
 */

public class SimplePartTest {

	@Test
	public void checkEquals() {
		SimplePart part = new SimplePart("123456", TextPartType.WORD);
		SimplePart newPart = new SimplePart("123456", TextPartType.WORD);
		
		assertEquals(true, part.equals(newPart));
	}

}
