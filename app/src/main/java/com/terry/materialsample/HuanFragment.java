package com.terry.materialsample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;

public class HuanFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_GROUP = "group";
    private static final String ARG_ITEM = "item";

    // TODO: Rename and change types of parameters
    private String mGroup;
    private String mItem;

    private Huan CurrentHuan;


    private OnFragmentInteractionListener mListener;
    private LinearLayout lstMain;

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

    public void LoadData() {
        System.out.println("HuanFragment.LoadData");
        if (mItem.equals(getResources().getString(R.string.menu_huan_title_01))) {
            CurrentHuan = new HuanData.LengthHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_blue);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_02))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_green);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_03))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_green_dark);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_04))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_blue_dark);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_05))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_orange);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_06))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_orange_dark);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_07))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_purple);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_08))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_purple_dark);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_09))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_red);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_10))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.app_red_dark);
        } else if (mItem.equals(getResources().getString(R.string.menu_huan_title_11))) {
            CurrentHuan = new HuanData.AreaHuan();
            CurrentThemeColor = getResources().getColor(R.color.md_light_blue_600);
        } else {
            CurrentHuan = new HuanData.LengthHuan();
            CurrentThemeColor = getResources().getColor(R.color.md_light_green_600);
        }
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
        LoadItemList();

        if (mListener != null) {
            mListener.onFragmentInteraction(HuanFragment.this);
            System.out.println("mListener.onFragmentInteraction(HuanFragment.this) & HuanFragment.onCreate");
        }
        return v;
    }

    private void LoadItemList() {
        System.out.println("HuanFragment.LoadItemList");

        LoadData();

        int editorId = CurrentHuan.getTypeId();


        for (HuanItem item : CurrentHuan) {

            CardView cardView = (CardView) LayoutInflater.from(this.getActivity()).inflate(R.layout.huan_item_layout, lstMain, false);

            TextView textView = (TextView) cardView.findViewById(R.id.item_name);
            textView.setText(item.ItemName);
            textView.setTextColor(this.CurrentThemeColor);

            HuanItemEditText editText = (HuanItemEditText) cardView.findViewById(R.id.item_value_editor);
            editText.setEditItem(item);
            editText.setText(String.valueOf(BigDecimal.ZERO));
            editText.setTextColor(getResources().getColor(R.color.md_grey_600));

            item.EditorId = ++editorId;
            editText.setId(item.EditorId);

            HuanTextWatcher watcher = new HuanTextWatcher(lstMain, item, editText, CurrentHuan);

            editText.addTextChangedListener(watcher);

//            Animation animation = new TranslateAnimation(200,0,0,0);
//            animation.setDuration(100);
//            animation.setFillAfter(true);
//            cardView.setAnimation(animation);
//            animation.startNow();

            lstMain.addView(cardView);


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
        public void onFragmentInteraction(HuanFragment sender);
    }

}
