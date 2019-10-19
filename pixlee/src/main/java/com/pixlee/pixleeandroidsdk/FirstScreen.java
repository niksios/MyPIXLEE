package com.pixlee.pixleeandroidsdk;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pixlee.pixleeandroidsdk.Fragmentss.Layout1;

public class FirstScreen extends AppCompatActivity {

    ImageView image11, image22, image33, image44;

    Toast exitToast;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.firstscreen);

        exitToast = Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT);

        image11 = (ImageView)findViewById(R.id.image1);
        image22 = (ImageView)findViewById(R.id.image2);
        image33 = (ImageView)findViewById(R.id.image3);
        image44 = (ImageView)findViewById(R.id.image4);


        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Goto Niks Creation
                Intent i = new Intent(getApplicationContext(), NiksUpload.class);
                startActivity(i);

            }
        });

        image22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Goto PIXLEE Sample
                Intent i = new Intent(getApplicationContext(), SampleActivity.class);
                startActivity(i);

            }
        });

        image33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Goto PIXLEE Sample
                Intent i = new Intent(getApplicationContext(), NewLayout.class);
                startActivity(i);

            }
        });

        image44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Goto PIXLEE Sample
                Intent i = new Intent(getApplicationContext(), PixleeWebView.class);
                startActivity(i);

            }
        });





    }

    @Override
    public void onBackPressed(){

                  if (exitToast.getView().isShown()) {
                exitToast.cancel();
              //  finish();
                System.exit(0);
                //super.onBackPressed();
            } else {
                exitToast.show();
            }

    }

}
