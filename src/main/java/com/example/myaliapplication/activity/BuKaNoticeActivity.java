package com.example.myaliapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;

public class BuKaNoticeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bu_ka_notice);
        initView();
    }

    private void initView() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("提醒");
        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        ImageView iv_shenglue = (ImageView) findViewById(R.id.iv_shenglue);
        iv_shenglue.setVisibility(View.INVISIBLE);

        tv_notice = (TextView) findViewById(R.id.tv_notice);
        tv_notice.setText("身份证号是:");
        tv_notice.append(MyApplication.getPersonInfo().getPersonNum());
        tv_notice.append("的用户，\n社保卡不是挂失状态，请先进行挂失操作");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
