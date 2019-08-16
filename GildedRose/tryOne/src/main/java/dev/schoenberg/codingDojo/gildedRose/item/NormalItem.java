package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class NormalItem extends ParsedItem {
	public NormalItem(Item item) {
		super(item);
	}

	@Override
	protected void sellDatePassed() {
		updateQuality();
	}

	@Override
	protected void updateQuality() {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
}
