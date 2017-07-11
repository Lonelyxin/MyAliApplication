package com.example.myaliapplication.activity;

import android.content.Intent;
import android.graphics.Color;
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
import com.example.myaliapplication.bean.RetirementInsurance;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

public class RetirementActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isShowImgX = false;
    private RecyclerView rv_content;
    private View headerView;
    private CommonAdapter<RetirementInsurance.DetailsBean> mAdapter;
    private HeaderAndFooterWrapper mFooterWrapper;
    private LoadMoreWrapper mLoadMoreWrapper;
    private List<RetirementInsurance.DetailsBean> datas = new ArrayList<>();
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
        tv_title.setText("养老保险查询");

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
        headerView = View.inflate(this, R.layout.layout_yanglao_header, null);
        // header中的个人信息
        ((TextView) headerView.findViewById(R.id.tv_name)).
                setText(MyApplication.getPersonInfo().getName());//姓名
        ((TextView) headerView.findViewById(R.id.tv_personNum)).
                setText(MyApplication.getPersonInfo().getPersonNum());//身份证号
        ((TextView) headerView.findViewById(R.id.tv_sex)).
                setText(MyApplication.getPersonInfo().getSex());//性别
        ((TextView) headerView.findViewById(R.id.tv_nation)).
                setText(MyApplication.getPersonInfo().getNation());//民族
        ((TextView) headerView.findViewById(R.id.tv_birthday)).
                setText(MyApplication.getPersonInfo().getBirthday());//生日
        ((TextView) headerView.findViewById(R.id.tv_coName)).
                setText(MyApplication.getPersonInfo().getDanweiName());//单位名称
        ((TextView) headerView.findViewById(R.id.tv_coNum)).
                setText(MyApplication.getPersonInfo().getDanweiNum());//单位编号

        //header中的参保信息
        ((TextView) headerView.findViewById(R.id.tv_canbaotime)).
                setText(MyApplication.getRetirementInsurance().getCanbaoTime());//参保时间
        ((TextView) headerView.findViewById(R.id.tv_canbaostatus)).
                setText(MyApplication.getRetirementInsurance().getCanbaoStatus());//参保状态
        ((TextView) headerView.findViewById(R.id.tv_payableMonths)).
                setText(MyApplication.getRetirementInsurance().getPayableMonths());//应缴月数
        ((TextView) headerView.findViewById(R.id.tv_actualMonths)).
                setText(MyApplication.getRetirementInsurance().getActualMonths());//实缴月数
        ((TextView) headerView.findViewById(R.id.tv_personPayable)).
                setText(MyApplication.getRetirementInsurance().getPersonPayable());//个人应缴
        ((TextView) headerView.findViewById(R.id.tv_coPayable)).
                setText(MyApplication.getRetirementInsurance().getCoPayable());//单位应缴
        ((TextView) headerView.findViewById(R.id.tv_totalPayable)).
                setText(MyApplication.getRetirementInsurance().getTotalPayable());//应缴总额
        ((TextView) headerView.findViewById(R.id.tv_personArrears)).
                setText(MyApplication.getRetirementInsurance().getPersonArrears());//个人欠缴
        ((TextView) headerView.findViewById(R.id.tv_coArrears)).
                setText(MyApplication.getRetirementInsurance().getCoArrears());//单位欠缴
        ((TextView) headerView.findViewById(R.id.tv_personPaid)).
                setText(MyApplication.getRetirementInsurance().getPersonPaid());//个人实缴
        ((TextView) headerView.findViewById(R.id.tv_coPaid)).
                setText(MyApplication.getRetirementInsurance().getCoPaid());//单位实缴
        ((TextView) headerView.findViewById(R.id.tv_totalPaid)).
                setText(MyApplication.getRetirementInsurance().getTotalPaid());//实缴总额

        mFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        mFooterWrapper.addHeaderView(headerView);
    }

    private void initAdapter() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        if (MyApplication.getRetirementInsurance().getDetails().size() >= 5) {
            for (int i = 0; i < 5; i++) {
                datas.add(MyApplication.getRetirementInsurance().getDetails().get(i));
                index = i;//加载5条数据后，index为4
            }
        }
        mAdapter = new CommonAdapter<RetirementInsurance.DetailsBean>(
                this, R.layout.item_paid_info, datas) {
            ArrayMap<Integer, Boolean> map = new ArrayMap<>();

            @Override
            protected void convert(final ViewHolder holder, RetirementInsurance.DetailsBean detailsBean,
                                   final int position) {
                holder.setText(R.id.tv_paidTime, detailsBean.getPaidTime());
                holder.setText(R.id.tv_personPaid, detailsBean.getPersonPaid());
                holder.setText(R.id.tv_coPaid, detailsBean.getCoPaid());
                holder.setText(R.id.tv_totalPaid, detailsBean.getTotalPaid());
                holder.setText(R.id.tv_baseNum, detailsBean.getBaseNum());
                holder.setText(R.id.tv_paymentType, detailsBean.getPaymentType());
                holder.setText(R.id.tv_isPaid, detailsBean.getIsPaid());
                map.put(position - 1, false);
                holder.getView(R.id.img_expand).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!map.valueAt(position - 1)) {
                            holder.setImageResource(R.id.img_expand, R.mipmap.ic_expand_more);
                            holder.getView(R.id.ll_expand).setVisibility(View.VISIBLE);
                            map.put(position - 1, true);
                        } else {
                            holder.setImageResource(R.id.img_expand, R.mipmap.ic_expand_less);
                            holder.getView(R.id.ll_expand).setVisibility(View.GONE);
                            map.put(position - 1, false);
                        }
                    }
                });

            }
        };
        initHeaderView();
        mLoadMoreWrapper = new LoadMoreWrapper(mFooterWrapper);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        final int size = MyApplication.getRetirementInsurance().getDetails().size();
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // index从4开始计算
                        if (index + 1 < size) {
                            index++;
                            datas.add(MyApplication.getRetirementInsurance().getDetails().get(index));
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
