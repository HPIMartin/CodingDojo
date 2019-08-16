package dev.schoenberg.codingDojo.gildedRose;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import dev.schoenberg.codingDojo.gildedRose.item.LegendaryItem;
import dev.schoenberg.codingDojo.gildedRose.item.RawItem;
import dev.schoenberg.codingDojo.gildedRose.item.BackstagePass;

public class GildedRose {
	private final Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		List<ParsedItem> rawItems = stream(items).map(this::parse).collect(toList());
		rawItems.forEach(ParsedItem::updateQuality);
	}

	public ParsedItem parse(Item raw) {
		if (isLegendaryItem(raw)) {
			return new LegendaryItem(raw);
		}
		if (isBackstagePass(raw)) {
			return new BackstagePass(raw);
		}

		return new RawItem(raw);
	}

	private boolean isBackstagePass(Item raw) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(raw.name);
	}

	private boolean isLegendaryItem(Item raw) {
		return "Sulfuras, Hand of Ragnaros".equals(raw.name);
	}
}
