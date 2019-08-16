package dev.schoenberg.codingDojo.gildedRose;

import static java.lang.String.format;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

import org.junit.Test;

public class AcceptanceTest {
	private static final int INT_SPACE = 10;
	private static final int STRING_SPACE = 50;
	private static final String DELIMITTER = " # ";

	@Test
	public void generateOutput() {
		calculateTenDays(System.out::println);
	}

	@Test
	public void generatedOutputAsRecorded() throws IOException {
		StringBuffer result = new StringBuffer();

		calculateTenDays(s -> result.append(s).append(System.lineSeparator()));

		String expected = Files.readString(Path.of("src", "test", "resources", "extractedExample.txt"));
		assertEquals(expected, result.toString());
	}

	private void calculateTenDays(Consumer<String> printOut) {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), new Item("Aged Brie", 2, 0), new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80), new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		GildedRose app = new GildedRose(items);

		for (int i = 0; i <= 10; i++) {
			printOut.accept("---------------------------------------- day " + i + " ----------------------------------------");
			printOut.accept(tail("name", STRING_SPACE) + DELIMITTER + tail("sellIn", INT_SPACE) + DELIMITTER + tail("quality", INT_SPACE));
			for (Item item : items) {
				printOut.accept(formatItem(item));
			}
			app.updateQuality();
		}
	}

	private static String formatItem(Item item) {
		return tail(item.name, STRING_SPACE) + DELIMITTER + tail(item.sellIn, INT_SPACE) + DELIMITTER + tail(item.quality, INT_SPACE);
	}

	private static String tail(Object toPad, int expectedLength) {
		return format("%-" + expectedLength + "s", toPad);
	}
}
