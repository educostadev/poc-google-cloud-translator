package be.cloudnative;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownExtractorTest {

	String translated_165 = "## GLOSSÁRIO ** Já tive! - ** estar cansado de uma situação, não estar disposto a tolerar algo * Já tive isso com o mau serviço deste restaurante e não pretendo voltar. ** aguenta - ** tolera, aguenta * Não aguento quando o tempo está tão quente. **Qual é o problema? - ** Qual é o problema ?, O que há de errado com ... * Qual é o problema com Doug? Ele é normalmente tão feliz. ** ser o alvo de - ** ser a pessoa ou coisa que as pessoas estão tirando sarro ou rindo * Seu mau canto é o alvo de muitas piadas entre seus amigos. ** piadas práticas - ** fazendo um truque com alguém que geralmente envolve alguma ação física * Estou planejando fazer uma piada prática com meu amigo quando chegar uma visita. ** O que ele fez agora? - ** que erro essa pessoa cometeu, que problema eles criaram; geralmente se fala de alguém que teve problemas no passado * Essas crianças estão sempre tendo problemas. O que eles fizeram agora? ** rindo - ** rindo, mas não muito alto * O filme era tão engraçado que eu não conseguia parar de rir o tempo todo. ** adesivo - ** um pedaço de papel com cola de um lado para colar ou aderir a outra coisa * Alguns alunos gostam de decorar suas pastas escolares com adesivos. ** preso - ** difícil de remover; pretérito de colar * Fiquei chiclete preso na parte inferior do meu sapato e não consegui tirá-lo. ** mamãe gostosa - ** uma mulher sexualmente atraente; uma expressão comum na década de 1960, mas não tão popular hoje * Ela deve pensar que é uma mãe em brasa para se vestir assim. papa - informal para o pai; uma palavra às vezes usada por crianças em vez de * &quot;pai&quot; * * Ela disse: &quot;Papai, quando você estará em casa do trabalho?&quot; * ele vai entender - se meter em problemas, ser punido * carro sem perguntar, ele vai conseguir quando voltar para casa. vingança - fazer algo errado com alguém que fez algo errado com você * Depois que sua melhor amiga roubou o namorado, ela queria se vingar.";

	String glossary_165 =
			"##GLOSSARY\n"
					+ "**I’ve had it! –** to be tired of a situation, to be unwilling to tolerate something\n"
					+ "\n"
					+ "*I’ve had it with the poor service at this restaurant and I don’t plan to come back.\n"
					+ "\n"
					+ "**take it –** tolerate, to put up with\n"
					+ "\n"
					+ "*I can’t take it when the weather is so hot.\n"
					+ "\n"
					+ "**What’s the matter? –** What is the problem?, What is wrong with…\n"
					+ "\n"
					+ "*What’s the matter with Doug? He is normally so happy.\n"
					+ "\n"
					+ "**being the butt of –** to be the person or thing that people are making fun of or\n"
					+ "laughing at\n"
					+ "\n"
					+ "*Her bad singing is the butt of a lot of jokes among her friends.\n"
					+ "\n"
					+ "**practical jokes –** playing a trick on someone that usually involves some physical\n"
					+ "action\n"
					+ "\n"
					+ "*I am planning to play a practical joke on my friend when comes for a visit.\n"
					+ "\n"
					+ "**What has he done now? –** what mistake has this person done, what problem\n"
					+ "have they created; usually said of someone who has had problems in the past\n"
					+ "\n"
					+ "*Those kids are always getting into trouble. What have they done now?\n"
					+ "\n"
					+ "**giggling –** to laugh, but not too loudly\n"
					+ "\n"
					+ "*The movie was so funny, I couldn’t stop giggling the whole time.\n"
					+ "\n"
					+ "**sticker –** a piece of paper that has glue on one side to make it stick or adhere to\n"
					+ "something else\n"
					+ "\n"
					+ "*Some students like to decorate their school folders with stickers.\n"
					+ "\n"
					+ "**stuck –** difficult to remove; past tense of to stick\n"
					+ "\n"
					+ "\n"
					+ "*I got gum stuck to the bottom of my shoe and I couldn’t get it off.\n"
					+ "\n"
					+ "**red hot mama –** a sexually attractive woman; an expression common in the\n"
					+ "1960s, but not as popular today\n"
					+ "\n"
					+ "*She must think she’s a red hot mama to dress like that.\n"
					+ "papa - informal for father; a word sometimes used by children instead of *“dad”*\n"
					+ "\n"
					+ "*She said, *“Papa, when will you be home from work?”*\n"
					+ "\n"
					+ "he’s going to get it - to get into trouble, to be punished\n"
					+ "\n"
					+ "\n"
					+ "*If he borrowed her car without asking, he’s going to get it when he comes\n"
					+ "home.\n"
					+ "\n"
					+ "revenge - to do something wrong to someone who has done something wrong to\n"
					+ "you\n"
					+ "\n"
					+ "*After her best friend stole her boyfriend, she wanted to get revenge.\n"
					+ "\n"
					+ "\n"
					+ "\n";

	String path =
			(new File(""))
					.getAbsolutePath() +
					File.separator +
					"src" +
					File.separator +
					"test" +
					File.separator +
					"resources" +
					File.separator +
					"ESLPOD_1065_Guide.md";

	String glossary_pt_no_vocab =
			"##GLOSSÁRIO\n"
					+ "\n"
					+ "[0] a tampa ou o topo de uma panela ou outro recipiente\n"
					+ "\n"
					+ "* Eles têm uma gaveta cheia de recipientes de armazenamento de plástico, mas é quase impossível\n"
					+ "para encontrar uma tampa correspondente.\n"
					+ "\n"
					+ "[1] um líquido quente que é comido com uma colher, geralmente feito pela fervura de carne e\n"
					+ "legumes em água e ervas, geralmente com pequenos pedaços de carne, legumes,\n"
					+ "e / ou macarrão flutuando nele\n"
					+ "\n"
					+ "\n"
					+ "* Por favor, salve os restos de frango e ossos, e podemos usá-lo para fazer uma sopa\n"
					+ "amanhã à noite.\n"
					+ "\n"
					+ "[2] espessa, preenchida, nutritiva e satisfatória\n"
					+ "\n"
					+ "\n"
					+ "* Claire fez sanduíches saudáveis \u200B\u200Bcom muita carne assada e peru.\n"
					+ "\n"
					+ "[3] uma sopa muito grossa feita ao cozinhar carne, legumes e principalmente\n"
					+ "batatas em uma panela grande em fogo baixo por muito tempo\n"
					+ "\n"
					+ "\n"
					+ "* Brent fez um delicioso ensopado com carne, batatas, cenouras, cebola e aipo.\n"
					+ "\n"
					+ "[4] referindo-se a um alimento que é atraente e atraente e faz com que\n"
					+ "\n"
					+ "quer comer\n"
					+ "\n"
					+ "* Esse prato ficaria mais apetitoso se você polvilhar um pouco de queijo parmesão\n"
					+ "e salsa por cima.\n"
					+ "\n"
					+ "[5] transparente; sem nenhuma cor; permitindo que a luz passe\n"
					+ "\n"
					+ "* Você tem uma garrafa de vidro transparente?\n"
					+ "\n"
					+ "[6] um líquido transparente feito de carne, legumes e ervas fervendo\n"
					+ "\n"
					+ "\n"
					+ "* Você pode usar esses ossos e um pouco de aipo e cebola para fazer um bom peixe\n"
					+ "estoque.\n"
					+ "\n"
					+ "[7] para tornar algo mais espesso (menos líquido ou menos líquido), especialmente\n"
					+ "adicionando farinha ou amido de milho\n"
					+ "\n"
					+ "* Vamos tentar engrossar a massa adicionando mais farinha.\n"
					+ "\n"
					+ "[8] para ferver algo suavemente em fogo baixo, não em fogo alto\n"
					+ "\n"
					+ "* Deixe a mistura ferver por cerca de cinco minutos e depois desligue o fogo e\n"
					+ "cubra a panela.\n"
					+ "[9] ta-da; uma palavra usada para apresentar algo que aconteceu muito\n"
					+ "rápido ou muito bem e parece quase mágico\n"
					+ "\n"
					+ "\n"
					+ "* Mantenha pressionado o botão de controle, clique aqui e pronto! Você criou um\n"
					+ "belo gráfico.\n"
					+ "\n"
					+ "[10] gostando de algo; com uma preferência por algo\n"
					+ "\n"
					+ "\n"
					+ "* Sempre fui parte de combinações de frutas e chocolate, como chocolate-\n"
					+ "bolo de framboesa ou sorvete de chocolate com laranja.\n"
					+ "\n"
					+ "[11] panela de barro; uma pequena máquina elétrica que cozinha lentamente os alimentos\n"
					+ "muitas horas a baixa temperatura\n"
					+ "\n"
					+ "* Sheila geralmente coloca tudo em uma panela lenta antes de ir trabalhar, para que\n"
					+ "quando chega em casa à noite, o jantar está pronto para comer.\n"
					+ "\n"
					+ "[12] um recipiente de metal redondo com uma ou duas alças e uma tampa, colocado em uma\n"
					+ "fogão para cozinhar alimentos que contêm muito líquido\n"
					+ "\n"
					+ "* Coloque alguns tomates, alho, cebola e pimentão em cubos nessa panela, para\n"
					+ "\n"
					+ "pode fazer molho de espaguete.\n"
					+ "\n"
					+ "[13] uma sopa suave e cremosa ou outro alimento feito colocando tudo em um\n"
					+ "\n"
					+ "liquidificador para que não fiquem grandes pedaços\n"
					+ "\n"
					+ "* Os bebês ainda não aprenderam a mastigar, para que possam comer apenas purê.\n"
					+ "\n"
					+ "[14] uma sopa cremosa e grossa, feita especialmente com lagosta\n"
					+ "\n"
					+ "\n"
					+ "* Este bisque seria perfeito em uma noite fria de inverno.\n"
					+ "\n"
					+ "[15] um ensopado feito de frutos do mar, batatas e leite ou nata\n"
					+ "\n"
					+ "* Este restaurante serve a melhor sopa de mariscos da costa.\n"
					+ "\n"
					+ "[16] ter entusiasticamente ter ou fazer algo\n"
					+ "\n"
					+ "* São 5:30 da manhã e eu realmente posso tomar uma xícara de café agora.\n"
					+ "\n"
					+ "[17] uma lata; um recipiente de metal selado nas duas extremidades, usado para armazenar\n"
					+ "comida preparada por um longo período de tempo\n"
					+ "\n"
					+ "* Você prefere feijão verde fresco ou feijão verde de uma lata?"
					+ "\n"
					+ "\n"
					+ "\n";

	String glossary_pt_traduzido =
			"##GLOSSÁRIO\n"
					+ "\n"
					+ "**Tradução -** a tampa ou o topo de uma panela ou outro recipiente\n"
					+ "\n"
					+ "* Eles têm uma gaveta cheia de recipientes de armazenamento de plástico, mas é quase impossível\n"
					+ "para encontrar uma tampa correspondente.\n"
					+ "\n"
					+ "[1] um líquido quente que é comido com uma colher, geralmente feito pela fervura de carne e\n"
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

	String glossary =
			"##GLOSSARY\n"
					+ "\n"
					+ "**lid –** the cover or top to a pot or another container\n"
					+ "\n"
					+ "*They have a drawer full of plastic storage containers, but it’s almost impossible\n"
					+ "to find a matching lid.\n"
					+ "\n"
					+ "**soup –** a hot liquid that is eaten with a spoon, usually made by boiling meat and\n"
					+ "vegetables in water and herbs, often with small pieces of meat, vegetables,\n"
					+ "and/or noodles floating in it\n"
					+ "\n"
					+ "\n"
					+ "*Please save the leftover chicken and bones, and we can use it to make a soup\n"
					+ "tomorrow night.\n"
					+ "\n"
					+ "**hearty –** thick, filling, nutritious, and satisfying\n"
					+ "\n"
					+ "\n"
					+ "*Claire made hearty sandwiches with a lot of roast beef and turkey.\n"
					+ "\n"
					+ "**stew –** a very thick soup made by cooking meat, vegetables, and especially\n"
					+ "potatoes in a large pot over low heat for a very long time\n"
					+ "\n"
					+ "\n"
					+ "*Brent made a delicious stew with beef, potatoes, carrots, onion, and celery.\n"
					+ "\n"
					+ "**appetizing –** referring to a food that is attractive and appealing and makes one\n"
					+ "\n"
					+ "want to eat\n"
					+ "\n"
					+ "*That dish would look more appetizing if you sprinkled some parmesan cheese\n"
					+ "and parsley on top.\n"
					+ "\n"
					+ "**clear –** transparent; without any color; allowing light to past through\n"
					+ "\n"
					+ "*Do you have a clear glass bottle?\n"
					+ "\n"
					+ "**stock –** a clear liquid made by boiling meat, vegetables, and herbs\n"
					+ "\n"
					+ "\n"
					+ "*You can use these bones and some celery and onions to make a good fish\n"
					+ "stock.\n"
					+ "\n"
					+ "**to thicken –** to make something thicker (less runny or less liquid-like), especially\n"
					+ "by adding flour or cornstarch\n"
					+ "\n"
					+ "*Let’s try to thicken the batter by adding some more flour.\n"
					+ "\n"
					+ "**to simmer –** to boil something gently on low heat, not at a full boil\n"
					+ "\n"
					+ "*Let the mixture simmer for about five minutes, and then turn off the heat and\n"
					+ "cover the pot.\n"
					+ "**presto –** ta-da; a word used to present something that has happened very\n"
					+ "quickly or very well and seems almost magical\n"
					+ "\n"
					+ "\n"
					+ "*Just hold down the control button, click here, and presto! You’ve created a\n"
					+ "beautiful graphic.\n"
					+ "\n"
					+ "**partial to –** liking something; with a preference for something\n"
					+ "\n"
					+ "\n"
					+ "*I’ve always been partial to combinations of fruit and chocolate, like chocolate-\n"
					+ "raspberry cake, or chocolate-orange ice cream.\n"
					+ "\n"
					+ "**slow cooker –** crock pot; a small, electric machine that cooks food slowly for\n"
					+ "many hours at a low temperature\n"
					+ "\n"
					+ "*Sheila often puts everything in a slow cooker before she goes to work, so that\n"
					+ "when she gets home in the evening, dinner is ready to eat.\n"
					+ "\n"
					+ "**pot –** a round metal container with one or two handles and a lid, placed on a\n"
					+ "stove to cook foods that contain a lot of liquid\n"
					+ "\n"
					+ "*Please put some diced tomatoes, garlic, onion, and peppers in that pot so we\n"
					+ "\n"
					+ "can make spaghetti sauce.\n"
					+ "\n"
					+ "**purée –** a smooth, creamy soup or other food made by putting everything in a\n"
					+ "\n"
					+ "blender so that no large chunks remain\n"
					+ "\n"
					+ "*Babies haven’t learned how to chew yet, so they can eat only purees.\n"
					+ "\n"
					+ "**bisque –** a creamy, thick soup, especially made with lobster\n"
					+ "\n"
					+ "\n"
					+ "*This bisque would be perfect on a cold winter night.\n"
					+ "\n"
					+ "**chowder –** a stew made from seafood, potatoes, and milk or cream\n"
					+ "\n"
					+ "*This restaurant serves the best clam chowder on the coast.\n"
					+ "\n"
					+ "**to go for –** to enthusiastically have or do something\n"
					+ "\n"
					+ "*It’s 5:30 in the morning and I could really go for a cup of coffee right now.\n"
					+ "\n"
					+ "**can –** a tin can; a metal container that is sealed at both ends, used to store\n"
					+ "prepared food for a long period of time\n"
					+ "\n"
					+ "*Do you prefer fresh green beans, or green beans from a can?"
					+ "\n"
					+ "\n"
					+ "\n";

	String glossaryWhitoutVocabulary =
			"##GLOSSARY\n"
					+ "\n"
					+ "[0] the cover or top to a pot or another container\n"
					+ "\n"
					+ "*They have a drawer full of plastic storage containers, but it’s almost impossible\n"
					+ "to find a matching lid.\n"
					+ "\n"
					+ "[1] a hot liquid that is eaten with a spoon, usually made by boiling meat and\n"
					+ "vegetables in water and herbs, often with small pieces of meat, vegetables,\n"
					+ "and/or noodles floating in it\n"
					+ "\n"
					+ "\n"
					+ "*Please save the leftover chicken and bones, and we can use it to make a soup\n"
					+ "tomorrow night.\n"
					+ "\n"
					+ "[2] thick, filling, nutritious, and satisfying\n"
					+ "\n"
					+ "\n"
					+ "*Claire made hearty sandwiches with a lot of roast beef and turkey.\n"
					+ "\n"
					+ "[3] a very thick soup made by cooking meat, vegetables, and especially\n"
					+ "potatoes in a large pot over low heat for a very long time\n"
					+ "\n"
					+ "\n"
					+ "*Brent made a delicious stew with beef, potatoes, carrots, onion, and celery.\n"
					+ "\n"
					+ "[4] referring to a food that is attractive and appealing and makes one\n"
					+ "\n"
					+ "want to eat\n"
					+ "\n"
					+ "*That dish would look more appetizing if you sprinkled some parmesan cheese\n"
					+ "and parsley on top.\n"
					+ "\n"
					+ "[5] transparent; without any color; allowing light to past through\n"
					+ "\n"
					+ "*Do you have a clear glass bottle?\n"
					+ "\n"
					+ "[6] a clear liquid made by boiling meat, vegetables, and herbs\n"
					+ "\n"
					+ "\n"
					+ "*You can use these bones and some celery and onions to make a good fish\n"
					+ "stock.\n"
					+ "\n"
					+ "[7] to make something thicker (less runny or less liquid-like), especially\n"
					+ "by adding flour or cornstarch\n"
					+ "\n"
					+ "*Let’s try to thicken the batter by adding some more flour.\n"
					+ "\n"
					+ "[8] to boil something gently on low heat, not at a full boil\n"
					+ "\n"
					+ "*Let the mixture simmer for about five minutes, and then turn off the heat and\n"
					+ "cover the pot.\n"
					+ "[9] ta-da; a word used to present something that has happened very\n"
					+ "quickly or very well and seems almost magical\n"
					+ "\n"
					+ "\n"
					+ "*Just hold down the control button, click here, and presto! You’ve created a\n"
					+ "beautiful graphic.\n"
					+ "\n"
					+ "[10] liking something; with a preference for something\n"
					+ "\n"
					+ "\n"
					+ "*I’ve always been partial to combinations of fruit and chocolate, like chocolate-\n"
					+ "raspberry cake, or chocolate-orange ice cream.\n"
					+ "\n"
					+ "[11] crock pot; a small, electric machine that cooks food slowly for\n"
					+ "many hours at a low temperature\n"
					+ "\n"
					+ "*Sheila often puts everything in a slow cooker before she goes to work, so that\n"
					+ "when she gets home in the evening, dinner is ready to eat.\n"
					+ "\n"
					+ "[12] a round metal container with one or two handles and a lid, placed on a\n"
					+ "stove to cook foods that contain a lot of liquid\n"
					+ "\n"
					+ "*Please put some diced tomatoes, garlic, onion, and peppers in that pot so we\n"
					+ "\n"
					+ "can make spaghetti sauce.\n"
					+ "\n"
					+ "[13] a smooth, creamy soup or other food made by putting everything in a\n"
					+ "\n"
					+ "blender so that no large chunks remain\n"
					+ "\n"
					+ "*Babies haven’t learned how to chew yet, so they can eat only purees.\n"
					+ "\n"
					+ "[14] a creamy, thick soup, especially made with lobster\n"
					+ "\n"
					+ "\n"
					+ "*This bisque would be perfect on a cold winter night.\n"
					+ "\n"
					+ "[15] a stew made from seafood, potatoes, and milk or cream\n"
					+ "\n"
					+ "*This restaurant serves the best clam chowder on the coast.\n"
					+ "\n"
					+ "[16] to enthusiastically have or do something\n"
					+ "\n"
					+ "*It’s 5:30 in the morning and I could really go for a cup of coffee right now.\n"
					+ "\n"
					+ "[17] a tin can; a metal container that is sealed at both ends, used to store\n"
					+ "prepared food for a long period of time\n"
					+ "\n"
					+ "*Do you prefer fresh green beans, or green beans from a can?"
					+ "\n"
					+ "\n"
					+ "\n";

	@Test
	void extract_glossary() throws Exception {
		MarkdownExtractor extractor = new MarkdownExtractor(Filer.read(new File(path)));

		String result = extractor.extractGlossarySession();

		assertEquals(glossary, result);
	}

	@Test
	void getVocabulary() {
		String text = "**red hot mama –** a sexually attractive woman; an expression common in the\n"
				+ "1960s, but not as popular today\n"
				+ "\n"
				+ "*She must think she’s a red hot mama to dress like that.\n"
				+ "papa - informal for father; a word sometimes used by children instead of *“dad”*\n"
				+ "\n"
				+ "*She said, *“Papa, when will you be home from work?”*";
		MarkdownExtractor extractor = new MarkdownExtractor(null);

		List<String> vocabulary = extractor.getVocabulary(text);

		Assertions.assertEquals(1, vocabulary.size());
		assertEquals("**red hot mama –**", vocabulary.get(0));
	}

	@Test
	void extract_vocabulary() throws Exception {
		MarkdownExtractor extractor = new MarkdownExtractor(Filer.read(new File(path)));

		List<String> vocabulary = extractor.getVocabulary(extractor.extractGlossarySession());

		Assertions.assertEquals(18, vocabulary.size());
		assertEquals("**lid –**", vocabulary.get(0));
		assertEquals("**soup –**", vocabulary.get(1));
		assertEquals("**hearty –**", vocabulary.get(2));
		assertEquals("**stew –**", vocabulary.get(3));
		assertEquals("**appetizing –**", vocabulary.get(4));
		assertEquals("**clear –**", vocabulary.get(5));
		assertEquals("**stock –**", vocabulary.get(6));
		assertEquals("**to thicken –**", vocabulary.get(7));
		assertEquals("**to simmer –**", vocabulary.get(8));
		assertEquals("**presto –**", vocabulary.get(9));
		assertEquals("**partial to –**", vocabulary.get(10));
		assertEquals("**slow cooker –**", vocabulary.get(11));
		assertEquals("**pot –**", vocabulary.get(12));
		assertEquals("**purée –**", vocabulary.get(13));
		assertEquals("**bisque –**", vocabulary.get(14));
		assertEquals("**chowder –**", vocabulary.get(15));
		assertEquals("**to go for –**", vocabulary.get(16));
		assertEquals("**can –**", vocabulary.get(17));
	}

	@Test
	void join_vocabulary() {

		List<String> vocabularyEng = new ArrayList<>();
		vocabularyEng.add("**hearty –**");
		vocabularyEng.add("**stew –**");
		vocabularyEng.add("**appetizing –**");
		vocabularyEng.add("**clear –**");
		vocabularyEng.add("**stock –**");
		vocabularyEng.add("**to thicken –**");
		vocabularyEng.add("**to simmer –**");
		vocabularyEng.add("**presto –**");
		vocabularyEng.add("**partial to –**");
		vocabularyEng.add("**slow cooker –**");
		vocabularyEng.add("**pot –**");
		vocabularyEng.add("**purée –**");
		vocabularyEng.add("**bisque –**");
		vocabularyEng.add("**chowder –**");
		vocabularyEng.add("**to go for –**");
		vocabularyEng.add("**can –**");

		List<String> vocabularyPt = new ArrayList<>();
		vocabularyPt.add("**saudável -**");
		vocabularyPt.add("**ensopado -**");
		vocabularyPt.add("**apetitoso -**");
		vocabularyPt.add("**Claro -**");
		vocabularyPt.add("**estoque -**");
		vocabularyPt.add("**engrossar -**");
		vocabularyPt.add("**a ferver -**");
		vocabularyPt.add("**presto -**");
		vocabularyPt.add("**parcial a -**");
		vocabularyPt.add("**fogão lento -**");
		vocabularyPt.add("**maconha -**");
		vocabularyPt.add("**purê -**");
		vocabularyPt.add("**bisque -**");
		vocabularyPt.add("**sopa -**");
		vocabularyPt.add("**para ir para-**");
		vocabularyPt.add("**lata -**");

		List<String> vocabulary = MarkdownExtractor.joinVocabulary(vocabularyEng, vocabularyPt);

		Assertions.assertEquals(16, vocabulary.size());
		assertEquals("**hearty – saudável -**", vocabulary.get(0));
		assertEquals("**stew – ensopado -**", vocabulary.get(1));
		assertEquals("**appetizing – apetitoso -**", vocabulary.get(2));
		assertEquals("**clear – Claro -**", vocabulary.get(3));
		assertEquals("**stock – estoque -**", vocabulary.get(4));
		assertEquals("**to thicken – engrossar -**", vocabulary.get(5));
		assertEquals("**to simmer – a ferver -**", vocabulary.get(6));
		assertEquals("**presto – presto -**", vocabulary.get(7));
		assertEquals("**partial to – parcial a -**", vocabulary.get(8));
		assertEquals("**slow cooker – fogão lento -**", vocabulary.get(9));
		assertEquals("**pot – maconha -**", vocabulary.get(10));
		assertEquals("**purée – purê -**", vocabulary.get(11));
		assertEquals("**bisque – bisque -**", vocabulary.get(12));
		assertEquals("**chowder – sopa -**", vocabulary.get(13));
		assertEquals("**to go for – para ir para-**", vocabulary.get(14));
		assertEquals("**can – lata -**", vocabulary.get(15));
	}

	@Test
	void remove_vocabulary() throws Exception {

		MarkdownExtractor extractor = new MarkdownExtractor(Filer.read(new File(path)));
		List<String> vocabulary = extractor.getVocabulary(extractor.extractGlossarySession());

		String result = extractor.removeVocabulary(vocabulary, glossary);
		System.out.println(result);
		assertEquals(glossaryWhitoutVocabulary, result);

	}

	@Test
	void add_vocabulary() throws Exception {
		MarkdownExtractor extractor = new MarkdownExtractor(Filer.read(new File(path)));
		List<String> vocabulary = extractor.getVocabulary(extractor.extractGlossarySession());

		String result = extractor.addVocabulary(vocabulary, this.glossaryWhitoutVocabulary);

		assertEquals(glossary, result);
	}
}
