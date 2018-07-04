package com.gildedrose;

public class AgedBrie extends UpdatableItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.quality < 50) {
            increaseQuality();
        }
        decreaseSellIn();
        if (this.sellIn < 0) {
            if (this.quality < 50) {
                increaseQuality();
            }
        }
    }
}
