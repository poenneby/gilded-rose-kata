package com.gildedrose;

public class BackstagePass extends UpdatableItem {
    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (this.sellIn < 11) {
            if (this.quality < 50) {
                increaseQuality();
            }
        }

        if (this.sellIn < 6) {
            if (this.quality < 50) {
                increaseQuality();
            }
        }

        decreaseSellIn();
        if (this.sellIn < 0) {
            zeroQuality();
        }
    }
}
