package com.vico.newstoutiao.activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.vico.newstoutiao.R;
import com.vico.newstoutiao.fragments.fragment_index;
import com.vico.newstoutiao.fragments.fragment_news;
import com.vico.newstoutiao.fragments.fragment_small_video;
import com.vico.newstoutiao.fragments.fragment_video;

public class MainActivity extends FragmentActivity implements View.OnClickListener {


    private LinearLayout mTabIndex;
    private LinearLayout mTabVideo;
    private LinearLayout mTabNews;
    private LinearLayout mTabSmallVideo;

    private ImageButton mImgIndex;
    private ImageButton mImgVideo;
    private ImageButton mImgNews;
    private ImageButton mImgSmallVideo;

    private Fragment mFragIndex;
    private Fragment mFragVideo;
    private Fragment mFragNews;
    private Fragment mFragSmallVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }

    private void initView() {
        mTabIndex = (LinearLayout) findViewById(R.id.main_tab_index);
        mTabVideo = (LinearLayout) findViewById(R.id.main_tab_video);
        mTabNews = (LinearLayout) findViewById(R.id.main_tab_news);
        mTabSmallVideo = (LinearLayout) findViewById(R.id.main_tab_small_video);

        mImgIndex = (ImageButton) findViewById(R.id.main_tab_index_img);
        mImgVideo = (ImageButton) findViewById(R.id.main_tab_video_img);
        mImgNews = (ImageButton) findViewById(R.id.main_tab_news_img);
        mImgSmallVideo = (ImageButton) findViewById(R.id.main_tab_small_video_img);
    }
    private void initEvent() {
        mTabIndex.setOnClickListener(this);
        mTabVideo.setOnClickListener(this);
        mTabNews.setOnClickListener(this);
        mTabSmallVideo.setOnClickListener(this);
    }
    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域

        switch (i)
        {
            case 0:
                if (mFragIndex == null)
                {
                    mFragIndex = new fragment_index();
                    transaction.add(R.id.id_content, mFragIndex);
                } else
                {
                    transaction.show(mFragIndex);
                }
                mImgIndex.setImageResource(R.mipmap.index_pressed);
                break;
            case 1:
                if (mFragVideo == null)
                {
                    mFragVideo = new fragment_video();
                    transaction.add(R.id.id_content, mFragVideo);
                } else
                {
                    transaction.show(mFragVideo);

                }
                mImgVideo.setImageResource(R.mipmap.index_pressed);
                break;
            case 2:
                if (mFragNews == null)
                {
                    mFragNews = new fragment_news();
                    transaction.add(R.id.id_content, mFragNews);
                } else
                {
                    transaction.show(mFragNews);
                }
                mImgNews.setImageResource(R.mipmap.index_pressed);
                break;
            case 3:
                if (mFragSmallVideo == null)
                {
                    mFragSmallVideo = new fragment_small_video();
                    transaction.add(R.id.id_content, mFragSmallVideo);
                } else
                {
                    transaction.show(mFragSmallVideo);
                }
                mImgSmallVideo.setImageResource(R.mipmap.index_pressed);
                break;

            default:
                break;
        }

        transaction.commit();


    }



    private void hideFragment(FragmentTransaction transaction)
    {
        if (mFragIndex != null)
        {
            transaction.hide(mFragIndex);
        }
        if (mFragVideo != null)
        {
            transaction.hide(mFragVideo);
        }
        if (mFragNews != null)
        {
            transaction.hide(mFragNews);
        }
        if (mFragSmallVideo != null)
        {
            transaction.hide(mFragSmallVideo);
        }
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId())
        {
            case R.id.main_tab_index:
                setSelect(0);
                break;
            case R.id.main_tab_video:
                setSelect(1);
                break;
            case R.id.main_tab_news:
                setSelect(2);
                break;
            case R.id.main_tab_small_video:
                setSelect(3);
                break;

            default:
                break;
        }

    }

    private void resetImgs()
    {
        mImgIndex.setImageResource(R.mipmap.index_normal);
        mImgVideo.setImageResource(R.mipmap.index_normal);
        mImgNews.setImageResource(R.mipmap.index_normal);
        mImgSmallVideo.setImageResource(R.mipmap.index_normal);
    }
}

