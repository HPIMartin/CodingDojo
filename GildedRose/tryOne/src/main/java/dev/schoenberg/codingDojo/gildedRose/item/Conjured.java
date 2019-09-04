package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class Conjured extends ParsedItem {
	public Conjured(Item item) {
		super(item);
	}

	@Override
	protected void sellDatePassed() {
		decreaseQuality();
		decreaseQuality();
	}

	@Override
	protected void updateQuality() {
		decreaseQuality();
		decreaseQuality();
	}
}
