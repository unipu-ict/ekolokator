package com.example.masimo.ekolokator.Tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.masimo.ekolokator.Evidencija;
import com.example.masimo.ekolokator.PrijavaActivity;
import com.example.masimo.ekolokator.R;

/**
 * Created by masimo on 5/28/16.
 */

public class TabFragment3 extends Fragment {

    public EditText imeprezime;
    public EditText email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_3,
                container, false);
        Button dalje = (Button) view.findViewById(R.id.dalje);
        Button natrag = (Button) view.findViewById(R.id.natrag);
        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dalje();
            }
        });
        natrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });

        imeprezime = (EditText) view.findViewById(R.id.imeprezime);
        email = (EditText) view.findViewById(R.id.email);

        imeprezime.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    Evidencija.setImeprezime(imeprezime.getText().toString());
                }

            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    Evidencija.setE_mail(email.getText().toString());
                }

            }
        });


        return view;
    }


    public void dalje(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(3);
    }
    public void natrag(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(1);
    }
}
