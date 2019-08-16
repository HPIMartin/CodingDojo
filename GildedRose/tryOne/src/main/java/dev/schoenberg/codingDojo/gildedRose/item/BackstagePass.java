package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class BackstagePass implements ParsedItem {
	private final Item item;

	public BackstagePass(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		increaseQuality();

		reduceSellIn();

		increaseQualityIf10daysLeft();
		increaseQualityIf5daysLeft();

		if (item.sellIn < 0) {
			sellDatePassed();
		}
	}

	private void sellDatePassed() {
		item.quality = 0;
	}

	private void increaseQualityIf5daysLeft() {
		if (item.sellIn < 5) {
			increaseQuality();
		}
	}

	private void increaseQualityIf10daysLeft() {
		if (item.sellIn < 10) {
			increaseQuality();
		}
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
