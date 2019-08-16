package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class Cheese extends ParsedItem {
	public Cheese(Item item) {
		super(item);
	}

	@Override
	protected void sellDatePassed() {
		increaseQuality();
	}

	@Override
	protected void updateQuality() {
		increaseQuality();
	}
}
