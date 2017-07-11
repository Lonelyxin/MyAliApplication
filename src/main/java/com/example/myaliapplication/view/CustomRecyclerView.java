package com.example.myaliapplication.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by ha on 2017/7/8.
 */

public class CustomRecyclerView extends RecyclerView {
    private double scale; // 抛掷速度的缩放因子

    public CustomRecyclerView(Context context) {
        super(context);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setflingScale(double scale) {
        this.scale = scale;
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        velocityY *= scale;
        if (velocityY > 5000)
            velocityY = 5000;
        if (velocityY < -5000)
            velocityY = -5000;
        Log.i("liuxin", "fling velocityX is "+velocityX+", velocityY is " + velocityY);
        return super.fling(velocityX, velocityY);
    }
}
