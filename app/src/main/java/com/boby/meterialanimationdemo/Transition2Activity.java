package com.boby.meterialanimationdemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class Transition2Activity extends AppCompatActivity {

    private TextView activity_title;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void startByCode(Activity context, int code ){
        Intent intent=new Intent(context,Transition2Activity.class);
        switch (code){
            case 1:
                intent.putExtra("style","explodeCode");
                break;

            case 2:
                intent.putExtra("style","explodeXML");
                break;
            case 3:
                intent.putExtra("style","slideCode");
                break;
            case 4:
                intent.putExtra("style","slideXML");
                break;
        }
        context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context).toBundle());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);
        activity_title=findViewById(R.id.activity_title);
        String style=getIntent().getStringExtra("style");
        setTitle(style);
        activity_title.setText(style);
        Transition transition = null;
        switch (style){
            case "explodeCode":
                transition=setupWindowexplodeCodeAn();
                break;
            case "explodeXML":
                transition=setupWindowexplodeXMLAn();
                break;
            case "slideCode":
                transition=setupWindowslideCodeXMLAn();
                break;
            case "slideXML":
                transition=setupWindowslideXMLAn();
                break;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(transition);
        }
    }

    /**
     * 代码方式
     * @return
     */
     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     Transition setupWindowexplodeCodeAn(){
       Explode enterTransition = new Explode();
       enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
       return enterTransition;
   }

    /**
     * xml 方式导入
     * @return
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    Transition setupWindowexplodeXMLAn(){
        Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        return enterTransition;
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    Transition setupWindowslideCodeXMLAn(){
        Slide enterTransition = new Slide();
        enterTransition.setSlideEdge(Gravity.RIGHT);
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        return enterTransition;
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    Transition setupWindowslideXMLAn(){
        Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_bottom);
        return enterTransition;
    }


    public void exit(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
    }
}
