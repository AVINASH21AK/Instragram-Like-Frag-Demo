package com.insta_like_frag.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.insta_like_frag.R;
import com.insta_like_frag.bottomfragmentstack.BaseFragment;
import com.insta_like_frag.bottomfragmentstack.FragNavController;
import com.insta_like_frag.bottomfragmentstack.FragNavSwitchController;
import com.insta_like_frag.bottomfragmentstack.FragNavTransactionOptions;
import com.insta_like_frag.bottomfragmentstack.tabhistory.FragNavTabHistoryController;
import com.insta_like_frag.fragments.FragFive;
import com.insta_like_frag.fragments.FragFour;
import com.insta_like_frag.fragments.FragOne;
import com.insta_like_frag.fragments.FragThree;
import com.insta_like_frag.fragments.FragTwo;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;


public class ActDashboard extends AppCompatActivity implements  BaseFragment.FragmentNavigation, FragNavController.TransactionListener, FragNavController.RootFragmentListener{

    private final int INDEX_RECENTS = FragNavController.TAB1;
    private final int INDEX_FAVORITES = FragNavController.TAB2;
    private final int INDEX_NEARBY = FragNavController.TAB3;
    private final int INDEX_FRIENDS = FragNavController.TAB4;
    private final int INDEX_FOOD = FragNavController.TAB5;
    private BottomBar mBottomBar;
    private FragNavController mNavController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dashboard);
        //ViewGroup.inflate(this, R.layout.act_dashboard, ll_SubMainContainer);



        mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        boolean initial = savedInstanceState == null;
        if (initial) {
            mBottomBar.selectTabAtPosition(INDEX_RECENTS);
        }





        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.content_frame)
                .transactionListener(this)
                .rootFragmentListener(this, 5)
                .popStrategy(FragNavTabHistoryController.UNIQUE_TAB_HISTORY)
                .switchController(new FragNavSwitchController() {
                    @Override
                    public void switchTab(int index, FragNavTransactionOptions transactionOptions) {
                        mBottomBar.selectTabAtPosition(index);
                    }
                })
                .build();

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        mNavController.switchTab(INDEX_RECENTS);
                        break;
                    case R.id.tab_heartbeat:
                        mNavController.switchTab(INDEX_FAVORITES);
                        break;
                    case R.id.tab_phone:
                        mNavController.switchTab(INDEX_NEARBY);
                        break;
                    case R.id.tab_search:
                        mNavController.switchTab(INDEX_FRIENDS);
                        break;
                    case R.id.tab_menu:
                        mNavController.switchTab(INDEX_FOOD);
                        break;
                }
            }
        });

        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                mNavController.clearStack();
            }
        });
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }

    @Override
    public void onTabTransaction(Fragment fragment, int index) {
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        }
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {
            case INDEX_RECENTS:
                return FragOne.newInstance(0);
            case INDEX_FAVORITES:
                return FragTwo.newInstance(0);
            case INDEX_NEARBY:
                return FragThree.newInstance(0);
            case INDEX_FRIENDS:
                return FragFour.newInstance(0);
            case INDEX_FOOD:
                return FragFive.newInstance(0);
        }
        throw new IllegalStateException("Need to send an index that we know");
    }



    @Override
    public void onBackPressed() {
        if (!mNavController.popFragment()) {
            super.onBackPressed();
        }
    }

}
