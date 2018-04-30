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


public class FragThree extends BaseFragment {

    String TAG = "FragThree";

    public static FragThree  newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        FragThree fragment = new FragThree();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.tvTxt)
    TextView tvTxt;
    int mInt = 0;

    public FragThree() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_three, container, false);
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
                        mFragmentNavigation.pushFragment(FragThree.newInstance(mInt+1));
                    }
                }
            });
            tvTxt.setText("FragThree: " + mInt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
