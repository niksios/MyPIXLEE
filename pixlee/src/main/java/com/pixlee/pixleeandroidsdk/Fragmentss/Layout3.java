package com.pixlee.pixleeandroidsdk.Fragmentss;

import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixlee.pixleeandroidsdk.R;

public class Layout3 extends Fragment {


    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;
    ImageView image_display, imagedelete;
    EditText edit_details;
    Button btnNext;

    String imgPath= "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout3, container, false);


        image_display = (ImageView)rootView.findViewById(R.id.image_display);
        imagedelete = (ImageView)rootView.findViewById(R.id.imagedelete);

        edit_details = (EditText)rootView.findViewById(R.id.edit_details);

        btnNext = (Button)rootView.findViewById(R.id.btnNext);

        imgPath = getArguments().getString("Image");

        Uri uri = Uri.parse(imgPath);

        try{

            if(uri != null)
            {
                image_display.setImageURI(uri);

            }
            else {

                image_display.setImageResource(R.mipmap.icon_facebook);
            }
        }catch (Exception e){

            e.printStackTrace();
        }






//        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(new File(imgPath)));
//        image_display.setImageBitmap(bitmap);

        //Mainactivity icon color change
        TextView txtcircle3 =  getActivity().findViewById(R.id.txtcircle3);
        txtcircle3.setBackgroundResource(R.drawable.rounded_textview);
        txtcircle3.setTextColor(Color.WHITE);

        TextView txtcircle_text =  getActivity().findViewById(R.id.txtcircle3_text);
        txtcircle_text.setTypeface(txtcircle_text.getTypeface(), Typeface.BOLD);


        //delete click event
        imagedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit_details.setText("");
                image_display.setImageResource(0);

            }
        });

        //button click event
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String image_details = edit_details.getText().toString();

                Layout4 ldf = new Layout4 ();
                Bundle args = new Bundle();
                args.putString("Image", imgPath);
                args.putString("Image_Details", image_details);
                ldf.setArguments(args);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.replace(R.id.niks_content, ldf, "layout4");

                fragmentTransaction.commit();



            }
        });


        return rootView;
    }



}
