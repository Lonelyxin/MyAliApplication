package com.example.myaliapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.myaliapplication.R;

public class LauncherActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        countTime(this);
    }

    /**
     * 给传入的色值设置透明度，返回带有透明度的新色值
     *
     * @param alphaRatio 透明系数
     * @param color      色值
     * @return 带有透明度的新色值
     */
    private int getAlphaColor(double alphaRatio, int color) {
        int hxRatio = ((int) (255 * alphaRatio) << 24) | 0x00ffffff;
        return color & hxRatio;
    }

    @Override
    public void onClick(View v) {
    }

    public void countTime(final Context context) {
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                context.startActivity(new Intent(context, MainActivity.class));
                finish();
            }
        }.start();
    }

}
