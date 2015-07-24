package com.terry.materialsample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.HashSet;

public class HuanTextWatcher implements TextWatcher {

    ViewGroup container;
    View view;
    HuanItem item;

    HashSet<Integer> editorIds;

    public HuanTextWatcher(ViewGroup container,HuanItem item, View view, HashSet<Integer> editorIds) {
        this.container = container;
        this.item = item;
        this.view = view;
        this.editorIds = editorIds;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!view.isFocused()) return;

        //System.out.println(String.format("On text changed on: %s - %s", SourceItem.Id, s));

        int sourceId = view.getId();

        System.out.println(String.format("On text changed on %s in %s", s, view.getId()));
        if (s.length() > 0) {

            double value = Double.parseDouble(s.toString() + "0");

            for (Integer id : editorIds) {
                if (id != sourceId) {
//                    System.out.println(String.format("____________________id:%s sourceId: %s", id, sourceId));
//                    System.out.println(String.format("____________________find view by id:%s", container.findViewById(id)));
                    EditText editText = (EditText) container.findViewById(id);
                    editText.setText(String.valueOf(value));
                }
            }

        } else {
            for (Integer id : editorIds) {
                if (id != sourceId) {
                    EditText editText = (EditText) container.findViewById(id);
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
