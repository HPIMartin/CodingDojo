package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class NormalItemTest {
	@Test
	public void qualityIsReduced() {
		Item item = new Item("", 20, 20);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(19, item.quality);
	}

	@Test
	public void qualityReducedTwiceAfterSellDatePassed() {
		Item item = new Item("", 0, 2);
		NormalItem tested = new NormalItem(item);

		tested.update();

		assertEquals(0, item.quality);
	}
}
