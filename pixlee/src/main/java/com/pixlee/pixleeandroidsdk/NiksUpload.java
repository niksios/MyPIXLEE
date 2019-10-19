package com.pixlee.pixleeandroidsdk;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pixlee.pixleeandroidsdk.Fragmentss.Layout1;
import com.pixlee.pixleeandroidsdk.Fragmentss.Layout2;
import com.pixlee.pixleeandroidsdk.Fragmentss.Layout3;
import com.pixlee.pixleeandroidsdk.Fragmentss.Layout5;

public class NiksUpload extends AppCompatActivity {

    ImageView logo_exit;
    TextView txtcircle1_text, txtcircle2_text, txtcircle3_text, txtcircle4_text;
    TextView txtcircle1, txtcircle2, txtcircle3, txtcircle4;

    Toast exitToast;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.niks_upload_image);

        exitToast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);

        logo_exit = (ImageView) findViewById(R.id.logo_exit);

        txtcircle1 = (TextView) findViewById(R.id.txtcircle1);
        txtcircle2 = (TextView) findViewById(R.id.txtcircle2);
        txtcircle3 = (TextView) findViewById(R.id.txtcircle3);
        txtcircle4 = (TextView) findViewById(R.id.txtcircle4);

        txtcircle1_text = (TextView) findViewById(R.id.txtcircle1_text);
        txtcircle2_text = (TextView) findViewById(R.id.txtcircle2_text);
        txtcircle3_text = (TextView) findViewById(R.id.txtcircle3_text);
        txtcircle4_text = (TextView) findViewById(R.id.txtcircle4_text);


        Layout1 fragment1 = new Layout1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.niks_content, fragment1, "layout1");
        fragmentTransaction.commit();


        ///////////////////////////////////////////////////////////////////////////////////////
        //Mainactivity icon color change

//            //circles changed
//            txtcircle2.setBackgroundResource(R.drawable.rounded_textview2);
//            txtcircle3.setBackgroundResource(R.drawable.rounded_textview2);
//            txtcircle4.setBackgroundResource(R.drawable.rounded_textview2);
//
//            //circles text
//            txtcircle2.setTypeface(Typeface.create("sans-serif-condensed-light", Typeface.NORMAL));
//            txtcircle3.setTypeface(Typeface.create("sans-serif-condensed-light", Typeface.NORMAL));
//            txtcircle4.setTypeface(Typeface.create("sans-serif-condensed-light", Typeface.NORMAL));
        ///////////////////////////////////////////////////////////////////////////////////////

    }

    @Override
    public void onBackPressed() {

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.niks_content);

        if (currentFragment instanceof Layout1) {
            //   Log.v("niks", "your Fragment is Visible");

            if (exitToast.getView().isShown()) {
                exitToast.cancel();

                 finish();
                super.onBackPressed();


            } else {
                exitToast.show();
            }

        } else if (currentFragment instanceof Layout2) {

            txtcircle2.setBackgroundResource(R.drawable.rounded_textview2);
            txtcircle2.setTextColor(Color.GRAY);
            txtcircle2_text.setTypeface(txtcircle2_text.getTypeface(), Typeface.NORMAL);
            getSupportFragmentManager().beginTransaction().replace(R.id.niks_content, new Layout1(), "layout1").commit();


        } else if (currentFragment instanceof Layout3) {

            txtcircle3.setBackgroundResource(R.drawable.rounded_textview2);
            txtcircle3.setTextColor(Color.GRAY);
            txtcircle3_text.setTypeface(txtcircle3_text.getTypeface(), Typeface.NORMAL);
            getSupportFragmentManager().beginTransaction().replace(R.id.niks_content, new Layout2(), "layout2").commit();


        } else
//        if (currentFragment instanceof Layout4) {
//
//            txtcircle4.setBackgroundResource(R.drawable.rounded_textview2);
//            txtcircle4.setTextColor(Color.GRAY);
//            txtcircle4_text.setTypeface(txtcircle4_text.getTypeface(), Typeface.NORMAL);
//            getSupportFragmentManager().beginTransaction().replace(R.id.niks_content, new Layout3(), "layout3").commit();
//
//        }
            if (currentFragment instanceof Layout5) {

                getSupportFragmentManager().beginTransaction().replace(R.id.niks_content, new Layout1(), "layout1").commit();
            } else {
                super.onBackPressed();
            }


    }

}
