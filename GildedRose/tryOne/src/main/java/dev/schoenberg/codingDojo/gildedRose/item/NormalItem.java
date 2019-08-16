package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class NormalItem implements ParsedItem {
	private final Item item;

	public NormalItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		reduceQuality();

		reduceSellIn();

		if (item.sellIn < 0) {
			sellDatePassed();
		}
	}

	private void sellDatePassed() {
		reduceQuality();
	}

	private void reduceSellIn() {
		item.sellIn = item.sellIn - 1;
	}

	private void reduceQuality() {
		if (item.quality > 0) {
			item.quality = item.quality - 1;
		}
	}
}
