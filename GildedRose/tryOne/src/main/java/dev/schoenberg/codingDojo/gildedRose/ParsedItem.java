package dev.schoenberg.codingDojo.gildedRose;

public abstract class ParsedItem {
	private static final int QUALITY_CAP = 50;

	protected final Item item;

	public ParsedItem(Item item) {
		this.item = item;
	}

	public void update() {
		updateQuality();

		reduceSellIn();

		if (item.sellIn < 0) {
			sellDatePassed();
		}
	}

	protected abstract void sellDatePassed();

	protected abstract void updateQuality();

	protected void reduceSellIn() {
		item.sellIn = item.sellIn - 1;
	}

	protected void increaseQuality() {
		if (item.quality < QUALITY_CAP) {
			item.quality = item.quality + 1;
		}
	}
}
