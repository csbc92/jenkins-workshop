package net.praqma.codeacademy.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    /**
    * This is a fine foo test
    */
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
    * This is a fine bar test
    */
    @Test
    public void bar() {
        Item[] items = new Item[] { new Item("bar", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("bar", app.items[0].name);
    }

    /**
    * This is a fine bas test
    */
    @Test
    public void bas() {
        Item[] items = new Item[] { new Item("bas", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("bas", app.items[0].name);
    }

    /**
    * This is a fine woo test
    */
    @Test
    public void woo() {
        Item[] items = new Item[] { new Item("woo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("woo", app.items[0].name);
    }

}
