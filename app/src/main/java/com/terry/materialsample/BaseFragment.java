package com.terry.materialsample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {
    public int CurrentThemeColor;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("Terry.BaseFragment.onActivityResult");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("Terry.BaseFragment.onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Terry.BaseFragment.onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("Terry.BaseFragment.onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        System.out.println("Terry.BaseFragment.onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        System.out.println("Terry.BaseFragment.onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        System.out.println("Terry.BaseFragment.onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        System.out.println("Terry.BaseFragment.onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        System.out.println("Terry.BaseFragment.onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        System.out.println("Terry.BaseFragment.onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        System.out.println("Terry.BaseFragment.onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        System.out.println("Terry.BaseFragment.onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyOptionsMenu() {
        System.out.println("Terry.BaseFragment.onDestroyOptionsMenu");
        super.onDestroyOptionsMenu();
    }
}
