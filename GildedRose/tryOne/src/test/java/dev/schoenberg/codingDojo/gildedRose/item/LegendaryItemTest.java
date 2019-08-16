package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class LegendaryItemTest {
	@Test
	public void hasQuality80() {
		Item item = new Item("", 0, 0);
		LegendaryItem tested = new LegendaryItem(item);

		tested.update();

		assertEquals(80, item.quality);
	}

	@Test
	public void neverHasToBeSold() {
		Item item = new Item("", 42, 0);
		LegendaryItem tested = new LegendaryItem(item);

		tested.update();

		assertEquals(42, item.sellIn);
	}
}
