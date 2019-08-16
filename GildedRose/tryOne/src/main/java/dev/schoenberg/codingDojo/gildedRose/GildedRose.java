package dev.schoenberg.codingDojo.gildedRose;

public class GildedRose {
	private static final int QUALITY_CAP = 50;
	private final Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (items[i].quality > 0) {
					reduceQuality(i);
				}
			} else {
				if (items[i].quality < QUALITY_CAP) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						increaseQualityIfLessThan11daysLeft(i);
						increaseQualityIfLessThan6daysLeft(i);
					}
				}
			}

			reduceSellIn(i);

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							reduceQuality(i);
						}
					} else {
						items[i].quality = 0;
					}
				} else {
					increaseQuality(i);
				}
			}
		}
	}

	private void increaseQualityIfLessThan6daysLeft(int i) {
		if (items[i].sellIn < 6) {
			increaseQuality(i);
		}
	}

	private void increaseQualityIfLessThan11daysLeft(int i) {
		if (items[i].sellIn < 11) {
			increaseQuality(i);
		}
	}

	private void reduceSellIn(int i) {
		if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
			items[i].sellIn = items[i].sellIn - 1;
		}
	}

	private void increaseQuality(int i) {
		if (items[i].quality < QUALITY_CAP) {
			items[i].quality = items[i].quality + 1;
		}
	}

	private void reduceQuality(int i) {
		if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
			items[i].quality = items[i].quality - 1;
		}
	}
}
