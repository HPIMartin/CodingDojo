package dev.schoenberg.codingDojo.gildedRose;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.schoenberg.codingDojo.gildedRose.GildedRose;
import dev.schoenberg.codingDojo.gildedRose.Item;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

}
