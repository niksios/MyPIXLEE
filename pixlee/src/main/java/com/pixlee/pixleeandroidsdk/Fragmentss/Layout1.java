package com.pixlee.pixleeandroidsdk.Fragmentss;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.*;


import com.pixlee.pixleeandroidsdk.R;


public class Layout1 extends Fragment {

    ImageView image11, image22, image33, image44;
    TextView txt11, txt22, txt33, txt44;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private String userChoosenTask;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.layout1, container, false);

        image11 = (ImageView)rootView.findViewById(R.id.image11);
        image22 = (ImageView)rootView.findViewById(R.id.image22);
        image33 = (ImageView)rootView.findViewById(R.id.image33);
        image44 = (ImageView)rootView.findViewById(R.id.image44);

        txt11 = (TextView)rootView.findViewById(R.id.txt11);
        txt22 = (TextView)rootView.findViewById(R.id.txt22);
        txt33 = (TextView)rootView.findViewById(R.id.txt33);
        txt44 = (TextView)rootView.findViewById(R.id.txt44);






                //Desktop Icon selected
        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //On click open layout 2
                Layout2 fragment2 = new Layout2();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.niks_content, fragment2, "layout2");
                fragmentTransaction.commit();


            }
        });



        return rootView;
    }


}
