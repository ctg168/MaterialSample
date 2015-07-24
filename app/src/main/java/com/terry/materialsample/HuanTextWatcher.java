package com.terry.materialsample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;

public class HuanTextWatcher implements TextWatcher {

    ViewGroup container;
    View Sender;
    HuanItem SourceItem;
    Huan ItemSet;

    DecimalFormat decimalFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
    DecimalFormatSymbols symbols = decimalFormatter.getDecimalFormatSymbols();

    public HuanTextWatcher(ViewGroup container, HuanItem sourceItem, View sender, Huan itemSet) {
        this.container = container;
        this.SourceItem = sourceItem;
        this.Sender = sender;
        this.ItemSet = itemSet;

        symbols.setGroupingSeparator(',');
        decimalFormatter.setDecimalFormatSymbols(symbols);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!Sender.isFocused()) return;

        int sourceId = Sender.getId();

        System.out.println(String.format("On text changed on %s in %s", s, Sender.getId()));
        if (s.length() > 0) {
            double TargetValue = Double.parseDouble(s.toString());
            for (HuanItem item : ItemSet) {
                if (item.EditorId != sourceId) {

                    EditText editText = (EditText) container.findViewById(item.EditorId);
                    // editText.setText(String.format("%,.2f", String.valueOf(TargetValue / item.formula)));
                    editText.setText(decimalFormatter.format(TargetValue / item.formula));
                }
            }
        } else {
            for (HuanItem item : ItemSet) {
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
