package com.example.myaliapplication.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.myaliapplication.fragment.BackHandledFragment;
import com.example.myaliapplication.fragment.BackHandledInterface;
import com.example.myaliapplication.fragment.FriendFragment;
import com.example.myaliapplication.fragment.HomeFragment;
import com.example.myaliapplication.fragment.KouBeiFragment;
import com.example.myaliapplication.fragment.MineFragment;
import com.example.myaliapplication.R;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements BackHandledInterface {

    private FragmentManager fragmentManager;

    private BackHandledFragment[] fragments;

    private BackHandledFragment mBackHandedFragment;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.alipayColor));
        fragmentManager = getSupportFragmentManager();
        fragments = new BackHandledFragment[]{new HomeFragment(),
                new KouBeiFragment(), new FriendFragment(), new MineFragment()};
        initView();
        toTab(0);
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void toTab(int index) {
        fragmentManager.beginTransaction()
                .replace(R.id.layout_containers, fragments[index]).commit();
    }

    @Override
    public void setSelectedFragment(BackHandledFragment selectedFragment) {

    }

    private long exitTime = 0;
    @Override
    public void onBackPressed() {
        /*if (mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                if (System.currentTimeMillis() - exitTime > 2000) {
                    Toast.makeText(this, "再次按返回键退出应用", Toast.LENGTH_SHORT);
                    exitTime = System.currentTimeMillis();
                }
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }*/
        // do nothing
        finish();
    }
}
