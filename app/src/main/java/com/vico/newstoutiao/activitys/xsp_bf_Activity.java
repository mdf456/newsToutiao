package com.vico.newstoutiao.activitys;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.SeekBar;

import com.vico.newstoutiao.R;

import java.util.Timer;
import java.util.TimerTask;

//import java.util.Timer;
//import java.util.TimerTask;
//
//import static android.content.ContentValues.TAG;


public class xsp_bf_Activity extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_small_video_shipin);
    }
//
//             xsp_btn1 = (Button)findViewById(R.id.xsp_bf_bt1);
//             xsp_btn2 = (Button)findViewById(R.id.xsp_bf_bt2);
//             xsp_btn3 = (Button)findViewById(R.id.xsp_bf_bt3);
//             xsp_btn4 = (Button)findViewById(R.id.xsp_bf_bt4);
//
//        seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
//        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                int postion = seekBar.getProgress();
//                mediaplayer.seekTo(postion);
//
//            }
//        });
//        sv1 = (SurfaceView) findViewById(R.id.sv1);
//        holder = sv1.getHolder();
//        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//        holder.addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//                Log.i(TAG,"...destoryed");
//                if (mediaplayer!=null&&mediaplayer.isPlaying()){
//                    postion  = mediaplayer.getCurrentPosition();
//                    mediaplayer.stop();;
//                    mediaplayer.release();
//                    mediaplayer = null;
//                    timer.cancel();
//                    task.cancel();
//                    timer = null;
//                    task = null;
//                }
//
//            }
//        });
//
//   }
}
