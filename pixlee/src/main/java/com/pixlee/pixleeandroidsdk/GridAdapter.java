package com.pixlee.pixleeandroidsdk;

import android.content.Context;


import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.pixlee.pixleesdk.PXLClient;
import com.pixlee.pixleesdk.PXLPhoto;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {
    private ArrayList<PXLPhoto> galleryList;
    private Context context;
    private ImageLoader imageLoader;
    private SampleActivity saref;

    public GridAdapter(Context context, ArrayList<PXLPhoto> galleryList, SampleActivity sa) {
        this.galleryList = galleryList;
        this.context = context;
        this.imageLoader = PXLClient.getInstance(context).getImageLoader();
        this.saref = sa;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder viewHolder, int i) {
        final PXLPhoto photo = galleryList.get(i);
        viewHolder.title.setText(photo.photoTitle);

        if (photo.cdnOriginalUrl !=  null) {

            try{

                viewHolder.netImg.setImageUrl(photo.cdnOriginalUrl.toString(), imageLoader);
                viewHolder.netImg.setScaleType(ImageView.ScaleType.CENTER_CROP);

            }
            catch (Exception e){

                e.printStackTrace();
            }

//            URL url = null;
//            try {
//                url = new URL("http://image10.bizrate-images.com/resize?sq=60&uid=2216744464");
//                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                viewHolder.netImg.setImageBitmap(bmp);
//
//
//                viewHolder.netImg.setImageUrl(photo.cdnOriginalUrl.toString(), imageLoader);
//                viewHolder.netImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Picasso.get()
//                    .load(photo.cdnOriginalUrl.toString())
//                    .into(viewHolder.netImg2);
//
//            Log.e("photo.thumbnailUrl",""+photo.cdnOriginalUrl.toString());




            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saref.switchVisibilities(photo);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (galleryList  != null) {
            return galleryList.size();
        }
        return 0;
    }
}
