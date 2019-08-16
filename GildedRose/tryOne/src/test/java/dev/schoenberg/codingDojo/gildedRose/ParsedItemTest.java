package dev.schoenberg.codingDojo.gildedRose;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.item.Cheese;

public class ParsedItemTest {
	@Test
	public void sellInIsReduced() {
		Item item = new Item("", 1, 0);
		SimpleItem tested = new SimpleItem(item);

		tested.update();

		assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsUpdated() {
		Item item = new Item("", 0, 0);
		SimpleItem tested = new SimpleItem(item);

		tested.update();

		assertTrue(tested.updateQualityInvoked);
	}

	@Test
	public void sellDatePassedIsInvoked() {
		SimpleItem tested = new SimpleItem(new Item("", 0, 0));

		tested.update();

		assertTrue(tested.sellDateInvoked);
	}

	@Test
	public void sellDatePassedIsNotInvokedIfSellDatesLeft() {
		SimpleItem tested = new SimpleItem(new Item("", 1, 0));

		tested.update();

		assertFalse(tested.sellDateInvoked);
	}

	@Test
	public void qualityCanNotExtendCap() {
		Item item = new Item("", 20, 50);
		Cheese tested = new Cheese(item);

		tested.update();

		assertEquals(50, item.quality);
	}

	private class SimpleItem extends ParsedItem {
		private boolean sellDateInvoked = false;
		private boolean updateQualityInvoked = false;

		public SimpleItem(Item item) {
			super(item);
		}

		@Override
		protected void sellDatePassed() {
			sellDateInvoked = true;
		}

		@Override
		protected void updateQuality() {
			updateQualityInvoked = true;
			increaseQuality();
		}
	}
}
