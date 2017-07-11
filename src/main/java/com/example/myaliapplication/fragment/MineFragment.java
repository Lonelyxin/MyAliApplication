package com.example.myaliapplication.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myaliapplication.MyApplication;
import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.MineItem;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

public class MineFragment extends BackHandledFragment implements View.OnClickListener {

    private final static String TAG = "HomeFragment";
    private RecyclerView rv_content;
    private View rootView;
    private TextView tv_set;
    private CommonAdapter<MineItem> mAdapter;
    private HeaderAndFooterWrapper mHeaderWrapper;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
            tv_set = (TextView) rootView.findViewById(R.id.tv_set);
            tv_set.setOnClickListener(this);
            initAdapter(rootView);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    public void initAdapter(View rootView) {
        rv_content = (RecyclerView) rootView.findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(getContext()));
//        rv_content.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mAdapter = new CommonAdapter<MineItem>(getContext(), R.layout.layout_mine_item, MineItem.getDefault()) {
            @Override
            protected void convert(ViewHolder holder, MineItem mineItem, int position) {
                holder.setImageResource(R.id.img_item, mineItem.pic);
                holder.setText(R.id.tv_item_name, mineItem.name);
                holder.setText(R.id.tv_content, mineItem.info);
                if (mineItem.infoColor != 0) {
                    holder.setTextColorRes(R.id.tv_content, mineItem.infoColor);
                }
                if (mineItem.hasMargin) {
                    ViewGroup.LayoutParams params = holder.getConvertView().getLayoutParams();
                    ViewGroup.MarginLayoutParams marginParams = null;
                    //获取view的margin设置参数
                    if (params instanceof ViewGroup.MarginLayoutParams) {
                        marginParams = (ViewGroup.MarginLayoutParams) params;
                    } else {
                        //不存在时创建一个新的参数
                        //基于View本身原有的布局参数对象
                        marginParams = new ViewGroup.MarginLayoutParams(params);
                    }
                    marginParams.setMargins(0, 0, 0, 50);
                }
            }
        };
        mHeaderWrapper = new HeaderAndFooterWrapper(mAdapter);
        View headerView = LayoutInflater.from(getContext()).
                inflate(R.layout.layout_mine_item2, rv_content, false);
        TextView tv_name = (TextView) headerView.findViewById(R.id.tv_name);
        TextView tv_email = (TextView) headerView.findViewById(R.id.tv_email);
        /**
         * 我的页面，填充个人数据：昵称、邮箱
         */
        tv_name.setText(MyApplication.getPersonInfo().getNickName());
        tv_email.setText(MyApplication.getPersonInfo().getEmail());

        mHeaderWrapper.addHeaderView(headerView);
        rv_content.setAdapter(mHeaderWrapper);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_set:
                break;
            default:
                break;
        }
    }
}
