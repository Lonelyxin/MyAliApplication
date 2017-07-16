package com.example.myaliapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myaliapplication.view.CustomRecyclerView;
import com.example.myaliapplication.R;
import com.example.myaliapplication.adapter.cityservice.CityServiceAdapterForRv;
import com.example.myaliapplication.bean.CityService;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CityServiceActivity extends AppCompatActivity implements View.OnClickListener, AppBarLayout.OnOffsetChangedListener, TabLayout.OnTabSelectedListener {

    private AppBarLayout abl_bar;
    // expand布局的控件
    private ImageView img_back1, img_search1, img_shenglue1;
    private View ll_search1, v_expand_mask;
    private View tl_expand;// activity 下expand布局整体

    // collapse布局的控件
    private ImageView img_back2, img_search2, img_shenglue2;
    private View ll_search2, v_collapse_mask;
    private View tl_collapse;// activity 下collapse布局整体

    // 四个大图标
    private View ll_title1, ll_title2, ll_title3, ll_title4;

    private CustomRecyclerView rv_content;
    private CityServiceAdapterForRv mAdapter;
    private ArrayList<CityService> datas;

    protected TabLayout tablayout;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if (msg.what == 0x123) {// 张开背景
                /**setlevel()设置图片截取的大小
                 * 修改ClipDrawable的level值，level值为0--10000；
                 * 0：截取图片大小为空白，10000：截取图片为整张图片；
                 */
                int level = ((ClipDrawable) msg.obj).getLevel() + 100;
                if (level <= 10000) {
                    ((ClipDrawable) msg.obj).setLevel(level);
                }
            } else if (msg.what == 0x456) {// 收缩背景
                int level = ((ClipDrawable) msg.obj).getLevel() - 100;
                if (level >= 0) {
                    ((ClipDrawable) msg.obj).setLevel(level);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_service);
        inintView();
        initTabLayout();
        initAdapter();
    }

    private void inintView() {
        abl_bar = (AppBarLayout) findViewById(R.id.abl_bar);
        abl_bar.addOnOffsetChangedListener(this);
        tl_expand = (View) findViewById(R.id.tl_expand);
        tl_collapse = (View) findViewById(R.id.tl_collapse);

        img_back1 = (ImageView) findViewById(R.id.img_back1);
        img_search1 = (ImageView) findViewById(R.id.img_search1);
        img_shenglue1 = (ImageView) findViewById(R.id.img_shenglue1);
        ll_search1 = (View) findViewById(R.id.ll_search1);
        v_expand_mask = (View) findViewById(R.id.v_expand_mask);

        img_back2 = (ImageView) findViewById(R.id.img_back2);
        img_search2 = (ImageView) findViewById(R.id.img_search2);
        img_shenglue2 = (ImageView) findViewById(R.id.img_shenglue2);
        ll_search2 = (View) findViewById(R.id.ll_search2);
        v_collapse_mask = (View) findViewById(R.id.v_collapse_mask);

        ll_title1 = findViewById(R.id.ll_title1);
        ll_title2 = findViewById(R.id.ll_title2);
        ll_title3 = findViewById(R.id.ll_title3);
        ll_title4 = findViewById(R.id.ll_title4);
        ll_title1.setOnClickListener(this);
        ll_title2.setOnClickListener(this);
        ll_title3.setOnClickListener(this);
        ll_title4.setOnClickListener(this);
        img_back1.setOnClickListener(this);
        img_back2.setOnClickListener(this);

    }

    private void initTabLayout() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.getTabAt(0).getCustomView().findViewById(R.id.tv_tab).getBackground().setLevel(10000);
        tablayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isTouchFling = false;
            }
        });
        tablayout.addOnTabSelectedListener(this);
    }

    private void onTabSelectedAnim(final ClipDrawable drawable) {
        final Timer timer = new Timer();
        // 张开背景
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x123;
                msg.obj = drawable;
                handler.sendMessage(msg);
                if (drawable.getLevel() >= 10000) {
                    timer.cancel();
                }
            }
        }, 0, 1);
    }

    private void onTabUnselectedAnim(final ClipDrawable drawable) {
        final Timer timer = new Timer();
        // 收缩背景
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x456;
                msg.obj = drawable;
                handler.sendMessage(msg);
                if (drawable.getLevel() <= 0) {
                    timer.cancel();
                }
            }
        }, 0, 1);
    }

    private void initAdapter() {
        rv_content = (CustomRecyclerView) findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        datas = CityService.getDefault();
        mAdapter = new CityServiceAdapterForRv(this, datas);
        HeaderAndFooterWrapper mHeaderWrapper = new HeaderAndFooterWrapper(mAdapter);
        mHeaderWrapper.addFootView(LayoutInflater.from(this).
                inflate(R.layout.layout_city_item_footer, rv_content, false));
        rv_content.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                //没有加header，取数据的时候不需要position-1
                CityService cityService = datas.get(position);
                if (cityService != null) {
                    if ("公积金服务".equals(cityService.name)) {
                        startActivity(new Intent(CityServiceActivity.this, GongJiJinActivity.class));
                    } else if ("郑州社保卡服务".equals(cityService.name)) {
                        startActivity(new Intent(CityServiceActivity.this, ZhengZhouSheBaoActivity.class));
                    } else if ("自然人社保费缴费".equals(cityService.name)) {
                        startActivity(new Intent(CityServiceActivity.this, ZiRanRenSheBaoActivity.class));
                    }
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        rv_content.setflingScale(0.5);
        /*
        针对 RecyclerView 滚动到顶部的时候，AppBarLayout需要自动展开的效果，添加scroll监听, 暂时不做自动展开效果
         */
        rv_content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isTouchFling = true;
                return false;
            }
        });
        rv_content.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = getLayoutManager(rv_content);
                int firstVisibleItemPosition = getFirstVisiblePosition(layoutManager);
                int firstCompletelyVisibleItemPosition = getFirstCompletelyVisibleItemPosition(layoutManager);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    isTouchFling = false;
                    if (firstCompletelyVisibleItemPosition <= 1) {
                        abl_bar.setExpanded(true, true);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = getLayoutManager(rv_content);
                int firstVisibleItemPosition = getFirstVisiblePosition(layoutManager);
                //在这里进行第二次滚动（最后的滑动部分！）
                if (move) {
                    move = false;
                    //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                    int n = mIndex - firstVisibleItemPosition;
                    if (0 <= n && n < rv_content.getChildCount()) {
                        //获取要置顶的项顶部离RecyclerView顶部的距离
                        int top = rv_content.getChildAt(n).getTop()
                                - ((ViewGroup.MarginLayoutParams) rv_content.getChildAt(n).getLayoutParams()).topMargin;
                        //最后的移动
                        rv_content.scrollBy(0, top);
                    }
                }
                if (isTouchFling) {
                    if (firstVisibleItemPosition < 8 && tablayout.getSelectedTabPosition() != 0) {
                        tablayout.getTabAt(0).select();
                    } else if (firstVisibleItemPosition < 15
                            && firstVisibleItemPosition >= 8
                            && tablayout.getSelectedTabPosition() != 1) {
                        tablayout.getTabAt(1).select();
                    } else if (firstVisibleItemPosition < 24
                            && firstVisibleItemPosition >= 15
                            && tablayout.getSelectedTabPosition() != 2) {
                        tablayout.getTabAt(2).select();
                    } else if (firstVisibleItemPosition < 31
                            && firstVisibleItemPosition >= 24
                            && tablayout.getSelectedTabPosition() != 3) {
                        tablayout.getTabAt(3).select();
                    } else if (firstVisibleItemPosition >= 31
                            && tablayout.getSelectedTabPosition() != 4) {
                        tablayout.getTabAt(4).select();
                    }
                }
            }
        });
    }

    private RecyclerView.LayoutManager getLayoutManager(RecyclerView rv_content) {
        RecyclerView.LayoutManager layoutManager = rv_content.getLayoutManager();
        if (rv_content.getLayoutManager() instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        } else if (rv_content.getLayoutManager() instanceof GridLayoutManager) {
            return (GridLayoutManager) layoutManager;
        } else if (rv_content.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            return (StaggeredGridLayoutManager) layoutManager;
        } else {
            return layoutManager;
        }
    }

    private int getFirstCompletelyVisibleItemPosition(RecyclerView.LayoutManager layoutManager) {
        int position;
        if (layoutManager instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            position = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()]);
            position = getMinPositions(lastPositions);
        } else {
            position = 0;
        }
        return position;
    }

    private int getFirstVisiblePosition(RecyclerView.LayoutManager layoutManager) {
        int position;
        if (layoutManager instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            position = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()]);
            position = getMinPositions(lastPositions);
        } else {
            position = 0;
        }
        return position;
    }

    /**
     * 获得当前展示最小的position
     *
     * @param positions
     * @return
     */
    private int getMinPositions(int[] positions) {
        int size = positions.length;
        int minPosition = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            minPosition = Math.min(minPosition, positions[i]);
        }
        return minPosition;
    }

    /**
     * 获取最后一条展示的位置
     *
     * @return
     */
    private int getLastVisiblePosition(RecyclerView.LayoutManager layoutManager) {
        int position;
        if (layoutManager instanceof LinearLayoutManager) {
            position = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            position = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] lastPositions = ((StaggeredGridLayoutManager) layoutManager).
                    findLastVisibleItemPositions(
                            new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()]);
            position = getMaxPosition(lastPositions);
        } else {
            position = layoutManager.getItemCount() - 1;
        }
        return position;
    }

    /**
     * 获得最大的位置
     *
     * @param positions
     * @return
     */
    private int getMaxPosition(int[] positions) {
        int size = positions.length;
        int maxPosition = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maxPosition = Math.max(maxPosition, positions[i]);
        }
        return maxPosition;
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        showAndHideAppBar2(appBarLayout, verticalOffset);
    }

    private void showAndHideAppBar2(AppBarLayout appBarLayout, int verticalOffset) {
        v_expand_mask.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent));
        v_collapse_mask.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        if (verticalOffset == 0) {
            //张开 expand布局
            tl_expand.setVisibility(View.VISIBLE);
            tl_collapse.setVisibility(View.GONE);
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            //收缩 expand布局
            tl_expand.setVisibility(View.GONE);
            tl_collapse.setVisibility(View.VISIBLE);
        } else {
            int alpha = 255 - Math.abs(verticalOffset);
            if (alpha < 0) {
                //收缩 expand toolbar
                tl_expand.setVisibility(View.GONE);
                tl_collapse.setVisibility(View.VISIBLE);
            } else {
                //张开 expand toolbar
                tl_expand.setVisibility(View.VISIBLE);
                tl_collapse.setVisibility(View.GONE);
            }
        }
    }

    //设置展开时各控件的透明度
    private void setToolbar1Alpha(int alpha) {
        img_back1.getDrawable().setAlpha(alpha);
        img_search1.getDrawable().setAlpha(alpha);
        img_shenglue1.getDrawable().setAlpha(alpha);
        ll_search1.getBackground().setAlpha(alpha);
    }

    //设置闭合时collapse布局各控件的透明度
    private void setToolbar2Alpha(int alpha) {
        img_back2.getDrawable().setAlpha(alpha);
        img_search2.getDrawable().setAlpha(alpha);
        img_shenglue2.getDrawable().setAlpha(alpha);
        ll_search2.getBackground().setAlpha(alpha);
    }

    private boolean move = false;
    private int mIndex = 0;

    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = getFirstVisiblePosition(getLayoutManager(rv_content));
        int lastItem = getLastVisiblePosition(getLayoutManager(rv_content));
        mIndex = n;
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            rv_content.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = rv_content.getChildAt(n - firstItem).getTop()
                    - ((ViewGroup.MarginLayoutParams) rv_content.getChildAt(n - firstItem).getLayoutParams()).topMargin;
            rv_content.scrollBy(0, top);
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            rv_content.scrollToPosition(n);
//            //这里这个变量是用在RecyclerView滚动监听里面的
            move = true;
        }

    }

    private boolean isTouchFling = false;

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.tv_tab).setSelected(true);
        onTabSelectedAnim((ClipDrawable) tab.getCustomView().findViewById(R.id.tv_tab).getBackground());
        abl_bar.setExpanded(false, true);
        if (!isTouchFling) {
            if (tab.getPosition() == 0) {
                moveToPosition(0);
            } else if (tab.getPosition() == 1) {
                moveToPosition(9);
            } else if (tab.getPosition() == 2) {
                moveToPosition(16);
            } else if (tab.getPosition() == 3) {
                moveToPosition(25);
            } else if (tab.getPosition() == 4) {
                moveToPosition(32);
            }
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.tv_tab).setSelected(false);
        onTabUnselectedAnim((ClipDrawable) tab.getCustomView().findViewById(R.id.tv_tab).getBackground());
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        abl_bar.setExpanded(false, true);
        if (!isTouchFling) {
            if (tab.getPosition() == 0) {
                moveToPosition(0);
            } else if (tab.getPosition() == 1) {
                moveToPosition(9);
            } else if (tab.getPosition() == 2) {
                moveToPosition(16);
            } else if (tab.getPosition() == 3) {
                moveToPosition(25);
            } else if (tab.getPosition() == 4) {
                moveToPosition(32);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title1:
                break;
            case R.id.ll_title2:
                break;
            case R.id.ll_title3:
                startActivity(new Intent(CityServiceActivity.this, GongJiJinActivity.class));
                break;
            case R.id.ll_title4:
                startActivity(new Intent(CityServiceActivity.this, SheBaoKaActivity1.class));
                break;
            case R.id.img_back1:
            case R.id.img_back2:
                finish();
                break;
            default:
                break;
        }
    }
}
