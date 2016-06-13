package com.example.masimo.ekolokator.Tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.masimo.ekolokator.Evidencija;
import com.example.masimo.ekolokator.PrijavaActivity;
import com.example.masimo.ekolokator.R;

import java.security.spec.ECField;

/**
 * Created by masimo on 5/28/16.
 */

public class TabFragment3 extends Fragment {

    public EditText imeprezime;
    public EditText email;
    public EditText brojTelefona;


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
        brojTelefona = (EditText) view.findViewById(R.id.brojTelefona);

        imeprezime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Evidencija.setImeprezime(s.toString());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Evidencija.setE_mail(s.toString());
            }
        });

        brojTelefona.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Evidencija.setBrojTelefona(s.toString());
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
