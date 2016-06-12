package com.example.masimo.ekolokator;

import android.location.Location;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.sql.Time;

/**
 * Created by masimo on 5/28/16.
 */
public class Evidencija {
    public static LatLng pozicija;
    public static String opis;
    public static String brojTelefona;
    public static String imeprezime;
    public static String e_mail;
    public static String broj_telefona;
    public static Uri slika;


    Evidencija(){
        imeprezime="Nepoznato";
        e_mail="Nepoznato";
        pozicija = new LatLng(0,0);
    }

    public static void setBroj_telefona(String broj_telefonat) { broj_telefona = broj_telefonat; }

    public static void setImeprezime(String imeprezimee) {
        imeprezime = imeprezimee;
    }

    public static void setE_mail(String e_maill) {
        e_mail = e_maill;
    }

    public static void setOpis(String opist) {
        opis = opist;
    }

    public static void setPozicija(LatLng pozicija_t) {
        pozicija = pozicija_t;
    }

    public static void setSlika(Uri slika_t) {
        slika= slika_t;
    }

    public static void setBrojTelefona(String brt){ broj_telefona = brt; }


    public static String getE_mail() {
        return e_mail;
    }

    public static String getImeprezime() {
        return imeprezime;
    }

    public static String getLocation() { return "Lokacija:" + Double.toString(pozicija.latitude) + "," + Double.toString(pozicija.longitude) + " .";}

    public static LatLng getLoc() { return pozicija; }

    public static String getBrojTelefona() {return brojTelefona; }

}

