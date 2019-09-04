package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class ConjuredTest {
	@Test
	public void qualityIsReduced() {
		Item item = new Item("", 20, 20);
		Conjured tested = new Conjured(item);

		tested.update();

		assertEquals(18, item.quality);
	}

	@Test
	public void qualityReducedTwiceAfterSellDatePassed() {
		Item item = new Item("", 0, 4);
		Conjured tested = new Conjured(item);

		tested.update();

		assertEquals(0, item.quality);
	}
}
