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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pixlee.pixleeandroidsdk.R;
import com.pixlee.pixleesdk.PXLAlbum;

public class Layout4 extends Fragment {

    EditText edt_email, edt_name;
    Button btnSubmit;
    RadioButton radioAgree;

    String imgPath= "";
    String imgDetails= "";
    PXLAlbum album;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout4, container, false);


        edt_email = (EditText)rootView.findViewById(R.id.edt_email);
        edt_name = (EditText)rootView.findViewById(R.id.edt_name);

        radioAgree = (RadioButton)rootView.findViewById(R.id.radioAgree);

        btnSubmit = (Button)rootView.findViewById(R.id.btnSubmit);

        /////////////////////////////////////////
        imgPath = getArguments().getString("Image");
        imgDetails = getArguments().getString("Image_Details");

        /////////////////////////////////////////

        //Mainactivity icon color change
        TextView txtcircle4 =  getActivity().findViewById(R.id.txtcircle4);
        txtcircle4.setBackgroundResource(R.drawable.rounded_textview);
        txtcircle4.setTextColor(Color.WHITE);

        TextView txtcircle_text =  getActivity().findViewById(R.id.txtcircle4_text);
        txtcircle_text.setTypeface(txtcircle_text.getTypeface(), Typeface.BOLD);

        //button click event
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm = edt_name.getText().toString();
                String eml = edt_email.getText().toString();

                if (nm.equals("") || eml.equals("")){

                    Toast.makeText(getContext(), "Please enter FullName and Email!!", Toast.LENGTH_SHORT).show();

                }

                else {

                    // body.put("album_id",  Integer.parseInt(this.id));
                    //            body.put("title", title);
                    //            body.put("email", email);
                    //            body.put("username", username);
                    //            body.put("photo_uri", photoURI);
                    //            body.put("approved", approved);


                    //album.uploadImage("test", "kb@pixleeteam.com", "K.B.", "https://nikshahane003.000webhostapp.com/pixlee_images/image1.jpg", true);

                   //album = new PXLAlbum("4503434", c);
                    album = new PXLAlbum("4503434", getContext());

                   album.uploadImage(nm, eml, nm ,imgPath, true );

                        Toast.makeText(getContext(), "Success!!", Toast.LENGTH_SHORT).show();

                        Layout5 ldf = new Layout5 ();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.niks_content, ldf, "layout5");
                        fragmentTransaction.commit();




                }



            }
        });


        return rootView;
    }



}
