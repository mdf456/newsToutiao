package com.vico.newstoutiao.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vico.newstoutiao.R;

/**
 * Created by ${Vico} on 2017/7/10.
 */

public class fragment_small_video extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_small_video, container, false);
    }
}
