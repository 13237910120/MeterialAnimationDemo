package com.boby.meterialanimationdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 共享元素测试fragment
 */
public class SharedElementFragment extends Fragment {

    public static SharedElementFragment newInstance() {
        SharedElementFragment fragment = new SharedElementFragment();
        return fragment;
    }


    public SharedElementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shared_element, container, false);
      final View squareBlue=  view.findViewById(R.id.square_blue);
        view.findViewById(R.id.sample2_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareElement2Fragment shareElement2Fragment=ShareElement2Fragment.newInstance(false);
                getFragmentManager().beginTransaction()
                        .replace(R.id.sample2_content, shareElement2Fragment)
                        .addToBackStack(null)
                        .addSharedElement(squareBlue, getString(R.string.shared_img))
                        .commit();
            }
        });

        view.findViewById(R.id.sample2_button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareElement2Fragment shareElement2Fragment=ShareElement2Fragment.newInstance(true);
                getFragmentManager().beginTransaction()
                        .replace(R.id.sample2_content, shareElement2Fragment)
                        .addToBackStack(null)
                        .addSharedElement(squareBlue, getString(R.string.shared_img))
                        .commit();
            }
        });
        return  view ;
    }



}
