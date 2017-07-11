package com.example.myaliapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.R;

public class ZhengZhouSheBaoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zheng_zhou_she_bao);
        initView();
    }

    private void initView() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("城市服务");
        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        ImageView iv_shenglue = (ImageView) findViewById(R.id.iv_shenglue);
        iv_shenglue.setVisibility(View.INVISIBLE);

        View ll_shebaozhuye = findViewById(R.id.ll_shebaozhuye);
        View ll_shebaoyue = findViewById(R.id.ll_shebaoyue);
        View ll_yanglao = findViewById(R.id.ll_yanglao);
        View ll_shiye = findViewById(R.id.ll_shiye);
        View ll_guashi = findViewById(R.id.ll_guashi);
        View ll_dingyue = findViewById(R.id.ll_dingyue);
        View ll_zhuangtai = findViewById(R.id.ll_zhuangtai);
        View ll_buka = findViewById(R.id.ll_buka);

        ll_shebaoyue.setOnClickListener(this);
        ll_yanglao.setOnClickListener(this);
        ll_shiye.setOnClickListener(this);
        ll_guashi.setOnClickListener(this);
        ll_dingyue.setOnClickListener(this);
        ll_zhuangtai.setOnClickListener(this);
        ll_shebaozhuye.setOnClickListener(this);
        ll_buka.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.ll_shebaoyue://医保余额查询
                startActivity(new Intent(this, YiBaoActivity.class));
                break;
            case R.id.ll_yanglao:// 养老保险查询
                startActivity(new Intent(this, RetirementActivity.class));
                break;
            case R.id.ll_shiye:// 失业保险查询
                startActivity(new Intent(this, UnemploymentInsuranceActivity.class));
                break;
            case R.id.ll_guashi:// 社保挂失
                startActivity(new Intent(this, SheBaoGuaShiActivity.class));
                break;
            case R.id.ll_dingyue:// 业务变动提醒订阅
                startActivity(new Intent(this, SheBaoDingYueActivity.class));
                break;
            case R.id.ll_zhuangtai://社保状态
                startActivity(new Intent(this, SheBaoStatusActivity.class));
                break;
            case R.id.ll_shebaozhuye://跳转到社保卡服务
                startActivity(new Intent(this, SheBaoKaActivity1.class));
                break;
            case R.id.ll_buka://社保卡补卡缴费
                startActivity(new Intent(this, BuKaNoticeActivity.class));
                break;
        }
    }
}
