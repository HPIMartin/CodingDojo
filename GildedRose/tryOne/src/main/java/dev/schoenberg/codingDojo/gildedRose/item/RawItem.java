package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class RawItem implements ParsedItem {
	private static final int QUALITY_CAP = 50;

	private final Item item;

	public RawItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		if (item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.quality < QUALITY_CAP) {
				item.quality = item.quality + 1;

				if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					increaseQualityIfLessThan11daysLeft();
					increaseQualityIfLessThan6daysLeft();
				}
			}
		} else {
			if (item.quality > 0) {
				reduceQuality();
			}
		}

		reduceSellIn();

		if (item.sellIn < 0) {
			sellDatePassed();
		}
	}

	private void sellDatePassed() {
		if (item.name.equals("Aged Brie")) {
			increaseQuality();
		} else {
			if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				item.quality = 0;
			} else {
				if (item.quality > 0) {
					reduceQuality();
				}
			}
		}
	}

	private void increaseQualityIfLessThan6daysLeft() {
		if (item.sellIn < 6) {
			increaseQuality();
		}
	}

	private void increaseQualityIfLessThan11daysLeft() {
		if (item.sellIn < 11) {
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

	private void reduceQuality() {
		item.quality = item.quality - 1;
	}
}
