package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class LegendaryItem implements ParsedItem {
	private final Item item;

	public LegendaryItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		item.quality = 80;
	}
}
