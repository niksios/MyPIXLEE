package com.pixlee.pixleeandroidsdk.Fragmentss;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixlee.pixleeandroidsdk.R;

public class Layout5 extends Fragment {

    Button btnDone;
    ImageView logo_exit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout5, container, false);

        btnDone = (Button)rootView.findViewById(R.id.btnDone);
        logo_exit = (ImageView) rootView.findViewById(R.id.logo_exit);


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ////exit app

                Layout1 ldf = new Layout1 ();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.niks_content, ldf);
                fragmentTransaction.commit();

                //Mainactivity icon color change
                TextView txtcircle4 =  getActivity().findViewById(R.id.txtcircle4);
                txtcircle4.setBackgroundResource(R.drawable.rounded_textview);
                txtcircle4.setTextColor(Color.WHITE);


                TextView txtcircle_text =  getActivity().findViewById(R.id.txtcircle3_text);
                txtcircle_text.setTypeface(txtcircle_text.getTypeface(), Typeface.BOLD);


            }
        });

        logo_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //exit app
                Layout1 ldf = new Layout1 ();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.niks_content, ldf, "layout1");
                fragmentTransaction.commit();


            }
        });


        return rootView;
    }



}
