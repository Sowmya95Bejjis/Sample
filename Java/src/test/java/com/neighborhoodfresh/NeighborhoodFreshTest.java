package com.neighborhoodfresh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NeighborhoodFreshTest {

    @Test
    void foo() {
        // Day 1
        Item[] items = new Item[] { new Item("NormalItem", 3 , 10),
                                    new Item("ConjuredItem", 2, 20),
                                    new Item("Sulfuras, Hand of Ragnaros", 5 , 50),
                                    new Item("Backstage passes to a TAFKAL80ETC concert", 3, 40),
                                    new Item("Aged Brie", 3, 45)};
        NeighborhoodFresh app = new NeighborhoodFresh(items);

        app.updateQuality();
        app.printItemsAndTheirInformation();

        System.out.println("==========================================================");

        app.updateQuality();
        app.printItemsAndTheirInformation();

        System.out.println("==========================================================");

        app.updateQuality();
        app.printItemsAndTheirInformation();

        System.out.println("==========================================================");

        app.updateQuality();
        app.printItemsAndTheirInformation();

    }

}
