package com.terry.materialsample;


public class LengthHuan extends Huan {

    public LengthHuan() {
        HuanItem huanItem_m = new HuanItem(1, "米", "m[<2>]", EqualTypeEnum.Equal, 1.0, "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
        HuanItem huanItem_cm = new HuanItem(2, "厘米", "cm", EqualTypeEnum.Equal, 0.01, "", true, false, "一米的百分之一");
        HuanItem huanItem_km = new HuanItem(3, "千米", "km", EqualTypeEnum.Equal, 1000.0, "", true, false, "一米的一千倍，也叫公里");

        HuanItem huanItem_li = new HuanItem(4, "里", "li", EqualTypeEnum.Equal, 500.0, "", true, false, "一里(150丈),500米");
        HuanItem huanItem_zhang = new HuanItem(5, "丈", "zhang", EqualTypeEnum.Equal, 3.33333, "", true, false, "10米/3");
        HuanItem huanItem_chi = new HuanItem(6, "尺", "chi", EqualTypeEnum.Equal, 0.3333333, "", true, false, "1米/3");
        HuanItem huanItem_cun = new HuanItem(7, "寸", "cun", EqualTypeEnum.Equal, 0.03333333, "", true, false, "1米/30(3.33厘米)");


        this.add(huanItem_m);
        this.add(huanItem_cm);
        this.add(huanItem_km);

        this.add(huanItem_li);
        this.add(huanItem_zhang);
        this.add(huanItem_chi);
        this.add(huanItem_cun);

    }
}
