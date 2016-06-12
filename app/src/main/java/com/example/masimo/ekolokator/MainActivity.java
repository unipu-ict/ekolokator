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
                adb.setMessage("Lorem ipsum dolor sit amet, vix probatus forensibus te. Sed ex diceret detraxit, ad cum accusam omittam, no mucius repudiare eam. Te nostrum referrentur voluptatibus per. Vix habeo dicta tantas in. Ne ferri delicata sadipscing est, est quando impedit epicuri eu. Ipsum dictas no vis.\n" +
                        "\n" +
                        "Sed at veri libris, eu disputando persequeris eos. Unum vituperata eum ad, propriae officiis cu vis, id sint putent eos. Ad quod audire nec, no sea luptatum tincidunt. Usu te aeterno corpora principes, te autem virtute aliquid eos. No alii appetere vis, his latine accumsan suscipiantur ad. Dolorem ceteros suscipiantur te vis, vel elit rebum incorrupte te.\n" +
                        "\n" +
                        "Eu eos recusabo convenire assentior. An sumo percipit persecuti vix, appareat vulputate at sit, eros brute adversarium no nam. Rebum velit his cu. Putant oporteat pro at, vix tale etiam indoctum ei, ut omnium mentitum duo. Pri ut congue voluptatibus.");
                adb.show();
                /*Toast toast = Toast.makeText(this, "Aktivnost koja prikazuje tko je izašto napravio aplikaciju", Toast.LENGTH_SHORT);
                toast.show();*/
                return true;

            case R.id.upute:
                adb.setTitle(getString(R.string.upute));
                adb.setMessage(getString(R.string.opis_aplikacije));
                adb.show();
                /*Toast tost = Toast.makeText(this, "Aktivnost koja prikazuje na upute o korištenju aplikacije", Toast.LENGTH_SHORT);
                tost.show();*/
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
