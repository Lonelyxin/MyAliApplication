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
import android.widget.Toast;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;

public class SheBaoKaActivity1 extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private ImageView img_back, img_x;
    private View ll_item1, ll_item2, ll_item3, ll_item4,
            ll_item5, ll_item6, ll_item7, ll_item8;

    private boolean showImgX = false;
    private String personNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_bao_ka1);
        showImgX = getIntent().getBooleanExtra("showImgX", false);
        initView();
        initData();
        initDialog();
    }

    private void initView() {
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("社保卡服务");
        img_back = (ImageView) findViewById(R.id.img_back);
        img_x = (ImageView) findViewById(R.id.img_x);
        if (showImgX)
            img_x.setVisibility(View.VISIBLE);
        else
            img_x.setVisibility(View.GONE);
        ll_item1 = findViewById(R.id.ll_item1);
        ll_item2 = findViewById(R.id.ll_item2);
        ll_item3 = findViewById(R.id.ll_item3);
        ll_item4 = findViewById(R.id.ll_item4);
        ll_item5 = findViewById(R.id.ll_item5);
        ll_item6 = findViewById(R.id.ll_item6);
        ll_item7 = findViewById(R.id.ll_item7);
        ll_item8 = findViewById(R.id.ll_item8);

        img_back.setOnClickListener(this);
        img_x.setOnClickListener(this);
        ll_item1.setOnClickListener(this);
        ll_item2.setOnClickListener(this);
        ll_item3.setOnClickListener(this);
        ll_item5.setOnClickListener(this);
        ll_item6.setOnClickListener(this);
        ll_item7.setOnClickListener(this);
        ll_item8.setOnClickListener(this);
    }

    private void initData() {
        personNum = MyApplication.getPersonInfo().getPersonNum();
    }

    public void initDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        final View dialogView = layoutInflater.inflate(R.layout.layout_dialog, null);
        TextView tv_notice = (TextView) dialogView.findViewById(R.id.tv_notice);
        tv_notice.setText("身份证号是：");
        tv_notice.append(personNum);
        tv_notice.append("的用户，\n社保卡不是挂失状态，请先进行挂失操作");
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ll_item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                View tv_confirm = dialogView.findViewById(R.id.tv_confirm);
                tv_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.img_back:
            case R.id.img_x:
                finish();
                break;
            case R.id.ll_item1://社保卡状态查询
                intent = new Intent(this, SheBaoStatusActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item2://社保卡挂失
                intent = new Intent(this, SheBaoGuaShiActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item3://业务变动提醒
                intent = new Intent(this, SheBaoDingYueActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item5://社保卡激活
                intent = new Intent(this, SheBaoJihuoActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item6://养老保险查询
                intent = new Intent(this, RetirementActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item7://医疗保险查询
                intent = new Intent(this, YiBaoActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_item8://失业保险查询
                intent = new Intent(this, UnemploymentInsuranceActivity.class);
                intent.putExtra("isShowImgX", true);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
}
