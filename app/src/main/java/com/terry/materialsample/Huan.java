package com.terry.materialsample;

import java.util.ArrayList;


public abstract class Huan extends ArrayList<HuanItem> {
    protected HuanItem ISItem;

    public int getTypeId() {
        return 10000;
    }

    private int TypeId;
    private String ObjectName;

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public HuanItem getISItem() {
        for (HuanItem item : this) {
            if (item.IsSI) return item;
        }
        throw new RuntimeException("没有标准单位!");
    }
}



