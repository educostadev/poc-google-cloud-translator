package be.cloudnative;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

class Translator {

	static final TranslateOption EN = TranslateOption.sourceLanguage("en");
	static final TranslateOption PT = TranslateOption.sourceLanguage("pt");

	String translate(String text, TranslateOption from, TranslateOption to) {
		Translate translate = TranslateOptions.getDefaultInstance().getService();
		Translation translation =
				translate.translate(
						text,
						TranslateOption.sourceLanguage("en"),
						TranslateOption.targetLanguage("pt"));

		return translation.getTranslatedText();
	}

}
