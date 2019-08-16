package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class BackstagePassTest {
	@Test
	public void qualityIsIncreased() {
		Item item = new Item("", 20, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.update();

		assertEquals(1, item.quality);
	}

	@Test
	public void qualityIsIncreasedTwiceAsFast10DaysBefore() {
		Item item = new Item("", 10, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.update();

		assertEquals(2, item.quality);
	}

	@Test
	public void qualityIsIncreasedThriceAsFast5DaysBefore() {
		Item item = new Item("", 5, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.update();

		assertEquals(3, item.quality);
	}

	@Test
	public void qualityDropsToZeroAfterTheConcert() {
		Item item = new Item("", 0, 1);
		BackstagePass tested = new BackstagePass(item);

		tested.update();

		assertEquals(0, item.quality);
	}
}
