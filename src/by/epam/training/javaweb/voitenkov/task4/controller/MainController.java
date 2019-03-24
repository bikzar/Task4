package by.epam.training.javaweb.voitenkov.task4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.GeneralText;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.ParagraphParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SentenceParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SimplePartParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface.Parser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.MyFileReader;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception.FileNotFoundParserProjectException;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.interfacereader.Readeble;
import by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer.TextModdifier;
import by.epam.training.javaweb.voitenkov.task4.model.logic.textmoddifer.WordsModdifier;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.Validator;
import by.epam.training.javaweb.voitenkov.task4.view.printer.FilePrinter;
import by.epam.training.javaweb.voitenkov.task4.view.printer.printerinterface.Printable;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */

public class MainController {
	
	private static final Logger LOGGER;
	
	static {
		LOGGER = LogManager.getRootLogger();
	}	
	
	public static void main(String[] args) {

		Readeble fileReader = new MyFileReader("/home/sergey/c.txt");

		Validator validator = new Validator();

		try {
			Parser textParser = new ParagraphParser(
					new SentenceParser(
							new SimplePartParser(validator),
							validator),
					validator);
			
			LOGGER.info("Start recognize");
			
			GeneralText text = textParser
					.recognize(fileReader.read());
			
			LOGGER.info("Finish recogn start remov Vowels");

			ConteinerPart cont = (ConteinerPart) text;

			WordsModdifier.removeVowels(cont);
			
			LOGGER.info("Finish remov Vowels start backward");

			TextModdifier.getBackwardText((ConteinerPart) text);

			Printable fp = new FilePrinter("/home/sergey/c1.txt");

			LOGGER.info("Print to file");
			
			fp.print(text);

		} catch (FileNotFoundParserProjectException e) {
			e.printStackTrace();
		}

	}
}
