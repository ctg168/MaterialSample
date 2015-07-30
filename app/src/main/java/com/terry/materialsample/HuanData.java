package com.terry.materialsample;

import java.math.BigDecimal;

public class HuanData {

    public static class LengthHuan extends Huan {

        public LengthHuan() {
            HuanItem huanItem_m = new HuanItem("米", "m[<2>]", EqualTypeEnum.Equal, new BigDecimal("1.0"), "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
            HuanItem huanItem_cm = new HuanItem("厘米", "cm", EqualTypeEnum.Equal, new BigDecimal("0.01"), "", true, false, "0.01米");
            HuanItem huanItem_mm = new HuanItem("毫米", "li", EqualTypeEnum.Equal, new BigDecimal("0.001"), "", true, false, "0.001米");
            HuanItem huanItem_km = new HuanItem("千米", "km", EqualTypeEnum.Equal, new BigDecimal("1000.0"), "", true, false, "一米的一千倍，也叫公里");
            HuanItem huanItem_li = new HuanItem("里", "li", EqualTypeEnum.Equal, new BigDecimal("500.0"), "", true, false, "一里(150丈),500米");


            HuanItem huanItem_chi = new HuanItem("尺", "chi", EqualTypeEnum.Full, huanItem_m.formula.divide(new BigDecimal("3.0"), 100, BigDecimal.ROUND_HALF_EVEN), "", true, false, "1米/3");
            HuanItem huanItem_zhang = new HuanItem("丈", "zhang", EqualTypeEnum.Full, huanItem_chi.formula.multiply(new BigDecimal("10.0")), "", true, false, "10米/3");
            HuanItem huanItem_cun = new HuanItem("寸", "cun", EqualTypeEnum.Full, huanItem_chi.formula.divide(new BigDecimal("10.0"), 100, BigDecimal.ROUND_HALF_EVEN), "", true, false, "1米/30(3.33厘米)");

            HuanItem huanItem_yd = new HuanItem("码", "yd", EqualTypeEnum.Full, new BigDecimal("0.9144"), "", true, false, "0.9144米");
            HuanItem huanItem_ft = new HuanItem("英尺", "ft", EqualTypeEnum.Full, new BigDecimal("0.3048"), "", true, false, "0.3048米");
            HuanItem huanItem_in = new HuanItem("英寸", "in", EqualTypeEnum.Full, new BigDecimal("0.0254"), "", true, false, "0.0254米");


            this.add(huanItem_m);
            this.add(huanItem_cm);
            this.add(huanItem_mm);
            this.add(huanItem_km);
            this.add(huanItem_li);

            this.add(huanItem_zhang);
            this.add(huanItem_chi);
            this.add(huanItem_cun);

            this.add(huanItem_yd);
            this.add(huanItem_ft);
            this.add(huanItem_in);
        }
    }

    public static class AreaHuan extends Huan {
        public AreaHuan() {
            HuanItem huanItem_m =  new HuanItem("平方米", "m[<2>]", EqualTypeEnum.Equal, new BigDecimal("1.0"), "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
            HuanItem huanItem_cm = new HuanItem("平方厘米", "cm", EqualTypeEnum.Equal, new BigDecimal("0.00001"), "", true, false, "0.01米");
            HuanItem huanItem_mm = new HuanItem("平方毫米", "li", EqualTypeEnum.Equal, new BigDecimal("0.000000001"), "", true, false, "0.001米");
            HuanItem huanItem_km = new HuanItem("平方千米", "km", EqualTypeEnum.Equal, new BigDecimal("1000000.0"), "", true, false, "一百万平方米");

            this.add(huanItem_m);
            this.add(huanItem_cm);
            this.add(huanItem_mm);
            this.add(huanItem_km);
        }
    }

}