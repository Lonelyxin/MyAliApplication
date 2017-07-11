package com.example.myaliapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;

public class SheBaoStatusActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isShowImgX = false;
    private TextView tv_name, tv_personNum, tv_shebaonNum,
            tv_danweiNum, tv_danweiName, tv_canbaostatus, tv_shebaostatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_bao_status);
        isShowImgX = getIntent().getBooleanExtra("isShowImgX", false);
        initView();
        initData();
    }

    private void initView() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("社保卡状态");

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
        tv_shebaonNum = (TextView) findViewById(R.id.tv_shebaonNum);
        tv_danweiNum = (TextView) findViewById(R.id.tv_danweiNum);
        tv_danweiName = (TextView) findViewById(R.id.tv_danweiName);
        tv_canbaostatus = (TextView) findViewById(R.id.tv_canbaostatus);
        tv_shebaostatus = (TextView) findViewById(R.id.tv_shebaostatus);
    }

    private void initData() {
        tv_name.setText(MyApplication.getPersonInfo().getName());
        tv_personNum.setText(MyApplication.getPersonInfo().getPersonNum());
        tv_shebaonNum.setText(MyApplication.getPersonInfo().getCardNum());
        tv_danweiName.setText(MyApplication.getPersonInfo().getDanweiName());
        tv_danweiNum.setText(MyApplication.getPersonInfo().getDanweiNum());
        tv_canbaostatus.setText(MyApplication.getPersonInfo().getCanbaostatus());
        tv_shebaostatus.setText(MyApplication.getPersonInfo().getStatus());
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
