package com.terry.materialsample;


public class LengthHuan extends Huan {

    public LengthHuan() {
        HuanItem huanItem_m = new HuanItem("米", "m[<2>]", EqualTypeEnum.Equal, 1.0, "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
        HuanItem huanItem_cm = new HuanItem("厘米", "cm", EqualTypeEnum.Equal, 0.01, "", true, false, "一米的百分之一");
        HuanItem huanItem_km = new HuanItem("千米", "km", EqualTypeEnum.Equal, 1000.0, "", true, false, "一米的一千倍");

        this.add(huanItem_m);
        this.add(huanItem_cm);
        this.add(huanItem_km);
    }
}
