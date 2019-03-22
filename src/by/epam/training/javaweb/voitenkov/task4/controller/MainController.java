package by.epam.training.javaweb.voitenkov.task4.controller;

import by.epam.training.javaweb.voitenkov.task4.model.appinterface.Text;

import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.ParagraphParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SentenceParser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.SimplePartParser;

import by.epam.training.javaweb.voitenkov.task4.model.logic.parser.parserinterface.Parser;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.MyFileReader;
import by.epam.training.javaweb.voitenkov.task4.model.logic.reader.exception.FileNotFoundParserProjectException;
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

			if (validator.isValid(fileReader.read())) {

				Parser textParser = new ParagraphParser(
						new SentenceParser(new SimplePartParser()));

				Text text = textParser.recognize(fileReader.read());

				System.out.println(text);
			}

		} catch (FileNotFoundParserProjectException e) {
			e.printStackTrace();
		}

	}
}
