package by.epam.training.javaweb.voitenkov.task4.controller;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.ParagraphParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SentenceParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SimplePartParser;

import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface.Parser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.MyFileReader;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception.FileNotFoundParserProjectException;
import by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer.TextModdifier;
import by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer.WordsModdifier;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.Validator;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */

public class MainController {

	public static void main(String[] args) {

		MyFileReader fileReader = new MyFileReader(
				"/home/sergey/c.txt");

		Validator validator = new Validator();

		try {

			SimplePartParser simplePartParser = new SimplePartParser(validator);
			SentenceParser sentenceParser = new SentenceParser(simplePartParser, validator);
			
			ParagraphParser textParser = new ParagraphParser(sentenceParser, validator);

			GeneralText text = textParser
					.recognize(fileReader.read());
			
			//ConteinerPart cont = (ConteinerPart) text;
			
			//WordsModdifier.removeVowels(cont);
			
			TextModdifier.getBackwardText((ConteinerPart)text);
			
			System.out.println(text);

		} catch (FileNotFoundParserProjectException e) {
			e.printStackTrace();
		}

	}
}
