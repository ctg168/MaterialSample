package com.terry.materialsample;

import java.math.BigDecimal;

/**
 * Created by terry on 2015/7/17.
 */
public class HuanItem {

    public HuanItem() {}

    public int EditorId;

    public CharSequence Id;
    public boolean IsSI;           //是否SI单位
    public String ItemName;        //名称
    public String Symbol;          //符号
    public String ItemDesc;        //描述和定义
    public BigDecimal formula;         //换算公式
    public String formulaDesc;     //换算描述
    public boolean IsCommon;       //是否常用
    public EqualTypeEnum EqualType;   //等于类型
    public BigDecimal Value;              //计算出的值

    public HuanItem(String itemName, String symbol, EqualTypeEnum equalType, BigDecimal formula, String formulaDesc, boolean isCommon, boolean isSI, String itemDesc) {
        this.EqualType = equalType;
        this.formula = formula;
        this.formulaDesc = formulaDesc;
        this.IsCommon = isCommon;
        this.IsSI = isSI;
        this.ItemDesc = itemDesc;
        this.ItemName = itemName;
        this.Symbol = symbol;
    }
}
