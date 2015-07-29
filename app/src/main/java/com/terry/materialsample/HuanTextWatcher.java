package com.terry.materialsample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;

public class HuanTextWatcher implements TextWatcher {

    ViewGroup container;
    HuanItemEditText Sender;
    HuanItem SourceItem;
    HuanItem ISHuanItem;
    Huan mHuan;


    DecimalFormat decimalFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.CHINESE);
    //DecimalFormat decimalFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
    DecimalFormatSymbols symbols = decimalFormatter.getDecimalFormatSymbols();

    public HuanTextWatcher(ViewGroup container, HuanItem sourceItem, HuanItemEditText sender, Huan itemSet) {
        this.container = container;
        this.SourceItem = sourceItem;
        this.Sender = sender;
        this.mHuan = itemSet;

        this.ISHuanItem = mHuan.getISItem();

        symbols.setGroupingSeparator(',');
        decimalFormatter.setDecimalFormatSymbols(symbols);
        decimalFormatter.setMaximumFractionDigits(10);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!Sender.isFocused()) return;
        int sourceId = Sender.getId();
        SourceItem = Sender.getEditItem(); //编辑项

        System.out.println(String.format("On text changed on %s in %s", s, Sender.getId()));
        if (s.length() > 0) {

            //文本值转换成标准值
            BigDecimal StdValue = new BigDecimal(s.toString()).multiply(SourceItem.formula);

            for (HuanItem item : mHuan) {
                if (item.EditorId != sourceId) {
                    BigDecimal rValue = StdValue.divide(item.formula, 10, BigDecimal.ROUND_HALF_EVEN);
                    String aValue = decimalFormatter.format(rValue);

                    EditText editText = (EditText) container.findViewById(item.EditorId);
                    // editText.setText(String.format("%,.2f", String.valueOf(TargetValue / item.formula)));
                    editText.setText(aValue);
                }
            }
        } else {
            for (HuanItem item : mHuan) {
                if (item.EditorId != sourceId) {
                    EditText editText = (EditText) container.findViewById(item.EditorId);
                    editText.setText("");
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        System.out.println(String.format("After text changed on %s", s));
    }


}
