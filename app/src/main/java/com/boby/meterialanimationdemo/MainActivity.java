package com.boby.meterialanimationdemo;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private View shared_title;
    private View shared_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupWindowAnimations();
        }
        shared_title=findViewById(R.id.shared_title);
        shared_img=findViewById(R.id.shared_img);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {


        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(500);
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
        getWindow().setReturnTransition(slideTransition);
    }

    /**
     * 转场动画
     * @param view
     */
    public void transition(View view) {
        TransitionActivity.show(this);

    }

    /**
     * 转场动画共享元素
     * @param view
     */
    public void transitionElemts(View view) {
        SharedElementActivity.show(this,shared_title,shared_img);
    }

    /**
     * 布局元素动画
     * @param view
     */
    public void layoutAnimation(View view) {
    }

    /**
     * 共享元素+圆形展示
     * @param view
     */
    public void circularReveal(View view) {
    }
}
