package com.terry.materialsample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.terry.materialsample.QuickAdapter.BaseAdapterHelper;
import com.terry.materialsample.QuickAdapter.QuickAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HuanFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HuanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HuanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_GROUP = "group";
    private static final String ARG_ITEM = "item";

    // TODO: Rename and change types of parameters
    private String mGroup;
    private String mItem;

    private OnFragmentInteractionListener mListener;

    private QuickAdapter<HuanItem> adapter;

    private ListView lvHuanList;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param group Parameter 1.
     * @param item  Parameter 2.
     * @return A new instance of fragment HuanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HuanFragment newInstance(String group, String item) {
        HuanFragment fragment = new HuanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GROUP, group);
        args.putString(ARG_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    public HuanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGroup = getArguments().getString(ARG_GROUP);
            mItem = getArguments().getString(ARG_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_huan, container, false);

        TextView textView = (TextView) v.findViewById(R.id.titleOfHuanList);
        textView.setText(mItem + "换算列表");

        lvHuanList = (ListView) v.findViewById(R.id.lvHuanList);

        LoadHuanList();

        return v;
    }

    private void LoadHuanList() {
        final LengthHuan lengthHuan = new LengthHuan();

         adapter = new QuickAdapter<HuanItem>(this.getActivity(), R.layout.huan_item_layout) {
            @Override
            protected void convert(BaseAdapterHelper helper, HuanItem item) {
                helper.setText(R.id.item_name, item.ItemName)
                        .setText(R.id.item_value, String.valueOf(item.Value));
                EditText editTextValue = helper.getView(R.id.item_value);
                editTextValue.addTextChangedListener(new TextWatcher() {
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    public void onTextChanged(CharSequence s, int start, int before, int count) {}

                    public void afterTextChanged(Editable s) {
                        //System.out.println(s.toString() );
//                        for (Huan.HuanItem lItem:lengthHuan.ItemList){
//                            lItem.Value = Double.parseDouble(s.toString());
//                        }

                      //  Huan.HuanItem newItem = new Huan.HuanItem();




                        //adapter.notifyAll();
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };

        lvHuanList.setAdapter(adapter);
        adapter.addAll(lengthHuan.ItemList);
    }

    private void RefreshData(){

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
