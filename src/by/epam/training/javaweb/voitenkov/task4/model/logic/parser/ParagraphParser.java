package by.epam.training.javaweb.voitenkov.task4.model.logic.parser;

import java.util.regex.Pattern;

import by.epam.training.javaweb.voitenkov.task4.model.entity.ConteinerPart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.SimplePart;
import by.epam.training.javaweb.voitenkov.task4.model.entity.entityenum.TextPartType;
import by.epam.training.javaweb.voitenkov.task4.model.logic.validator.validateinterface.Confirming;

/**
 * @author Sergey Voitenkov Mar 20, 2019
 */
public class ParagraphParser extends TextParser {

	private static Pattern[] codeBlockPattern = new Pattern[] {
			Pattern.compile("^\\s*.*\\s?=\\s?.*;", Pattern.MULTILINE),
			Pattern.compile("\\s*import.*\\;$", Pattern.MULTILINE),
			Pattern.compile("^\\s*(public|protected|private|while|for|if|switch|try).*\\(.*\\)*[^\\.]\\{?", Pattern.MULTILINE),
			Pattern.compile("^\\s*return.*\\;", Pattern.MULTILINE),
			Pattern.compile("^\\s*.*\\}", Pattern.MULTILINE),
			Pattern.compile("^\\s*\\@[A-Z]", Pattern.MULTILINE),
			Pattern.compile("^\\s*.*\\;$", Pattern.MULTILINE),
			Pattern.compile("^\\s*\\b\\w*\\(\\)", Pattern.MULTILINE),
			Pattern.compile("^\\s*(\\*\\/|\\/\\/|\\/\\*{1,2}|\\*)", Pattern.MULTILINE),
			Pattern.compile("^\\s*.*\\{", Pattern.MULTILINE),
			Pattern.compile("^\\s*.*\\+?.*\\+$", Pattern.MULTILINE),};

	
	private boolean inCodeBlock;

	private StringBuilder codeBlock ;
	
	public ParagraphParser(TextParser nextParser,
			Confirming validator) {
		
		super(nextParser, validator, "\n", TextPartType.TEXT);
		
		inCodeBlock = false;
		codeBlock = new StringBuilder();
		
	}

	@Override
	public String refactText(String text) {

		return text.replaceAll("\n\n", "**")
				.replaceAll("\n\n\n", "***").replaceAll("\n", "\n\n")
				.replaceAll("\\*\\*", "\n\n\n")
				.replaceAll("\\*\\*\\*", "\n\n\n\n");
	}

	@Override
	public void fillConteiner(ConteinerPart conteiner, String text) {
			
		if (inCodeBlock && text.equals("")) {
			codeBlock.append("\n");
		}

		if (!inCodeBlock && text.equals("")) {
			conteiner.add(new SimplePart("\n",
					TextPartType.EMPTY_PARAGRAPH));
		}

		if (isCodeBlock(text)) {

			if (!inCodeBlock) {
				inCodeBlock = true;
			}
			
			codeBlock.append(text);

		} else {
			
			if (inCodeBlock && !text.equals("")) {
				
				conteiner.add(new SimplePart(codeBlock.toString(),
						TextPartType.CODEBLOCK));
				codeBlock.delete(0, codeBlock.length());
				inCodeBlock = false;
			}
			
			if (!text.equals("")) {
				
				if(super.getNextTextParser() != null) {
					conteiner.add(super.getNextTextParser().recognize(text));
				}
			}
		}
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


/*@Override
public void fillConteiner(ConteinerPart conteiner, String text) {
		
	if (inCodeBlock && text.equals("")) {
		codeBlock.append("\n");
	}

	if (!inCodeBlock && text.equals("")) {
		conteiner.add(new SimplePart("\n",
				TextPartType.EMPTY_PARAGRAPH));
	}

	if (isCodeBlock(text)) {

		if (!inCodeBlock) {
			inCodeBlock = true;
		}
		
		codeBlock.append(text);

	} else {
		
		if (inCodeBlock && !text.equals("")) {
			
			conteiner.add(new SimplePart(codeBlock.toString(),
					TextPartType.CODEBLOCK));
			codeBlock.delete(0, codeBlock.length());
			inCodeBlock = false;
		}
		
		if (!text.equals("")) {
			
			if(super.getNextTextParser() != null) {
				conteiner.add(super.getNextTextParser().recognize(text));
			}
		}
	}
}*/
