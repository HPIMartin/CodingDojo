package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class LegendaryItem extends ParsedItem {
	public LegendaryItem(Item item) {
		super(item);
	}

	@Override
	protected void updateQuality() {
		item.quality = 80;
	}

	@Override
	protected void sellDatePassed() {
		// NOOP
	}

	@Override
	protected void reduceSellIn() {
		// NOOP
	}
}
