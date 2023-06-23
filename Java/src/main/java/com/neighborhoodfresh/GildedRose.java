package com.neighborhoodfresh;

class NeighborhoodFresh {
    Item[] items;

    public NeighborhoodFresh(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // iterate through all items
        for (int i = 0; i < items.length; i++) {

            // “Sulfuras”, being a legendary item, never has to be sold or decrease in Quality
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {

                if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    // The Quality of an item is never negative
                    if (items[i].quality > 0) {
                        if (items[i].name.startsWith("Conjured")) {
                            // For Conjured items, Once the sell by date has passed (sellIn <= 0), Quality degrades twice as fast as normal items
                            if (items[i].sellIn <= 0) {
                                items[i].quality = items[i].quality - 4;
                            } else {
                                items[i].quality = items[i].quality - 2;
                            }

                        } else {
                            // For normal items, Once the sell by date has passed (sellIn <= 0), Quality degrades twice as fast
                            if (items[i].sellIn <= 0) {
                                items[i].quality = items[i].quality - 2;
                            } else {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    }

                } else {
                    // “Aged Brie” and “Backstage passes”, actually increases in Quality the older it gets, but the maximum quality can hold is 50
                    if (items[i].quality < 50) {
                        //Backstage passes, like aged brie, increases in Quality as it’s SellIn value approaches;
                        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (items[i].sellIn > 10 ) {
                                items[i].quality = items[i].quality + 1;
                            } else if (items[i].sellIn <= 10 && items[i].sellIn > 5) {
                                // Quality increases by 2 when there are 10 days or less
                                items[i].quality = items[i].quality + 2;
                            } else if (items[i].sellIn <= 5 && items[i].sellIn > 0) {
                                // Quality increases by 3 when there are 5 days or less
                                items[i].quality = items[i].quality + 3;
                            } else if (items[i].sellIn <= 0) {
                                // but Quality drops to 0 after the concert
                                items[i].quality = 0;
                            }
                        } else {
                            // "Aged Brie” actually increases in Quality the older it gets
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }

                // decrease the sellIn by 1
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }

    public void printItemsAndTheirInformation() {
        System.out.println("Items information after a day...");
        // iterate through all items
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item Name : " + items[i].name + " ---- " + "Selling value : " + items[i].sellIn + " ---- " + "Quality : " + items[i].quality);
        }
    }
}
