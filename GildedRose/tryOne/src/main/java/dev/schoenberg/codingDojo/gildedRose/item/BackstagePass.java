package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class BackstagePass extends ParsedItem {
	public BackstagePass(Item item) {
		super(item);
	}

	@Override
	protected void updateQuality() {
		increaseQuality();
		increaseQualityIf10daysLeft();
		increaseQualityIf5daysLeft();
	}

	@Override
	protected void sellDatePassed() {
		item.quality = 0;
	}

	private void increaseQualityIf5daysLeft() {
		if (item.sellIn < 6) {
			increaseQuality();
		}
	}

	private void increaseQualityIf10daysLeft() {
		if (item.sellIn < 11) {
			increaseQuality();
		}
	}
}
