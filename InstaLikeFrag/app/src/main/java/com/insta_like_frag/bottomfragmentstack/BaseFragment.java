package com.insta_like_frag.bottomfragmentstack;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.insta_like_frag.R;



public class BaseFragment extends Fragment {
        public static final String ARGS_INSTANCE = "com.insta_like_frag";

        public FragmentNavigation mFragmentNavigation;


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.act_base, container, false);
            return view;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof FragmentNavigation) {
                mFragmentNavigation = (FragmentNavigation) context;
            }
        }

        public interface FragmentNavigation {
            public void pushFragment(Fragment fragment);
        }
}
