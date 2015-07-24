package com.terry.materialsample;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class HuanFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_GROUP = "group";
    private static final String ARG_ITEM = "item";

    // TODO: Rename and change types of parameters
    private String mGroup;
    private String mItem;

    private Huan huan;


    private OnFragmentInteractionListener mListener;


    private LinearLayout lstMain;


    private Button btnTest;


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
        View v = inflater.inflate(R.layout.fragment_huan, container, false);

        lstMain = (LinearLayout) v.findViewById(R.id.listMain);

        LoadItemList(inflater);


        return v;
    }

    private void LoadItemList(LayoutInflater inflater) {
        huan = new LengthHuan();

        int editorId = 55550;

        HashSet<Integer> editIds = new HashSet<>();

        for (HuanItem item : huan) {
            CardView cardView = (CardView) inflater.inflate(R.layout.huan_item_layout, lstMain, false);

            TextView textView = (TextView) cardView.findViewById(R.id.item_name);
            textView.setText(item.ItemName);

            EditText editText = (EditText) cardView.findViewById(R.id.item_value_editor);
            editText.setText(String.valueOf(item.Value));

            item.EditorId = ++editorId;
            editText.setId(item.EditorId);
            editIds.add(item.EditorId);

            lstMain.addView(cardView);
        }

        for (HuanItem item : huan) {
            EditText editText = (EditText) lstMain.findViewById(item.EditorId);
            if (editText != null) {
                HuanTextWatcher watcher = new HuanTextWatcher(lstMain,item, editText, editIds);
                editText.addTextChangedListener(watcher);
            }
            else
            {
                throw new RuntimeException("not found!!");
            }
        }
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
