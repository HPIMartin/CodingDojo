package dev.schoenberg.codingDojo.gildedRose.item;

import dev.schoenberg.codingDojo.gildedRose.Item;
import dev.schoenberg.codingDojo.gildedRose.ParsedItem;

public class RawItem implements ParsedItem {
	private final Item item;

	public RawItem(Item item) {
		this.item = item;
	}

	@Override
	public void updateQuality() {
		if (item.name.equals("Aged Brie")) {
			increaseQuality();
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
			if (item.quality > 0) {
				reduceQuality();
			}
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
