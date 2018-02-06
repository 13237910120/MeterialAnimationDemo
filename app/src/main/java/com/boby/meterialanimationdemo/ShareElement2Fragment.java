package com.boby.meterialanimationdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 *共享元素测试fragment与fragment
 */
public class ShareElement2Fragment extends Fragment {
private View square_blue;

    public ShareElement2Fragment() {
        // Required empty public constructor
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static ShareElement2Fragment newInstance(boolean overlap) {
        ShareElement2Fragment fragment = new ShareElement2Fragment();
        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(500);

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

        fragment.setEnterTransition(slideTransition);
        fragment.setAllowEnterTransitionOverlap(overlap);
        fragment.setAllowReturnTransitionOverlap(overlap);
        fragment.setSharedElementEnterTransition(changeBoundsTransition);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_share_element2, container, false);
//        square_blue=view.findViewById(R.id.square_blue);
        return view;
    }




}
