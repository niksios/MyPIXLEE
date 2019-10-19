package com.pixlee.pixleeandroidsdk;


import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class GridViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public NetworkImageView netImg;
  //  public ImageView netImg2;

    public GridViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.title);
        netImg = (NetworkImageView) view.findViewById(R.id.netimg);
      //  netImg2 = (ImageView) view.findViewById(R.id.netimg2);
    }
}
