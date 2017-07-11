package com.example.myaliapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.myaliapplication.R;
import com.example.myaliapplication.adapter.moreapp.MoreAppAdapterForRv;
import com.example.myaliapplication.bean.MoreAppItem;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;

public class MoreAppActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_back;
    private RecyclerView rv_content;
    private MoreAppAdapterForRv mAdapter;
    private HeaderAndFooterWrapper mHeaderWrapper;
    private ArrayList<MoreAppItem> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_app);
        initView();
        initAdapter();
    }

    public void initView() {
        img_back = (ImageView) findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
    }

    private void initAdapter() {
        rv_content = (RecyclerView) findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
//        rv_content.setLayoutManager(new GridLayoutManager(this, 4));
        datas = MoreAppItem.getDefault();
        mAdapter = new MoreAppAdapterForRv(this, datas);
        mHeaderWrapper = new HeaderAndFooterWrapper(mAdapter);
        mHeaderWrapper.addHeaderView(LayoutInflater.from(this).
                inflate(R.layout.layout_moreapp_list_header, rv_content, false));
        rv_content.setAdapter(mHeaderWrapper);
        mAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//                if(position == 11 ){
//                    // 点击的是更多，进入全部应用页面
//                    //startActivity(new Intent(MoreAppActivity.this, MoreAppActivity.class));
//                }else if(position == 9){
//                    // 点击城市服务，进入城市服务页面
//                }
                //由于加了header，取数据的时候需要position-1
                MoreAppItem moreAppItem = datas.get(position - 1);
                if (moreAppItem != null && "城市服务".equals(moreAppItem.name)) {
//                    Toast.makeText(MoreAppActivity.this, "暂缓", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MoreAppActivity.this, CityServiceActivity.class));
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }
}
