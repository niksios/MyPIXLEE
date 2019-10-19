package com.pixlee.pixleeandroidsdk;

import android.content.Context;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.pixlee.pixleeandroidsdk.adapter.CustomAdapter;
import com.pixlee.pixleesdk.PXLAlbum;
import com.pixlee.pixleesdk.PXLAlbumFilterOptions;
import com.pixlee.pixleesdk.PXLAlbumSortOptions;
import com.pixlee.pixleesdk.PXLAlbumSortType;
import com.pixlee.pixleesdk.PXLClient;
import com.pixlee.pixleesdk.PXLPhoto;

import java.util.ArrayList;

public class NewLayout extends AppCompatActivity implements PXLAlbum.RequestHandlers {

    private ArrayList<PXLPhoto> photoList;
    CustomAdapter customAdapter;
    private PXLAlbum album;
    RecyclerView recyclerView;
    ImageView img_prev, img_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);

        photoList = new ArrayList<>();

        // get the reference of RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        img_prev = (ImageView) findViewById(R.id.img_prev);
        img_next = (ImageView) findViewById(R.id.img_next);



        recyclerView.setHasFixedSize(true);
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        customAdapter = new CustomAdapter(NewLayout.this, photoList, this);

        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

        recyclerView.setItemAnimator(null);


        img_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int lastVisibleItemPosition = 0;
                int totalItemCount = staggeredGridLayoutManager.getItemCount();

                int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) staggeredGridLayoutManager).findFirstVisibleItemPositions(null);
                // get maximum element within the list
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);

                if ((lastVisibleItemPosition - 3) >= 0){

                    recyclerView.smoothScrollToPosition(lastVisibleItemPosition - 3);

                }
                else {


                }


               // recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView,new RecyclerView.State(), recyclerView.getAdapter().getItemCount());
               //recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView,new RecyclerView.State(), recyclerView.getAdapter().getItemCount());



            }
        });

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lastVisibleItemPosition = 0;
                int totalItemCount = staggeredGridLayoutManager.getItemCount();

                int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) staggeredGridLayoutManager).findFirstVisibleItemPositions(null);
                // get maximum element within the list
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);



                if ((lastVisibleItemPosition + 1) <= totalItemCount ){

                    recyclerView.smoothScrollToPosition(lastVisibleItemPosition + 1);

                }
                else {


                }


//                recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView,new RecyclerView.State(), recyclerView.getAdapter().getItemCount());
//                recyclerView.getAdapter().getItemId()



            }
        });

        //function calls
        createAlbum();

    }

    public int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            }
            else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }


    @Override
    public void DataLoadedHandler(ArrayList<PXLPhoto> photos) {
        if (photos == null) {
            return;
        }
        album.openedWidget();
        album.loadMore();
        this.photoList.clear();
        this.photoList.addAll(photos);



        customAdapter = new CustomAdapter(this, photoList, this);
        recyclerView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }

    @Override
    public void DataLoadFailedHandler(String error) {
        Log.e("pixlee", String.format("Failed to fetch next page of photos: %s", error));

    }


    private void createAlbum() {

        Context c = this.getApplicationContext();

        PXLClient.initialize("196i8ZzIAhKU8dO2kDe");
        // PXLClient.initialize("Yk5KeLohMugwQHJ4Go4b");

//        PXLClient.initialize("Yk5KeLohMugwQHJ4Go4b", "Oe4763af429125610b14928972");

        album = new PXLAlbum("4503434", c);
        // album = new PXLAlbum("1544", c);


        //PXLPdpAlbum pxlPdpAlbum = new PXLPdpAlbum(PXLClient.KeySku, c);
        PXLAlbumFilterOptions fo = new PXLAlbumFilterOptions();
        fo.minTwitterFollowers = 0;
        fo.minInstagramFollowers = 0;
        PXLAlbumSortOptions sortOptions = new PXLAlbumSortOptions();
        sortOptions.sortType = PXLAlbumSortType.RECENCY;
        sortOptions.descending = true;
        //album.setPerPage(15);
        //album.setFilterOptions(fo);
       // album.setSortOptions(sortOptions);
        album.loadNextPageOfPhotos(this);


    }
}
