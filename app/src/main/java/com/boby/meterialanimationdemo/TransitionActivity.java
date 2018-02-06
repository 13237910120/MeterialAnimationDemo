package com.boby.meterialanimationdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.View;

/**
 * 转场动画
 */
public class TransitionActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void show(Activity context){
        Intent intent=new Intent(context,TransitionActivity.class);
        context.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(context).toBundle());

    }

    public static void show(Context context){
        Intent intent=new Intent(context,TransitionActivity.class);
        context.startActivity(intent);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_transition);
        setTitle("转场动画");
        setupWindowAnimations();
    }

    /**
     * 设置进场和退场动画
     */
    private void setupWindowAnimations() {
        Visibility enterTransition = buildEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(enterTransition);
        }
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private Visibility buildEnterTransition() {
        Fade enterTransition = new Fade();
        enterTransition.setDuration(1000);
        return enterTransition;
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Visibility buildReturnTransition() {
        Visibility enterTransition = new Slide();
        enterTransition.setDuration(1000);
        return enterTransition;
    }

    public void explodeCode(View view) {
        Transition2Activity.startByCode(this,1);
    }

    public void explodeXML(View view) {
        Transition2Activity.startByCode(this,2);
    }

    public void slideCode(View view) {
        Transition2Activity.startByCode(this,3);
    }

    public void slideXML(View view) {
        Transition2Activity.startByCode(this,4);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void exit(View view) {
        finishAfterTransition();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void exitOverriding(View view) {
        Slide enterTransition= new Slide();
        enterTransition.setDuration(1000);
        enterTransition.setSlideEdge(Gravity.LEFT);
        getWindow().setReturnTransition(enterTransition);
        finishAfterTransition();
    }
}
