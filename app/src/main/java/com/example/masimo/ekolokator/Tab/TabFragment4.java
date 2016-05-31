package com.example.masimo.ekolokator.Tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.masimo.ekolokator.Evidencija;
import com.example.masimo.ekolokator.PrijavaActivity;
import com.example.masimo.ekolokator.R;

/**
 * Created by masimo on 5/28/16.
 */

public class TabFragment4 extends Fragment {
    static TextView imeprezime;
    static TextView email;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_4,
                container, false);

        Button dalje = (Button) view.findViewById(R.id.dalje);

        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });


        imeprezime = (TextView) view.findViewById(R.id.imeprezimer);
        email = (TextView) view.findViewById(R.id.emailr);
        String sImeprez = Evidencija.getImeprezime();
        String sEmail = Evidencija.getE_mail();
        imeprezime.setText(sImeprez);
        email.setText(sEmail);

        return view;
    }

    public void natrag(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(2);
    }



    public static void osvjezi(){
        String sImeprez = Evidencija.getImeprezime();
        String sEmail = Evidencija.getE_mail();
        imeprezime.setText(sImeprez);
        email.setText(sEmail);
    }
}
