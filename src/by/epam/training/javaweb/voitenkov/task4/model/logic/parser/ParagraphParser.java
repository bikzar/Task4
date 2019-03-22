package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import java.util.regex.Pattern;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */

public class ParagraphParser extends TextParser {

	private Pattern[] codeBlockPattern = new Pattern[] {
			Pattern.compile("^\\s*\\w*.\\w*.[=].\\w+",
					Pattern.MULTILINE),
			Pattern.compile("\\s*import.*\\;$", Pattern.MULTILINE),
			Pattern.compile(
					"^\\s*(public|protected|private|while|for|if|switch).*\\(.*\\)[^\\.]\\{?",
					Pattern.MULTILINE),
			Pattern.compile("^\\s*return.*\\;", Pattern.MULTILINE),
			Pattern.compile("^\\s*\\}", Pattern.MULTILINE),
			Pattern.compile("^\\s*\\@[A-Z]", Pattern.MULTILINE),
			Pattern.compile("^\\s*.*\\;$", Pattern.MULTILINE),
			Pattern.compile("^\\s*\\b\\w*\\(\\)", Pattern.MULTILINE),
			Pattern.compile(
					"^\\s*[\\/{0,2}, \\/\\*, \\*, \\/\\*{2}, \\*\\/].*",
					Pattern.MULTILINE) };

	public ParagraphParser(TextParser nextParser) {
		super(nextParser);
	}

	@Override
	public ConteinerPart recognize(String text) {

		ConteinerPart textConteiner = new ConteinerPart(
				TextPartType.TEXT);

		text = text.replaceAll("\n\n", "**")
				.replaceAll("\n\n\n", "***").replaceAll("\n", "\n\n")
				.replaceAll("\\*\\*", "\n\n\n")
				.replaceAll("\\*\\*\\*", "\n\n\n\n");

		String[] paragraph = text.split("\n");

		StringBuilder codeBlock = new StringBuilder();
		boolean inCodeBlock = false;

		for (String tempString : paragraph) {

			if (inCodeBlock && tempString.equals("")) {
				codeBlock.append("\n");
			}

			if (!inCodeBlock && tempString.equals("")) {
				textConteiner.add(
						new SimplePart("\n", TextPartType.PARAGRAPH));
			}

			if (isCodeBlock(tempString)) {

				if (!inCodeBlock) {
					inCodeBlock = true;
				}

				codeBlock.append(tempString);

			} else {
				if (inCodeBlock && !tempString.equals("")) {
					textConteiner
							.add(new SimplePart(codeBlock.toString(),
									TextPartType.CODEBLOCK));
					codeBlock.delete(0, codeBlock.length());
					inCodeBlock = false;
				}
				if (!tempString.equals("")) {
					textConteiner
							.add(nextParser.recognize(tempString));
				}
			}

		}

		return textConteiner;
	}

	private boolean isCodeBlock(String str) {

		for (Pattern pattern : codeBlockPattern) {
			if (pattern.matcher(str).find()) {
				return true;
			}
		}
		return false;
	}
}
