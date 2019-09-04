package dev.schoenberg.codingDojo.gildedRose;

import dev.schoenberg.codingDojo.gildedRose.item.BackstagePass;
import dev.schoenberg.codingDojo.gildedRose.item.Cheese;
import dev.schoenberg.codingDojo.gildedRose.item.Conjured;
import dev.schoenberg.codingDojo.gildedRose.item.LegendaryItem;
import dev.schoenberg.codingDojo.gildedRose.item.NormalItem;

public class ItemParser {
	public ParsedItem parse(Item raw) {
		if (isLegendaryItem(raw)) {
			return new LegendaryItem(raw);
		}
		if (isBackstagePass(raw)) {
			return new BackstagePass(raw);
		}
		if (isCheese(raw)) {
			return new Cheese(raw);
		}
		if (isConjured(raw)) {
			return new Conjured(raw);
		}

		return new NormalItem(raw);
	}

	private boolean isConjured(Item raw) {
		return "Conjured Mana Cake".equals(raw.name);
	}

	private boolean isCheese(Item raw) {
		return "Aged Brie".equals(raw.name);
	}

	private boolean isBackstagePass(Item raw) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(raw.name);
	}

	private boolean isLegendaryItem(Item raw) {
		return "Sulfuras, Hand of Ragnaros".equals(raw.name);
	}
}
