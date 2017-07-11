package com.example.myaliapplication.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myaliapplication.fragment.BackHandledFragment;
import com.example.myaliapplication.fragment.BackHandledInterface;
import com.example.myaliapplication.fragment.FriendFragment;
import com.example.myaliapplication.fragment.HomeFragment;
import com.example.myaliapplication.fragment.KouBeiFragment;
import com.example.myaliapplication.fragment.MineFragment;
import com.example.myaliapplication.R;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity implements BackHandledInterface, View.OnClickListener {

    private FragmentManager fragmentManager;

    private BackHandledFragment[] fragments;

    private BackHandledFragment mBackHandedFragment;
    private LinearLayout ll_tab1, ll_tab2,ll_tab3, ll_tab4;
    private ImageView img_tab1, img_tab2, img_tab3, img_tab4;
    private TextView tv_tab1, tv_tab2, tv_tab3, tv_tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.alipayColor));
        fragmentManager = getSupportFragmentManager();
        fragments = new BackHandledFragment[] { new HomeFragment(),
                new KouBeiFragment(), new FriendFragment(), new MineFragment() };
        findView();
        img_tab1.setImageResource(R.drawable.shouye1);
        tv_tab1.setTextColor(ContextCompat.getColor(this, R.color.alipayColor));
        toTab(0);

    }

    private void findView() {
        ll_tab1 = (LinearLayout) findViewById(R.id.ll_tab1);
        ll_tab2 = (LinearLayout) findViewById(R.id.ll_tab2);
        ll_tab3 = (LinearLayout) findViewById(R.id.ll_tab3);
        ll_tab4 = (LinearLayout) findViewById(R.id.ll_tab4);
        img_tab1 = (ImageView) findViewById(R.id.img_tab1);
        img_tab2 = (ImageView) findViewById(R.id.img_tab2);
        img_tab3 = (ImageView) findViewById(R.id.img_tab3);
        img_tab4 = (ImageView) findViewById(R.id.img_tab4);
        tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
        tv_tab2 = (TextView) findViewById(R.id.tv_tab2);
        tv_tab3 = (TextView) findViewById(R.id.tv_tab3);
        tv_tab4 = (TextView) findViewById(R.id.tv_tab4);
        ll_tab1.setOnClickListener(this);
        ll_tab2.setOnClickListener(this);
        ll_tab3.setOnClickListener(this);
        ll_tab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_tab1:
                img_tab1.setImageResource(R.drawable.shouye1);
                tv_tab1.setTextColor(ContextCompat.getColor(this, R.color.alipayColor));
                img_tab2.setImageResource(R.drawable.koubei2);
                tv_tab2.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab3.setImageResource(R.drawable.pengyou2);
                tv_tab3.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab4.setImageResource(R.drawable.wode2);
                tv_tab4.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                toTab(0);
                break;
            case R.id.ll_tab2:
                img_tab1.setImageResource(R.drawable.shouye2);
                tv_tab1.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab2.setImageResource(R.drawable.koubei1);
                tv_tab2.setTextColor(ContextCompat.getColor(this, R.color.alipayColor));
                img_tab3.setImageResource(R.drawable.pengyou2);
                tv_tab3.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab4.setImageResource(R.drawable.wode2);
                tv_tab4.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                toTab(1);
                break;
            case R.id.ll_tab3:
                img_tab1.setImageResource(R.drawable.shouye2);
                tv_tab1.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab2.setImageResource(R.drawable.koubei2);
                tv_tab2.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab3.setImageResource(R.drawable.pengyou1);
                tv_tab3.setTextColor(ContextCompat.getColor(this, R.color.alipayColor));
                img_tab4.setImageResource(R.drawable.wode2);
                tv_tab4.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                toTab(2);
                break;
            case R.id.ll_tab4:
                img_tab1.setImageResource(R.drawable.shouye2);
                tv_tab1.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab2.setImageResource(R.drawable.koubei2);
                tv_tab2.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab3.setImageResource(R.drawable.pengyou2);
                tv_tab3.setTextColor(ContextCompat.getColor(this, R.color.gray_95));
                img_tab4.setImageResource(R.drawable.wode1);
                tv_tab4.setTextColor(ContextCompat.getColor(this, R.color.alipayColor));
                toTab(3);
                break;
        }
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
