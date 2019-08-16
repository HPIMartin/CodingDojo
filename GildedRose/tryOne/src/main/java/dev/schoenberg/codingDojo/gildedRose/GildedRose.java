package dev.schoenberg.codingDojo.gildedRose;

import static java.util.Arrays.*;

public class GildedRose {
	private final Item[] items;
	private ItemParser parser;

	public GildedRose(Item[] items, ItemParser parser) {
		this.items = items;
		this.parser = parser;
	}

	public void updateQuality() {
		stream(items).map(parser::parse).forEach(ParsedItem::updateQuality);
	}
}
