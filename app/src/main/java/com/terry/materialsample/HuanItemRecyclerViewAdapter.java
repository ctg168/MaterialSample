package com.terry.materialsample;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class HuanItemRecyclerViewAdapter extends RecyclerView.Adapter<HuanItemRecyclerViewAdapter.ViewHolder> {
    public ArrayList<HuanItem> mDataset;
    public TextChangedListener textChangedListener;


    public HuanItemRecyclerViewAdapter(ArrayList<HuanItem> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public HuanItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.huan_item_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the content of a view(invoked by the layout manager)
    @Override
    public void onBindViewHolder(final HuanItemRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        final HuanItem item = mDataset.get(position);
        viewHolder.mItemName.setText(item.ItemName);
        viewHolder.mItemValue.setText(String.valueOf(item.Value));

        viewHolder.mItemValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (viewHolder.mItemValue.hasFocus()) {
                    if (textChangedListener != null) {
                        textChangedListener.OnTextChanged(viewHolder.mItemValue);
                    }

                }

                if (s.length() > 0) {
                    for (HuanItem sitem : mDataset) {
                        if (!sitem.equals(item)) {
                            sitem.Value = Double.parseDouble(s.toString()) / sitem.formula;
                        } else {
                            sitem.Value = Double.parseDouble(s.toString());
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


//        viewHolder.mItemValue.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    EditText editText = (EditText) v;
//                    editText.selectAll();
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public EditText mItemValue;

        private boolean onBind;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.item_name);
            mItemValue = (EditText) itemView.findViewById(R.id.item_value);
        }
    }

    public interface TextChangedListener {
        void OnTextChanged(EditText mItemValue);
    }

    //public class MyTextWatcher implements TextWatcher {
//
//        public TextChangedListener mItemChangedListener;
//
//        public MyTextWatcher(TextChangedListener itemChangedListener, ArrayList<HuanItem> mDataSet, EditText mEditText) {
//            this.mItemChangedListener = itemChangedListener;
//            this.mDataSet = mDataSet;
//            this.mEditText = mEditText;
//        }
//
//        private EditText mEditText;
//        private ArrayList<HuanItem> mDataSet;
//
//
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if (s.length() > 0) {
//                for (HuanItem item : this.mDataSet) {
//
//
//                }
//            }
//
//
//            if (mEditText.hasFocus()) {
//                if (mItemChangedListener != null) {
//                    mItemChangedListener.TextChanged(mEditText);
//                }
//            }
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
    //}
}
