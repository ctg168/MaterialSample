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
    DecimalFormatSymbols symbols = decimalFormatter.getDecimalFormatSymbols();

    public HuanTextWatcher(ViewGroup container, HuanItem sourceItem, HuanItemEditText sender, Huan itemSet) {
        this.container = container;
        this.SourceItem = sourceItem;
        this.Sender = sender;
        this.mHuan = itemSet;

        this.ISHuanItem = mHuan.getISItem();

        symbols.setGroupingSeparator(',');
        decimalFormatter.setDecimalFormatSymbols(symbols);
        decimalFormatter.setMaximumFractionDigits(100);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!Sender.isFocused()) return;
        int sourceId = Sender.getId();
        SourceItem = Sender.getEditItem(); //编辑项

        if (s.length() > 0) {

            //文本值转换成标准值
            BigDecimal StdValue = new BigDecimal(s.toString().replace(",", "")).multiply(SourceItem.formula);


            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.CHINESE);
            decimalFormat.setMaximumFractionDigits(50);
            String x1 = decimalFormat.format(StdValue);


            for (HuanItem item : mHuan) {
                if (item.EditorId != sourceId) {
                    BigDecimal aValue = StdValue.divide(item.formula, 50, BigDecimal.ROUND_HALF_EVEN);
                    //BigDecimal bValue = StdValue.divide(item.formula, RoundingMode.HALF_EVEN);

                    String rValue = decimalFormat.format(aValue);

                    EditText editText = (EditText) container.findViewById(item.EditorId);
                    editText.setText(rValue);
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
    public void afterTextChanged(Editable s) {}
}
