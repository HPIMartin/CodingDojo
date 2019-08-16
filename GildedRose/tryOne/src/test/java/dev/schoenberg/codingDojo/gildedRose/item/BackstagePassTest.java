package dev.schoenberg.codingDojo.gildedRose.item;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.Item;

public class BackstagePassTest {
	@Test
	public void sellInIsReduced() {
		Item item = new Item("", 1, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsIncreased() {
		Item item = new Item("", 20, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(1, item.quality);
	}

	@Test
	public void qualityCanNotExtendCap() {
		Item item = new Item("", 20, 50);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(50, item.quality);
	}

	@Test
	public void qualityIsIncreasedTwiceAsFast10DaysBefore() {
		Item item = new Item("", 10, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(2, item.quality);
	}

	@Test
	public void qualityIsIncreasedThriceAsFast5DaysBefore() {
		Item item = new Item("", 5, 0);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(3, item.quality);
	}

	@Test
	public void qualityDropsToZeroAfterTheConcert() {
		Item item = new Item("", 0, 1);
		BackstagePass tested = new BackstagePass(item);

		tested.updateQuality();

		assertEquals(0, item.quality);
	}
}