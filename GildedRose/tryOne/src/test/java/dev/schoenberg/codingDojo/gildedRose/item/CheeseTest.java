package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class CheeseTest {
	@Test
	public void sellInIsReduced() {
		Item item = new Item("", 1, 0);
		Cheese tested = new Cheese(item);

		tested.updateQuality();

		assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsIncreased() {
		Item item = new Item("", 20, 0);
		Cheese tested = new Cheese(item);

		tested.updateQuality();

		assertEquals(1, item.quality);
	}

	@Test
	public void qualityCanNotExtendCap() {
		Item item = new Item("", 20, 50);
		Cheese tested = new Cheese(item);

		tested.updateQuality();

		assertEquals(50, item.quality);
	}

	@Test
	public void qualityIncreasedTwiceAfterSellDatePassed() {
		Item item = new Item("", 0, 0);
		Cheese tested = new Cheese(item);

		tested.updateQuality();

		assertEquals(2, item.quality);
	}
}
