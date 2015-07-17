package com.terry.materialsample;


import java.util.ArrayList;
import java.util.List;

public abstract class Huan extends ArrayList<HuanItem> {
    private String ObjectName;
    public List<HuanItem> ItemList;

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

}


