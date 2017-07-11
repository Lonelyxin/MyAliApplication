package com.example.myaliapplication.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myaliapplication.R;
import com.example.myaliapplication.activity.CityServiceActivity;
import com.example.myaliapplication.activity.MoreAppActivity;
import com.example.myaliapplication.bean.LifeItem;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

public class HomeFragment extends BackHandledFragment implements AppBarLayout.OnOffsetChangedListener {

    private final static String TAG = "HomeFragment";
    private AppBarLayout abl_bar;
    private int mMaskColor;
    private RecyclerView rv_content;

    private View rootView;
    private CommonAdapter<LifeItem> mAdapter;
    private HeaderAndFooterWrapper  mFooterWrapper;

    // expand布局的控件
    private ImageView iv_search_expand, iv_plus_expand, iv_contact_expand;
    private EditText edi_search_expand;
    private View v_expand_mask, rl_expand;
    private View tl_expand;// fragment下expand布局整体

    // collapse布局的控件
    private ImageView iv_scan_collapse, iv_pay_collapse, iv_charge_collapse, iv_search_collapse, iv_plus_collapse;
    private View v_collapse_mask;
    private View tl_collapse;// fragment下collapse布局整体

    // 扫一扫四大功能布局控件

    private View v_pay_mask;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(rootView == null){
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
            mMaskColor = ContextCompat.getColor(getContext(), R.color.blue_dark);
            // toolbar等view初始
            inintView(rootView);
            // list布局
            initAdapter();
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    public void inintView(View rootView){
        abl_bar = (AppBarLayout) rootView.findViewById(R.id.abl_bar);
        abl_bar.addOnOffsetChangedListener(this);
        tl_expand = (View) rootView.findViewById(R.id.tl_expand);
        tl_collapse = (View) rootView.findViewById(R.id.tl_collapse);

        v_expand_mask = (View) rootView.findViewById(R.id.v_expand_mask);
        iv_search_expand = (ImageView) rootView.findViewById(R.id.iv_search_expand);
        iv_plus_expand = (ImageView) rootView.findViewById(R.id.iv_plus_expand);
        edi_search_expand = (EditText) rootView.findViewById(R.id.edi_search_expand);
        iv_contact_expand = (ImageView) rootView.findViewById(R.id.iv_contact_expand);
        rl_expand = (View) rootView.findViewById(R.id.rl_expand);

        v_collapse_mask = (View) rootView.findViewById(R.id.v_collapse_mask);
        iv_scan_collapse = (ImageView) rootView.findViewById(R.id.iv_scan_collapse);
        iv_pay_collapse = (ImageView) rootView.findViewById(R.id.iv_pay_collapse);
        iv_charge_collapse = (ImageView) rootView.findViewById(R.id.iv_charge_collapse);
        iv_search_collapse = (ImageView) rootView.findViewById(R.id.iv_search_collapse);
        iv_plus_collapse = (ImageView) rootView.findViewById(R.id.iv_plus_collapse);

        v_pay_mask = (View) rootView.findViewById(R.id.v_pay_mask);

    }

    public void initAdapter(){
        rv_content = (RecyclerView) rootView.findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_content.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mAdapter = new CommonAdapter<LifeItem>(getContext(), R.layout.item_life, LifeItem.getDefault())
        {
            @Override
            protected void convert(ViewHolder holder, LifeItem lifeItem, int position) {
                holder.setText(R.id.tv_title, lifeItem.title);
                holder.setImageResource(R.id.iv_pic, lifeItem.pic);
            }
        };
        mFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        mFooterWrapper.addFootView(LayoutInflater.from(getContext()).
                inflate(R.layout.layout_footer, rv_content, false));
//        mFooterWrapper.addFootView(LayoutInflater.from(getContext()).
//                inflate(R.layout.layout_footer, rv_content, false));
//        mFooterWrapper.addFootView(LayoutInflater.from(getContext()).
//                inflate(R.layout.layout_footer, rv_content, false));
//        mFooterWrapper.addFootView(LayoutInflater.from(getContext()).
//                inflate(R.layout.layout_footer, rv_content, false));
        rv_content.setAdapter(mFooterWrapper);
        mAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
//                Toast.makeText(getContext(), "pos "+position, Toast.LENGTH_SHORT).show();
                if(position == 11 ){
                    // 点击的是更多，进入全部应用页面
                    getActivity().startActivity(new Intent(getContext(), MoreAppActivity.class));
                }else if(position == 9){
                    // 点击城市服务，进入城市服务页面
//                    Toast.makeText(getContext(), "暂缓", Toast.LENGTH_SHORT).show();
                    getActivity().startActivity(new Intent(getContext(), CityServiceActivity.class));
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        /*
        针对 RecyclerView 滚动到顶部的时候，AppBarLayout需要自动展开的效果，添加scroll监听
         */
        rv_content.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (rv_content.getLayoutManager() instanceof  LinearLayoutManager){
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) rv_content.getLayoutManager();
                        int visiblePosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                        if (visiblePosition <= 1) {
//                            abl_bar.setExpanded(true, true);
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //showAndHideAppBar1(appBarLayout, verticalOffset);
        showAndHideAppBar2(appBarLayout, verticalOffset);
    }

    // 方案1。
    // 优点：控件监听少，v_expand_mask，v_collapse_mask，v_pay_mask整体控制渐变效果；
    // 缺点：有闪现的bug。
    public void showAndHideAppBar1(AppBarLayout appBarLayout, int verticalOffset){
        int offset = Math.abs(verticalOffset);
        int total = appBarLayout.getTotalScrollRange();
        int alphaIn = offset;
        int alphaOut = (180-offset)<0?0:180-offset;
        int maskColorIn = Color.argb(alphaIn, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        int maskColorInDouble = Color.argb(alphaIn*2, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        int maskColorOut = Color.argb(alphaOut*2, Color.red(mMaskColor),
                Color.green(mMaskColor), Color.blue(mMaskColor));
        if (offset <= total / 2) {
            tl_expand.setVisibility(View.VISIBLE);
            tl_collapse.setVisibility(View.GONE);
            v_expand_mask.setBackgroundColor(maskColorInDouble);
        } else {
            tl_expand.setVisibility(View.GONE);
            tl_collapse.setVisibility(View.VISIBLE);
            v_collapse_mask.setBackgroundColor(maskColorOut);
        }
        v_pay_mask.setBackgroundColor(maskColorIn);
    }

    //方案2
    // 优点：解决了闪现的bug；
    // 缺点：需要分别对两个布局的子控件进行alpha控制
    public void showAndHideAppBar2(AppBarLayout appBarLayout, int verticalOffset){
        if (verticalOffset == 0){
            //张开 expand布局
            tl_expand.setVisibility(View.VISIBLE);
            tl_collapse.setVisibility(View.GONE);
            setToolbar1Alpha(255);
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            //收缩 expand布局
            tl_expand.setVisibility(View.GONE);
            tl_collapse.setVisibility(View.VISIBLE);
            setToolbar2Alpha(255);
        } else {
            int alpha=255-Math.abs(verticalOffset);
            if(alpha<0){
                //收缩 expand toolbar
                tl_expand.setVisibility(View.GONE);
                tl_collapse.setVisibility(View.VISIBLE);
                setToolbar2Alpha(Math.abs(verticalOffset));
            }else{
                //张开 expand toolbar
                tl_expand.setVisibility(View.VISIBLE);
                tl_collapse.setVisibility(View.GONE);
                setToolbar1Alpha(alpha);
            }
        }
    }

    //设置展开时各控件的透明度
    public void setToolbar1Alpha(int alpha){
        iv_search_expand.getDrawable().setAlpha(alpha);
        edi_search_expand.setTextColor(Color.argb(alpha,255,255,255));
        edi_search_expand.setHintTextColor(Color.argb(alpha,255,255,255));
        edi_search_expand.setAlpha(alpha);
        iv_plus_expand.getDrawable().setAlpha(alpha);
        iv_contact_expand.getDrawable().setAlpha(alpha);
        rl_expand.getBackground().setAlpha(alpha);
//        tl_expand.setAlpha(alpha);
    }

    //设置闭合时collapse布局各控件的透明度
    public void setToolbar2Alpha(int alpha){
        iv_scan_collapse.getDrawable().setAlpha(alpha);
        iv_pay_collapse.getDrawable().setAlpha(alpha);
        iv_charge_collapse.getDrawable().setAlpha(alpha);
        iv_search_collapse.getDrawable().setAlpha(alpha);
        iv_plus_collapse.getDrawable().setAlpha(alpha);
//        tl_collapse.setAlpha(alpha);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
