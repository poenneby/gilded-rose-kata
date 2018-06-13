package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void should_have_a_string_representation() {
        RegularItem item = new RegularItem("Foo", 2, 3);
        assertThat(item.toString()).isEqualTo("Foo, 2, 3");
    }

    @Test
    public void should_decrease_quality_and_sellIn_by_1() throws Exception {
        RegularItem[] items = new RegularItem[]{new RegularItem("foo", 2, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(3);
        assertThat(app.items[0].sellIn).isEqualTo(1);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(2);
        assertThat(app.items[0].sellIn).isEqualTo(0);
    }

    @Test
    public void should_degrade_quality_twice_as_fast_when_sell_by_date_passed() {
        RegularItem[] items = new RegularItem[]{new RegularItem("foo", 1, 4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(3);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(1);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    public void should_never_decrease_quality_below_0() throws Exception {
        RegularItem[] items = new RegularItem[]{new RegularItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    public void should_increase_quality_of_aged_brie_with_age() throws Exception {
        AgedBrie[] items = new AgedBrie[]{new AgedBrie("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(2);
    }

    @Test
    public void should_never_increase_quality_above_50() throws Exception {
        AgedBrie[] items = new AgedBrie[]{new AgedBrie("Aged Brie", 0, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(50);
    }

    @Test
    public void should_never_decrease_quality_of_sulfuras() throws Exception {
        Sulfuras[] items = new Sulfuras[]{new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 42)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(42);
    }

    @Test
    public void should_increase_quality_of_backstage_passes_by_1() throws Exception {
        BackstagePass[] items = new BackstagePass[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 30, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(3);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(4);
    }

    @Test
    public void should_increase_quality_of_backstage_passes_by_2() throws Exception {
        BackstagePass[] items = new BackstagePass[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 10, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(4);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    public void should_increase_quality_of_backstage_passes_by_3() throws Exception {
        BackstagePass[] items = new BackstagePass[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(5);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    public void should_drop_quality_of_backstage_passes_to_0() throws Exception {
        BackstagePass[] items = new BackstagePass[]{new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(13);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
}
