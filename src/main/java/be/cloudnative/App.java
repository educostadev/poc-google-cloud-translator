package be.cloudnative;

import static be.cloudnative.MarkdownExtractor.joinVocabulary;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;

import com.google.cloud.translate.Translate.TranslateOption;

public class App {

	public static void main(String[] args) throws Exception {
		JFileChooser chooser = new JFileChooser(".");
		chooser.showDialog(null, "OK");
		File file = chooser.getSelectedFile();

		MarkdownExtractor extractor = new MarkdownExtractor(Filer.read(file));

		String glossary = extractor.extractGlossarySession();
		List<String> vocabularyEng = extractor.getVocabulary(glossary);

		Translator translator = new TranslatorMock();
		String glossaryTranslated = translator.translate(glossary, Translator.EN, Translator.PT);
		List<String> vocabularyPt = extractor.getVocabulary(glossaryTranslated);

		String glossayTranslatedWithoutVocabulary = extractor.removeVocabulary(vocabularyPt, glossaryTranslated);

		glossaryTranslated = extractor
				.addVocabulary(joinVocabulary(vocabularyEng, vocabularyPt), glossayTranslatedWithoutVocabulary);

		String path = file
				.getParentFile().getAbsolutePath() +
				File.separator +
				file.getName().replace(".md", "_Glossary_pt.md");
		File output = new File(path);

		Filer.write(output, glossaryTranslated);

	}

	static class TranslatorMock extends Translator {

		@Override
		String translate(String text, TranslateOption from, TranslateOption to) {
			return
					"##GLOSSÁRIO\n"
							+ "\n"
							+ "**Tradução -** a tampa ou o topo de uma panela ou outro recipiente\n"
							+ "\n"
							+ "* Eles têm uma gaveta cheia de recipientes de armazenamento de plástico, mas é quase impossível\n"
							+ "para encontrar uma tampa correspondente.\n"
							+ "\n"
							+ "**Tradução -** um líquido quente que é comido com uma colher, geralmente feito pela fervura de carne e\n"
							+ "legumes em água e ervas, geralmente com pequenos pedaços de carne, legumes,\n"
							+ "e / ou macarrão flutuando nele\n"
							+ "\n"
							+ "\n"
							+ "* Por favor, salve os restos de frango e ossos, e podemos usá-lo para fazer uma sopa\n"
							+ "amanhã à noite.\n"
							+ "\n"
							+ "**Tradução -** espessa, preenchida, nutritiva e satisfatória\n"
							+ "\n"
							+ "\n"
							+ "* Claire fez sanduíches saudáveis \u200B\u200Bcom muita carne assada e peru.\n"
							+ "\n"
							+ "**Tradução -** uma sopa muito grossa feita ao cozinhar carne, legumes e principalmente\n"
							+ "batatas em uma panela grande em fogo baixo por muito tempo\n"
							+ "\n"
							+ "\n"
							+ "* Brent fez um delicioso ensopado com carne, batatas, cenouras, cebola e aipo.\n"
							+ "\n"
							+ "**Tradução -** referindo-se a um alimento que é atraente e atraente e faz com que\n"
							+ "\n"
							+ "quer comer\n"
							+ "\n"
							+ "* Esse prato ficaria mais apetitoso se você polvilhar um pouco de queijo parmesão\n"
							+ "e salsa por cima.\n"
							+ "\n"
							+ "**Tradução -** transparente; sem nenhuma cor; permitindo que a luz passe\n"
							+ "\n"
							+ "* Você tem uma garrafa de vidro transparente?\n"
							+ "\n"
							+ "**Tradução -** um líquido transparente feito de carne, legumes e ervas fervendo\n"
							+ "\n"
							+ "\n"
							+ "* Você pode usar esses ossos e um pouco de aipo e cebola para fazer um bom peixe\n"
							+ "estoque.\n"
							+ "\n"
							+ "**Tradução -** para tornar algo mais espesso (menos líquido ou menos líquido), especialmente\n"
							+ "adicionando farinha ou amido de milho\n"
							+ "\n"
							+ "* Vamos tentar engrossar a massa adicionando mais farinha.\n"
							+ "\n"
							+ "**Tradução -** para ferver algo suavemente em fogo baixo, não em fogo alto\n"
							+ "\n"
							+ "* Deixe a mistura ferver por cerca de cinco minutos e depois desligue o fogo e\n"
							+ "cubra a panela.\n"
							+ "**Tradução -** ta-da; uma palavra usada para apresentar algo que aconteceu muito\n"
							+ "rápido ou muito bem e parece quase mágico\n"
							+ "\n"
							+ "\n"
							+ "* Mantenha pressionado o botão de controle, clique aqui e pronto! Você criou um\n"
							+ "belo gráfico.\n"
							+ "\n"
							+ "**Tradução -** gostando de algo; com uma preferência por algo\n"
							+ "\n"
							+ "\n"
							+ "* Sempre fui parte de combinações de frutas e chocolate, como chocolate-\n"
							+ "bolo de framboesa ou sorvete de chocolate com laranja.\n"
							+ "\n"
							+ "**Tradução -** panela de barro; uma pequena máquina elétrica que cozinha lentamente os alimentos\n"
							+ "muitas horas a baixa temperatura\n"
							+ "\n"
							+ "* Sheila geralmente coloca tudo em uma panela lenta antes de ir trabalhar, para que\n"
							+ "quando chega em casa à noite, o jantar está pronto para comer.\n"
							+ "\n"
							+ "**Tradução -** um recipiente de metal redondo com uma ou duas alças e uma tampa, colocado em uma\n"
							+ "fogão para cozinhar alimentos que contêm muito líquido\n"
							+ "\n"
							+ "* Coloque alguns tomates, alho, cebola e pimentão em cubos nessa panela, para\n"
							+ "\n"
							+ "pode fazer molho de espaguete.\n"
							+ "\n"
							+ "**Tradução -** uma sopa suave e cremosa ou outro alimento feito colocando tudo em um\n"
							+ "\n"
							+ "liquidificador para que não fiquem grandes pedaços\n"
							+ "\n"
							+ "* Os bebês ainda não aprenderam a mastigar, para que possam comer apenas purê.\n"
							+ "\n"
							+ "**Tradução -** uma sopa cremosa e grossa, feita especialmente com lagosta\n"
							+ "\n"
							+ "\n"
							+ "* Este bisque seria perfeito em uma noite fria de inverno.\n"
							+ "\n"
							+ "**Tradução -** um ensopado feito de frutos do mar, batatas e leite ou nata\n"
							+ "\n"
							+ "* Este restaurante serve a melhor sopa de mariscos da costa.\n"
							+ "\n"
							+ "**Tradução -** ter entusiasticamente ter ou fazer algo\n"
							+ "\n"
							+ "* São 5:30 da manhã e eu realmente posso tomar uma xícara de café agora.\n"
							+ "\n"
							+ "**Tradução -** uma lata; um recipiente de metal selado nas duas extremidades, usado para armazenar\n"
							+ "comida preparada por um longo período de tempo\n"
							+ "\n"
							+ "* Você prefere feijão verde fresco ou feijão verde de uma lata?"
							+ "\n"
							+ "\n"
							+ "\n";

		}
	}
}
