package be.cloudnative;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Filer {

	static String read(File file) throws Exception {

		try (FileReader reader = new FileReader(file)) {
			StringBuilder content = new StringBuilder();
			int ch;
			do {
				ch = reader.read();
				content.append((char) ch);
			} while (ch != -1);
			return content.toString();
		}

	}

	static void write(File file, String text) throws IOException {
		try(FileWriter fileWriter = new FileWriter(file)){
			fileWriter.write(text);
		}
	}
}
