package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class Cheese implements ParsedItem {
	private final Item item;

	public Cheese(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		increaseQuality();

		reduceSellIn();

		if (item.sellIn < 0) {
			sellDatePassed();
		}
	}

	private void sellDatePassed() {
		increaseQuality();
	}

	private void reduceSellIn() {
		item.sellIn = item.sellIn - 1;
	}

	private void increaseQuality() {
		if (item.quality < QUALITY_CAP) {
			item.quality = item.quality + 1;
		}
	}
}
