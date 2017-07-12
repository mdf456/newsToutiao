package com.vico.newstoutiao.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.vico.newstoutiao.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class XspActivity extends Activity{
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icon = {R.mipmap.xsp_img1,R.mipmap.xsp_img1,R.mipmap.xsp_img1,R.mipmap.xsp_img1 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_small_video);
        gview = (GridView) findViewById(R.id.small_video_gv);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String [] from ={"image"};
        int [] to = {R.id.xsp_img};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.fragment_small_video_gv, from, to);
        gview.setAdapter(sim_adapter);
    }
    public List<Map<String, Object>> getData(){
        for(int i=0;i<icon.length;i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            data_list.add(map);
        }
        return data_list;
    }

}
