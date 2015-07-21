package com.terry.materialsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class HuanItemRecyclerViewAdapter extends RecyclerView.Adapter<HuanItemRecyclerViewAdapter.ViewHolder> {
    public ArrayList<HuanItem> mDataset;

    public HuanItemRecyclerViewAdapter(ArrayList<HuanItem> mDataset) {
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName;
        public EditText mItemValue;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.item_name);
            mItemValue = (EditText) itemView.findViewById(R.id.item_value);
        }
    }


    @Override
    public HuanItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                                     int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.huan_item_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the content of a view(invoked by the layout manager)
    @Override
    public void onBindViewHolder(HuanItemRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        HuanItem item = mDataset.get(position);
        viewHolder.mItemName.setText(item.ItemName);
        viewHolder.mItemValue.setText(String.valueOf(item.Value));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
