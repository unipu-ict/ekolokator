package com.example.masimo.ekolokator.Tab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masimo.ekolokator.Evidencija;
import com.example.masimo.ekolokator.PrijavaActivity;
import com.example.masimo.ekolokator.R;

import java.io.File;

/**
 * Created by masimo on 5/28/16.
 */

public class TabFragment4 extends Fragment {
    ImageView slikica;
    static TextView imeprezime;
    static TextView email;
    static TextView lokacija;
    static TextView brojTel;
    public static final String LOG ="frag4";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_4,
                container, false);

        Button dalje = (Button) view.findViewById(R.id.natrag);

        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });


        slikica = (ImageView) view.findViewById(R.id.slikatmp);
        imeprezime = (TextView) view.findViewById(R.id.imeprezimer);
        email = (TextView) view.findViewById(R.id.emailr);
        lokacija = (TextView) view.findViewById(R.id.lokacija);
        brojTel = (TextView) view.findViewById(R.id.brojTelefona);
        String sImeprez = Evidencija.getImeprezime();
        String sEmail = Evidencija.getE_mail();
        String lokacija_t = Evidencija.getLocation();
        String brojTela = Evidencija.getBrojTelefona();
        imeprezime.setText("Ime i prezime: " + sImeprez);
        email.setText("e-mail: " + sEmail);
        lokacija.setText("Lokacija: "+lokacija_t);
        brojTel.setText("Broj telefona:" + brojTela);

        Button prijavi = (Button) view.findViewById(R.id.prijavi) ;

        dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                natrag();
            }
        });
        prijavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prijaviProblem();
            }
        });



        return view;
    }

    public void natrag(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(2);
    }



    public static void osvjezi(){
        String sImeprez = Evidencija.getImeprezime();
        String sEmail = Evidencija.getE_mail();
        String lokacijat = Evidencija.getLocation();
        String brojTela = Evidencija.getBrojTelefona();
        imeprezime.setText("Ime i prezime: " + sImeprez);
        email.setText("e-mail: " + sEmail);
        lokacija.setText("Lokacija: "+lokacijat);
        brojTel.setText("Broj telefona:" + brojTela);
        // neki komentar
    }

    public boolean provjeriEmail(CharSequence email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public void prijaviProblem(){
        if(provjeriEmail(Evidencija.getE_mail())){
            File file = new File(Environment.getExternalStorageDirectory(),"temp_ekolokator.jpg");
            Uri slika = Uri.fromFile(file);
            Log.i (LOG, "put: " + slika.toString());
            String tekst_poruke = "" +
                    "Lokacija: http://maps.google.com/maps?q=" + Double.toString(Evidencija.getLoc().latitude) + "," + Double.toString(Evidencija.getLoc().longitude) + "&t=h \n \n" +
                    "Opis:" + Evidencija.opis + "\n \n" +
                    "Informacije o pošiljtelju: IME i PREZIME: " + Evidencija.getImeprezime() + ", E-MAIL: " + Evidencija.getE_mail() + " \n \n";

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"masimo.orbanic@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Prijava onečišćenja putem EkoLokator aplikacije");
            i.putExtra(Intent.EXTRA_TEXT   , tekst_poruke);
            i.putExtra(Intent.EXTRA_STREAM, slika);
            try {
                startActivity(Intent.createChooser(i, "Slanje e-maila..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getActivity(), "E-mail nije poslan", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "E-mail nije dobar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume(){
        super.onResume();

        if(TabFragment2.slika_postavljena){
            String photoPath = Environment.getExternalStorageDirectory()+"/temp_ekolokator.jpg";
            Bitmap temp_slika = BitmapFactory.decodeFile(photoPath);
            slikica.setImageBitmap(temp_slika);
        }
    }
}
