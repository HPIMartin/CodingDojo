package dev.schoenberg.codingDojo.gildedRose;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.List;

public class GildedRose {
	private final Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		List<RawItem> rawItems = stream(items).map(RawItem::new).collect(toList());
		rawItems.forEach(RawItem::updateQuality);
	}
}
