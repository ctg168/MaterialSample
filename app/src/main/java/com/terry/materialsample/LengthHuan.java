package com.terry.materialsample;

import java.util.ArrayList;


public class LengthHuan extends Huan {

    private HuanItem ISItem;

    public LengthHuan() {
        ItemList = new ArrayList<HuanItem>();
        HuanItem huanItem_m = new HuanItem("米", "m", EqualTypeEnum.Equal, 1.0, "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
        HuanItem huanItem_cm = new HuanItem("厘米", "cm", EqualTypeEnum.Equal, 0.01, "", true, false, "一米的百分之一");
        HuanItem huanItem_km = new HuanItem("千米", "km", EqualTypeEnum.Equal, 1000.0, "", true, false, "一米的一千倍");

        ItemList.add(huanItem_m);
        ItemList.add(huanItem_cm);
        ItemList.add(huanItem_km);

        ISItem = SetISItem();
    }

    public HuanItem SetISItem() {
        for (HuanItem item : ItemList) {
            if (item.IsSI) return item;
        }
        throw new RuntimeException("must have one SI item");
    }

    private void Assign(HuanItem sourceItem) {
        ISItem.Value = sourceItem.Value * sourceItem.formula;

        for (HuanItem item : ItemList) {
            if(!item.IsSI) {
                item.Value = ISItem.Value * item.formula;
            }
        }

    }
}
