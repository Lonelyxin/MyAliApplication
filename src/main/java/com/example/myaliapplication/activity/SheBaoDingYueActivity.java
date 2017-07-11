package com.example.myaliapplication.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;

public class SheBaoDingYueActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isShowImgX = false;
    private TextView tv_name, tv_personNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_bao_ding_yue);
        isShowImgX = getIntent().getBooleanExtra("isShowImgX", false);
        initView();
        initData();
    }

    private void initView() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("社保卡业务变动提醒订阅");
        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        ImageView img_x = (ImageView) findViewById(R.id.img_x);
        if (isShowImgX)
            img_x.setVisibility(View.VISIBLE);
        else
            img_x.setVisibility(View.GONE);
        img_x.setOnClickListener(this);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_personNum = (TextView) findViewById(R.id.tv_personNum);
    }

    private void initData() {
        tv_name.setText(MyApplication.getPersonInfo().getName());
        tv_personNum.setText(MyApplication.getPersonInfo().getPersonNum());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                if (isShowImgX) {
                    Intent intent = new Intent(this, SheBaoKaActivity1.class);
                    intent.putExtra("showImgX", true);
                    startActivity(intent);
                }
                finish();
                break;
            case R.id.img_x:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (isShowImgX) {
            Intent intent = new Intent(this, SheBaoKaActivity1.class);
            intent.putExtra("showImgX", true);
            startActivity(intent);
            finish();
        }
        super.onBackPressed();
    }
}
