package com.insta_like_frag.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.insta_like_frag.R;
import com.insta_like_frag.bottomfragmentstack.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragOne extends BaseFragment {

    String TAG = "FragOne";

    public static FragOne  newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        FragOne fragment = new FragOne();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.tvTxt) TextView tvTxt;
    int mInt = 0;

    public FragOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_one, container, false);
        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        if (args != null) {
            mInt = args.getInt(ARGS_INSTANCE);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try{

            initialize();

        }catch (Exception e){
            e.printStackTrace();
        }




    }



    public void initialize() {
        try {

            tvTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(FragOne.newInstance(mInt+1));
                    }
                }
            });
            tvTxt.setText("FragOne: " + mInt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
