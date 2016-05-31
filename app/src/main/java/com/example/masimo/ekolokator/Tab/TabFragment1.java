package com.example.masimo.ekolokator.Tab;

import android.app.TabActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;

import com.example.masimo.ekolokator.PagerAdapter;
import com.example.masimo.ekolokator.R;

public class TabFragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1,
                container, false);
        Button dalje = (Button) view.findViewById(R.id.dalje);

        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dalje();
            }
        });

        return view;
    }


    public void dalje(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(1);
    }


}
