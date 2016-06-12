package com.example.masimo.ekolokator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView opis = (TextView) findViewById(R.id.opis);
        String sourceString = "<b>EkoLokator</b> je aplikacija koja služi za prijavu onečišćenja u prirodi nadležnim službama. <br />Pomozite spasiti okoliš tako da <b>Locirate, Fotografirate</b> i <b>Opišete</b> onečišćenja koje ste pronašli. <br />Sa Vašom pomoći možemo spriječiti daljnja onačišćenja vode i prirode, i korak smo bliže čistom okolišu u kojem živimo. " ;
        opis.setText(Html.fromHtml(sourceString));
        Typeface typefont = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        opis.setTypeface(typefont);

        Button prijava = (Button) findViewById(R.id.prijava);
        prijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prijava();
            }
        });

    }

    public void prijava(){
        Intent intent = new Intent(this, PrijavaActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                closeContextMenu();
            }
        });
        adb.setIcon(android.R.drawable.ic_menu_help);

        switch (item.getItemId()) {
            case R.id.oapp:
                adb.setTitle(getString(R.string.oapp_title));
                //adb.setMessage(getString(R.string.opis_aplikacije));
                String oApp= "Ova aplikacija je nastala kao dio kolegija <b>Mobline aplikacije, na Odjelu za informacijske i komunikacijske tehnologije, Sveučilišta Jurja Dobrile u Puli.</b>\n" +
                        "<br>" +
                        "Apikaciju su napravili studenti <b>Antonio Maretić, Masimo Orbanić i Marino Pereša </b>, pod mentorstvom <b>doc.dr.sc. Siniše Sovilja.</b>\n" +
                        "<br>" +
                        "<b>OIKT, UNIPU, 2016 </b>";
                adb.setMessage(Html.fromHtml(oApp));
                adb.show();

                return true;

            case R.id.upute:
                adb.setTitle(getString(R.string.upute));
                String uputeZaKoristenje = "Napomena: za korištenje ove aplikacije potrebna ja INTERNET VEZA. Prije prijave pobrinite se da imate potrebne fotografije, tokom rada aplikacije nije moguće raditi dodatne fotografije.<br>Sve nepotpune prijave biti će ignorirane!<br><br> \n" +
                        "Prijava se započinje nakon što se na početnom ekranu aplikacije klikne gumb PRIJAVI. \n" +
                        "Nakon toga započinje prijava onečišćenja. \n" +
                        "<br><br>" +
                        "Prvo što se unosi je LOKACIJA. Lokaciju se može odabrati preko odabira 'Vaša trenutna lokacija' gdje se za lokaciju postavlja vaša trenutna lokacija, ili preko odabira 'Odaberite na mapi', gdje na mapi označite željenu lokaciju na način da <b>duže držite pritisnuto mjesto na mapi</b>." +
                        "<br><br>" +
                        "Nakon toga se odabire SLIKA i OPIS. Slika se odabire tako da se pritisne na gumb 'Dodaj sliku', i nakon toga odaberete željenu sliku u Vašoj galeriji. Nakon toga u predviđeno polje se unese OPIS onečišćenja. Tokom pisanja opisa nastojite čim detaljnije i opširnije opisati onečišćenje." +
                        "<br><br>" +
                        "Nakon slike i opisa unesite vaše kontakt informacije, odnosno vaše ime i prezime i email, kako bi vas kasnije ako je potrebno, mogli konaktirati.\n" +
                        "<br><br>" +
                        "Kada ste unijeli sve podatke Kliknite na karticu 'PREGLED', gdje ćete moći pregledati unesene podatke, i izvršiti Slanje onečišćenja. Slanje se obavlja preko gumba 'PRIJAVI'. Nakon što je taj gumb kliknut, pitat će vas se da odaberete e-mail aplikaciju, preferirana aplikacija je Gmail. U E-mail aplikaciji moći ćete vidjeti pregled e-mail koji će se poslati nadležnim službama. <b>Konačno slanje se obavlja klikom GUMBA ZA SLANJE unutar e-mail aplikacije. </b>" +
                        "<br><br>" +
                        "Hvala Vam na korištenju EkoLokatora.";
                adb.setMessage(Html.fromHtml(uputeZaKoristenje));
                adb.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
