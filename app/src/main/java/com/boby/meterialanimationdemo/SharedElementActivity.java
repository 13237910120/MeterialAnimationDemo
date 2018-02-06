package com.boby.meterialanimationdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

/**
 * 共享元素Activity
 */
public class SharedElementActivity extends AppCompatActivity {

    /**
     *
     * @param context activity
     * @param view1 共享元素1
     * @param view2 共享元素2
     */
   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
   public static void show(Activity context, View view1, View view2){
       Intent intent=new Intent(context,SharedElementActivity.class);
       Pair pair1= new Pair<View,String>(view1,context.getString(R.string.shared_title));
       Pair pair2= new Pair<View,String>(view2,context.getString(R.string.shared_img));
      Pair[] pairs= TransitionHelper.createSafeTransitionParticipants(context,false,pair1,pair2);
       ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(context, pairs);
       context.startActivity(intent,transitionActivityOptions.toBundle());
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        setupWindowAnimations();
        setupLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        // 设置默认的转场动画
        getWindow().getEnterTransition().setDuration(getResources().getInteger(R.integer.anim_duration_long));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupLayout() {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        // Create fragment and define some of it transitions
        SharedElementFragment sharedElementFragment1 = SharedElementFragment.newInstance();
        sharedElementFragment1.setReenterTransition(slideTransition);
        sharedElementFragment1.setExitTransition(slideTransition);
        sharedElementFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sample2_content, sharedElementFragment1)
                .commit();
    }
}
