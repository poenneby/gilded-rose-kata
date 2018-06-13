package com.gildedrose;

public class RegularItem extends UpdatableItem {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality > 0) {
            decreaseQuality();
        }
        if (this.sellIn < 0 && this.quality > 0) {
            decreaseQuality();
        }
        decreaseSellIn();
        if (this.sellIn < 0 && this.quality > 0) {
            decreaseQuality();
        }
    }
}
