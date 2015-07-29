package com.terry.materialsample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by terry on 2015/7/29.
 */
public class HuanItemEditText extends android.support.v7.widget.AppCompatEditText {
    private HuanItem EditItem;

    public HuanItemEditText(Context context) {
        super(context);
    }

    public HuanItemEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HuanItemEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HuanItem getEditItem() {
        return EditItem;
    }

    public void setEditItem(HuanItem editItem) {
        EditItem = editItem;
    }
}
