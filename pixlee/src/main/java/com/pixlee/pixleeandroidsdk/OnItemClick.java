package com.pixlee.pixleeandroidsdk;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.squareup.picasso.Picasso;

public class OnItemClick extends AppCompatActivity {

    ImageView image_preview;
    private ImageLoader imageLoader;
    TextView txt_description;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onitemclickview);

        image_preview = (ImageView)findViewById(R.id.image_preview);
        txt_description = (TextView) findViewById(R.id.txt_description);

        Intent i = getIntent();
        String image_url = i.getStringExtra("image_url");
        String title = i.getStringExtra("title");

        Picasso.get()
                    .load(image_url)
                    .into(image_preview);


        ///////////////////////////////////////////////////////////////////////
        txt_description.setText(title);
        ///////////////////////////////////////////////////////////////////////



    }

}
