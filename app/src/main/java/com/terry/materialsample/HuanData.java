package com.terry.materialsample;

import android.text.Html;

import java.math.BigDecimal;

public class HuanData {

    //长度
    public static class LengthHuan extends Huan {

        public LengthHuan() {
            HuanItem huanItem_m = new HuanItem("米", "m", EqualTypeEnum.Equal, new BigDecimal("1.0"), "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
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

    //面积
    public static class AreaHuan extends Huan {
        public AreaHuan() {
            HuanItem huanItem_m = new HuanItem("平方米", "m<small><sup>2</sup></small>", EqualTypeEnum.Equal, new BigDecimal("1.0"), "", true, true, "光在真空中1⁄299 792 458秒走过的距离（国际单位制基本单位）");
            HuanItem huanItem_cm = new HuanItem("平方厘米", "cm<small><sup>2</sup></small>", EqualTypeEnum.Equal, new BigDecimal("0.00001"), "", true, false, "0.01米");
            HuanItem huanItem_mm = new HuanItem("平方毫米", "mm<small><sup>2</sup></small>", EqualTypeEnum.Equal, new BigDecimal("0.000000001"), "", true, false, "0.001米");
            HuanItem huanItem_km = new HuanItem("平方千米", "km<small><sup>2</sup></small>", EqualTypeEnum.Equal, new BigDecimal("1000000.0"), "", true, false, "一百万平方米");

            this.add(huanItem_m);
            this.add(huanItem_cm);
            this.add(huanItem_mm);
            this.add(huanItem_km);
        }
    }

    //体积
    public static class VolumnHuan extends Huan {
        public VolumnHuan() {
            this.add(new HuanItem("立方米", "m<small><sup>3</sup></small>", EqualTypeEnum.Equal, new BigDecimal("1.0"), "", true, true, "1m x 1m x 1m的正方体的标准体积."));
            this.add(new HuanItem("升(立方分米)", "l", EqualTypeEnum.Equal, new BigDecimal("0.001"), "", true, false, "1/1000立方米"));
            this.add(new HuanItem("豪升(立方厘米)", "mml", EqualTypeEnum.Equal, new BigDecimal("0.001").multiply(new BigDecimal("0.001")), "", true, false, "1立方厘米，1/1000升"));

            this.add(new HuanItem("加仑(美)", "gal", EqualTypeEnum.Equal, new BigDecimal("0.001"), "", true, false, "1立方厘米，1/1000升"));
            this.add(new HuanItem("加仑(英)", "gal", EqualTypeEnum.Equal, new BigDecimal("0.001"), "", true, false, "1立方厘米，1/1000升"));

        }
    }

    public static class WeightHuan extends Huan {
        public WeightHuan() {
            this.add(new HuanItem("千克", "kg", EqualTypeEnum.Full, new BigDecimal("1.0"), "", true, true, "约等于常温下一升纯净水的质量"));
            this.add(new HuanItem("克", "g", EqualTypeEnum.Full, new BigDecimal("0.001"), "", true, false, "1克的千分之一"));
            this.add(new HuanItem("磅(pound)", "lb", EqualTypeEnum.Full, new BigDecimal("0.45359237"), "", true, false, "0.45359237千克"));
            this.add(new HuanItem("盎司", "oz av", EqualTypeEnum.Full, new BigDecimal("0.001").multiply(new BigDecimal("28.349523125")), "", true, false, "1/16 磅"));
        }
    }

    public static class DataStorageHuan extends Huan {
        public DataStorageHuan() {
            this.add(new HuanItem("比特", "b", EqualTypeEnum.Full,         new BigDecimal("1.0"), "", true, true, "1比特"));
            this.add(new HuanItem("字节", "B", EqualTypeEnum.Full,         new BigDecimal("8"), "", true, false, "一个字节等于8个比特"));
            this.add(new HuanItem("千字节", "KB", EqualTypeEnum.Full,      new BigDecimal("8").multiply(new BigDecimal("1024")), "", true, false, "1024个字节"));
            this.add(new HuanItem("兆字节", "MB", EqualTypeEnum.Full,      new BigDecimal("8").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")), "", true, false, "1024<small><sup>2</sup></small>个字节"));
            this.add(new HuanItem("千兆字节", "GB", EqualTypeEnum.Full,    new BigDecimal("8").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")), "", true, false, "1024<small><sup>3</sup></small>个字节"));
            this.add(new HuanItem("太字节", "TB", EqualTypeEnum.Full,      new BigDecimal("8").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")), "", true, false, "1024<small><sup>4</sup></small>个字节"));
            this.add(new HuanItem("拍字节", "PB", EqualTypeEnum.Full,      new BigDecimal("8").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")), "", true, false, "1024<small><sup>5</sup></small>个字节"));
            this.add(new HuanItem("艾字节", "EB", EqualTypeEnum.Full,      new BigDecimal("8").multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")).multiply(new BigDecimal("1024")), "", true, false, "1024<small><sup>6</sup></small>个字节"));
        }
    }
}