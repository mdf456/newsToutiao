package com.vico.newstoutiao.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.vico.newstoutiao.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fragment_small_video extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private GridView gv;
    private List<HashMap<String, Object>> list;
    private String[] names = {"text1", "text2", "text3", "text4"};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("ShouyeFragment","onCreateView()...");
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_small_video_gv, container, false);
        }
        initView(view);
        return view;
    }

    private void initView(View v) {
        initData();

        gv = (GridView) v.findViewById(R.id.shouye_gridview);
        String[] from = {"image","text"};
        int[] to = {R.id.item_shouye_img, R.id.item_shouye_name};
        gv.setAdapter(new SimpleAdapter(view.getContext(),list,R.layout.fragment_small_video_gv,from,to));
        gv.setOnItemClickListener(this);
    }

    private void initData() {
        list = new ArrayList<>();
        int[] icons = {
                R.mipmap.xsq_text,
                R.mipmap.xsq_text,
                R.mipmap.xsq_text,
                R.mipmap.xsq_text,
    };
        for (int i = 0; i < icons.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", icons[i]);
            map.put("text",names[i]);
            list.add(map);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((ViewGroup)view.getParent()).removeView(view);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("ShouyeFragment","...name:" + position);
    }


}