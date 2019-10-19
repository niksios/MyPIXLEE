package com.pixlee.pixleeandroidsdk;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PixleeWebView extends AppCompatActivity {

    WebView webView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pixleewebview);



        webView = (WebView) findViewById(R.id.webview);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://www.pixlee.com/");


      //  webView.loadUrl("view-source:https://photos.pixlee.com/uploader?widget_id=1654881&api_key=Yk5KeLohMugwQHJ4Go4b");

        //webView.loadUrl("https://distillery.pixlee.com/api/v2/albums/5555556/photos?api_key=Yk5KeLohMugwQHJ4Go4b"); //Yk5KeLohMugwQHJ4Go4b
       // webView.loadUrl("https://www.pixlee.com/"); //Yk5KeLohMugwQHJ4Go4b
        //https://distillery.pixlee.com/api/v2/albums/4503434/photos?api_key=196i8ZzIAhKU8dO2kDe&per_page=15&filters={"min_instagram_followers":"0","min_twitter_followers":"0"}&sort={"dynamic":true,"desc":true}&page=1

        webView.setWebViewClient(new MyWebViewClient());





    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}
