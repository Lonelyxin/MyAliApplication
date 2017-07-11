package com.example.myaliapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.CardBalance;
import com.example.myaliapplication.bean.UnemploymentInsurance;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

public class YiBaoActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isShowImgX = false;
    private RecyclerView rv_content;
    private View headerView;
    private CommonAdapter<CardBalance.ConsumptionDetailsBean> mAdapter;
    private HeaderAndFooterWrapper mFooterWrapper;
    private LoadMoreWrapper mLoadMoreWrapper;
    private List<CardBalance.ConsumptionDetailsBean> datas = new ArrayList<>();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirement);
        isShowImgX = getIntent().getBooleanExtra("isShowImgX", false);
        initView();
        initAdapter();
    }

    private void initView() {
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("医疗保险账户余额查询");

        ImageView img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);

        ImageView img_x = (ImageView) findViewById(R.id.img_x);
        if (isShowImgX)
            img_x.setVisibility(View.VISIBLE);
        else
            img_x.setVisibility(View.GONE);
        img_x.setOnClickListener(this);

    }

    private void initHeaderView() {
        headerView = View.inflate(this, R.layout.layout_yibao_header, null);
        // header中的个人信息
        ((TextView) headerView.findViewById(R.id.tv_name)).
                setText(MyApplication.getPersonInfo().getName());//姓名
        ((TextView) headerView.findViewById(R.id.tv_cardNum)).
                setText(MyApplication.getPersonInfo().getCardNum());//社保卡号
        // header中的参保信息
        ((TextView) headerView.findViewById(R.id.tv_balance)).
                setText(MyApplication.getCardBalance().getBalance());//账户余额

        mFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        mFooterWrapper.addHeaderView(headerView);
    }

    private void initAdapter() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        if (MyApplication.getCardBalance().getConsumptionDetails().size() >= 5) {
            for (int i = 0; i < 5; i++) {
                datas.add(MyApplication.getCardBalance().getConsumptionDetails().get(i));
                index = i;//加载5条数据后，index为4
            }
        }
        mAdapter = new CommonAdapter<CardBalance.ConsumptionDetailsBean>(
                this, R.layout.item_yibao, datas) {
            @Override
            protected void convert(final ViewHolder holder, CardBalance.ConsumptionDetailsBean detailsBean,
                                   final int position) {
                holder.setText(R.id.tv_paidTime, detailsBean.getTime() + "的消费记录");
                holder.setText(R.id.tv_amount, detailsBean.getAmount());
                holder.setText(R.id.tv_time, detailsBean.getTime());
                holder.setText(R.id.tv_location, detailsBean.getLocation());

            }
        };
        initHeaderView();
        mLoadMoreWrapper = new LoadMoreWrapper(mFooterWrapper);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        final int size = MyApplication.getCardBalance().getConsumptionDetails().size();
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // index从4开始计算
                        if (index + 1 < size) {
                            index++;
                            datas.add(MyApplication.getCardBalance().getConsumptionDetails().get(index));
                            mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
                        } else {
                            mLoadMoreWrapper.setLoadMoreView(0);
                        }
                        mLoadMoreWrapper.notifyDataSetChanged();
                    }
                }, 1000);
            }
        });
        rv_content.setAdapter(mLoadMoreWrapper);
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