package com.gildedrose;

public class ConjuredItem extends RegularItem {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }
}
