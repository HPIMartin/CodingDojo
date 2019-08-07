package dev.schoenberg.codingDojo.birthdayGreetings.fileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SimpleFileReader implements FileReader {
	@Override
	public List<String> readAllLines(Path file) {
		try {
			return Files.readAllLines(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
