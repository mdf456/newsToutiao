package com.vico.newstoutiao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.vico.newstoutiao.R;
import com.vico.newstoutiao.activitys.XspActivity;
import com.vico.newstoutiao.activitys.xsp_bf_Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class fragment_small_video extends Fragment implements AdapterView.OnItemClickListener {
    private View view;
    private GridView gv;
    private List<HashMap<String,Object>> list;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (view == null){
            view = inflater.inflate(R.layout.fragment_small_video,container,false);

        }
        initView(view);
        return view;
    }

    private void initView(View v) {
        initData();
        gv = (GridView) v.findViewById(R.id.small_video_gv);
        String[] from = {"image"};
        int[] to = {R.id.xsp_img};
        gv.setAdapter(new SimpleAdapter(view.getContext(),list,R.layout.fragment_small_video_gv,from,to));
        gv.setOnItemClickListener(this);

    }

    private void initData() {
        list = new ArrayList<HashMap<String, Object>>();
        int[] icons = {
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
                R.mipmap.xsp_img1,
        };
        for (int i =0;i<icons.length;i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", icons[i]);
            list.add(map);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ((ViewGroup)view.getParent()).removeView(view);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(fragment_small_video.this.getActivity(),xsp_bf_Activity.class);
        startActivity(intent);
    }
}
