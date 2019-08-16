package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class CheeseTest {
	@Test
	public void qualityIsIncreased() {
		Item item = new Item("", 20, 0);
		Cheese tested = new Cheese(item);

		tested.update();

		assertEquals(1, item.quality);
	}

	@Test
	public void qualityIncreasedTwiceAfterSellDatePassed() {
		Item item = new Item("", 0, 0);
		Cheese tested = new Cheese(item);

		tested.update();

		assertEquals(2, item.quality);
	}
}
