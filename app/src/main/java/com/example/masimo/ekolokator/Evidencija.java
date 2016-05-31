package com.example.masimo.ekolokator;

import android.location.Location;

import java.io.File;
import java.sql.Time;

/**
 * Created by masimo on 5/28/16.
 */
public class Evidencija {
    public static Location pozicija;
    public static String opis;
    public static String imeprezime;
    public static String e_mail;
    public static String broj_telefona;
    public static File slika;
    public static Time vrijeme;

    public void Evidencija(){
        imeprezime="Nepoznato";
        e_mail="Nepoznato";
    }

    public static void setBroj_telefona(String broj_telefona) { broj_telefona = broj_telefona; }

    public static void setImeprezime(String imeprezimee) {
        imeprezime = imeprezimee;
    }

    public static void setE_mail(String e_maill) {
        e_mail = e_maill;
    }

    public static void setOpis(String opis) {
        opis = opis;
    }

    public static void setPozicija(Location pozicija) {
        pozicija = pozicija;
    }

    public static void setSlika(File slika) {
        slika= slika;
    }

    public static void setVrijeme(Time vrijeme) { vrijeme = vrijeme; }

    public static String getE_mail() {
        return e_mail;
    }

    public static String getImeprezime() {
        return imeprezime;
    }



}

