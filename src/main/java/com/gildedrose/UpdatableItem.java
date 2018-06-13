package com.gildedrose;

public abstract class UpdatableItem extends Item {
    public UpdatableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public abstract void updateQuality();

    void zeroQuality() {
        this.quality = 0;
    }

    void decreaseSellIn() {
        this.sellIn -= 1;
    }

    void decreaseQuality() {
        this.quality -= 1;
    }

    void increaseQuality() {
        this.quality += 1;
    }
}
