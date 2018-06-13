package com.gildedrose;

public class Sulfuras extends UpdatableItem {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // do nothing
    }
}
