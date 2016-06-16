package com.example.masimo.ekolokator.Tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.masimo.ekolokator.Evidencija;
import com.example.masimo.ekolokator.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

public class TabFragment2 extends Fragment {

    ImageView iv;
    private static final int SELECTED_PICTURE=1;
    public static final String LOG = "fragment2";
    public static boolean slika_postavljena = false;

    EditText opiss;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_2,
                container, false);
        Button dalje = (Button) view.findViewById(R.id.dalje);
        Button natrag = (Button) view.findViewById(R.id.natrag);
        Button odaberi = (Button) view.findViewById(R.id.dodaj_sliku);
        opiss = (EditText) view.findViewById(R.id.opisSlike);

        opiss.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    Evidencija.setOpis(opiss.getText().toString());
                }

            }
        });

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

        odaberi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokreniGaleriju();
            }
        });


        iv=(ImageView) view.findViewById(R.id.imgPicture);


        return view;
    }

    public void pokreniGaleriju(){
        Intent i=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, SELECTED_PICTURE);
    }


    public void dalje(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(2);
    }

    public void natrag(){
        final ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == SELECTED_PICTURE) {

                //Uri imageUri = data.getData();
                //Evidencija.setSlika(imageUri);

                // declare a stream to read the image data from the SD Card.
                InputStream inputStream;

                // we are getting an input stream, based on the URI of the image.
                try {

                    Bitmap tempPhoto = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                    //generiranje nove bitmap slike
                    tempPhoto = Bitmap.createScaledBitmap(tempPhoto, 1024,765, false);

                    // definiranje File intstance nove slike
                    File sdcard = Environment.getExternalStorageDirectory();
                    //Log.i("mojtag", sdcard.toString());
                    File dir = new File(sdcard.getAbsolutePath());
                    Log.i("mojtag",dir.toString());
                    dir.mkdir();
                    File file = new File(dir, "temp_ekolokator.jpg");

                    if(file.exists()) {
                        file.delete(); }

                    FileOutputStream os = new FileOutputStream(file);
                    tempPhoto.compress(Bitmap.CompressFormat.JPEG, 75, os);

                   // inputStream = getActivity().getContentResolver().openInputStream(tempimg);

                    // get a bitmap from the stream.
                    //Bitmap image = BitmapFactory.decodeStream(inputStream);
                    os.close();

                    // show the image to the user
                    iv.setImageBitmap(tempPhoto);
                    //flag za postavljenu sliku
                    slika_postavljena=true;

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    // show a message to the user indictating that the image is unavailable.
                    Toast.makeText(getActivity(), "Unable to open image", Toast.LENGTH_LONG).show();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }

    }



    @Override
    public void onResume(){
        super.onResume();

        if(slika_postavljena){
            String photoPath = Environment.getExternalStorageDirectory()+"/temp_ekolokator.jpg";
            Bitmap temp_slika = BitmapFactory.decodeFile(photoPath);
            iv.setImageBitmap(temp_slika);
        }


    }


}
