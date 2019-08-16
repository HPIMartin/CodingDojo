package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class NormalItemTest {
	@Test
	public void sellInIsReduced() {
		Item item = new Item("", 1, 0);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsReduced() {
		Item item = new Item("", 20, 20);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(19, item.quality);
	}

	@Test
	public void qualityIsNeverNegative() {
		Item item = new Item("", 20, 0);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(0, item.quality);
	}

	@Test
	public void qualityReducedTwiceAfterSellDatePassed() {
		Item item = new Item("", 0, 2);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(0, item.quality);
	}
}
