package dev.schoenberg.codingDojo.gildedRose;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParsedItemTest {
	@Test
	public void sellInIsReduced() {
		Item item = new Item("", 1, 0);
		SimpleIncreasingItem tested = new SimpleIncreasingItem(item);

		tested.update();

		assertEquals(0, item.sellIn);
	}

	@Test
	public void qualityIsUpdated() {
		Item item = new Item("", 0, 0);
		SimpleIncreasingItem tested = new SimpleIncreasingItem(item);

		tested.update();

		assertTrue(tested.updateQualityInvoked);
	}

	@Test
	public void sellDatePassedIsInvoked() {
		SimpleIncreasingItem tested = new SimpleIncreasingItem(new Item("", 0, 0));

		tested.update();

		assertTrue(tested.sellDateInvoked);
	}

	@Test
	public void sellDatePassedIsNotInvokedIfSellDatesLeft() {
		SimpleIncreasingItem tested = new SimpleIncreasingItem(new Item("", 1, 0));

		tested.update();

		assertFalse(tested.sellDateInvoked);
	}

	@Test
	public void qualityCanNotExtendCap() {
		Item item = new Item("", 20, 50);
		SimpleIncreasingItem tested = new SimpleIncreasingItem(item);

		tested.update();

		assertEquals(50, item.quality);
	}

	@Test
	public void qualityIsNeverNegative() {
		Item item = new Item("", 20, 0);
		SimpleDecreasingItem tested = new SimpleDecreasingItem(item);

		tested.update();

		assertEquals(0, item.quality);
	}

	private class SimpleIncreasingItem extends ParsedItem {
		private boolean sellDateInvoked = false;
		private boolean updateQualityInvoked = false;

		public SimpleIncreasingItem(Item item) {
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

	private class SimpleDecreasingItem extends ParsedItem {
		public SimpleDecreasingItem(Item item) {
			super(item);
		}

		@Override
		protected void sellDatePassed() {}

		@Override
		protected void updateQuality() {
			decreaseQuality();
		}
	}
}
