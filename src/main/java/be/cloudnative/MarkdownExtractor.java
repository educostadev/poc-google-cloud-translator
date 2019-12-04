package be.cloudnative;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MarkdownExtractor {

	private final String content;

	MarkdownExtractor(final String content) {
		this.content = content;
	}

	public static List<String> joinVocabulary(final List<String> vocabularyEng, final List<String> vocabularyPt) {
		List<String> vocabulary = new ArrayList<>();

		for (int i = 0; i < vocabularyEng.size(); i++) {
			String entryEng = vocabularyEng.get(i);
			String entryPt = vocabularyPt.get(i);

			entryEng = entryEng.substring(0, entryEng.length() - 2);
			entryPt = entryPt.substring(2);

			String newEntry = entryEng + " " + entryPt;
			vocabulary.add(newEntry);

		}
		return vocabulary;
	}

	String extractGlossarySession() {

		int glossaryStart = content.indexOf("##GLOSSARY");
		int glossaryEnd = content.indexOf("##COMPREHENSION");

		return content.substring(glossaryStart, glossaryEnd);
	}

	List<String> getVocabulary(final String glossary) {
		List<String> vocabulary = new ArrayList<>();
		final String regexStr = "[*]{2}.*[*]{2}";
		Pattern pattern = Pattern.compile(regexStr);
		Matcher matcher = pattern.matcher(glossary);
		while (matcher.find()) {
			vocabulary.add(matcher.group(0));
		}
		return vocabulary;
	}

	String removeVocabulary(final List<String> vocabulary, String glossary) {
		for (int i = 0; i < vocabulary.size(); i++) {
			String entry = vocabulary.get(i);
			glossary = glossary.replace(entry, "[" + i + "]");
		}
		return glossary;
	}

	public String addVocabulary(final List<String> vocabulary, String glossaryWithoutVocabulary) {
		for (int i = 0; i < vocabulary.size(); i++) {
			String entry = vocabulary.get(i);
			glossaryWithoutVocabulary = glossaryWithoutVocabulary.replace("[" + i + "]", entry);
		}
		return glossaryWithoutVocabulary;
	}
}
