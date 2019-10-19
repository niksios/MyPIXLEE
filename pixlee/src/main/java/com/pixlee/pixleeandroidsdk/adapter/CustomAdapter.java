package com.pixlee.pixleeandroidsdk.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.pixlee.pixleeandroidsdk.NewLayout;
import com.pixlee.pixleeandroidsdk.OnItemClick;
import com.pixlee.pixleeandroidsdk.R;
import com.pixlee.pixleeandroidsdk.SampleActivity;
import com.pixlee.pixleesdk.PXLClient;
import com.pixlee.pixleesdk.PXLPhoto;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<PXLPhoto> galleryList;
    private Context context;
    private ImageLoader imageLoader;
    private NewLayout saref;

    public CustomAdapter(Context context, ArrayList<PXLPhoto> galleryList, NewLayout sa) {
        this.context = context;
        this.galleryList = galleryList;
        this.imageLoader = PXLClient.getInstance(context).getImageLoader();
        this.saref = sa;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final PXLPhoto photo = galleryList.get(position);
        final String title = photo.email_address;

        if (photo.cdnOriginalUrl !=  null) {

            try {

                holder.image.setImageUrl(photo.cdnOriginalUrl.toString(), imageLoader);
                holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);

            }catch (Exception e){

                e.printStackTrace();
            }

        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String image_url = photo.cdnOriginalUrl.toString();


                Intent i = new Intent(context, OnItemClick.class);
                i.putExtra("image_url", image_url);
                i.putExtra("title", title);
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        // init the item view's
        NetworkImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            image = (NetworkImageView) itemView.findViewById(R.id.image);


        }
    }
}


