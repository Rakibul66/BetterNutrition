package com.better.nutritiontherapy;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.reward.RewardItem;
//import com.google.android.gms.ads.reward.RewardedVideoAd;
//import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import com.startapp.sdk.adsbase.StartAppAd;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ViewBookActivity extends AppCompatActivity {
    //implements RewardedVideoAdListener
    //   private WebView webView;
    private WebView webView;
    String pdfurl = null;
    ImageView back;
    // videoadd
   // RewardedVideoAd rewardedVideoAd;
    //
    AlertDialog dialog;
    ProgressBar progressBarWeb;
    ProgressDialog progressDialog;
    RelativeLayout relativeLayout;
    Button btnNoInternetConnection;
    SwipeRefreshLayout swipeRefreshLayout;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_book);


        //videoadd
        // Show Dialog Code


        final Intent intent = getIntent();
        pdfurl = intent.getStringExtra("url");
        Log.e("URL", "onCreate: " + pdfurl);


        webView = findViewById(R.id.webview);
        //  back = findViewById(R.id.back);
//       progressBar = findViewById(R.id.progressBar);
//        progressBar.setVisibility(View.VISIBLE);
        progressBarWeb = (ProgressBar) findViewById(R.id.progressBar);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait");

        btnNoInternetConnection = (Button) findViewById(R.id.btnNoConnection);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.YELLOW, Color.GREEN);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                webView.reload();
            }
        });

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {

            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(false);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.setWebChromeClient(new WebChromeClient());
            checkConnection();

        }


//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (rewardedVideoAd.isLoaded()) {
//                    rewardedVideoAd.show();
//                }
//
//            }
//        });


//        //Rewarded Video Ads Codes
//        MobileAds.initialize(this, getString(R.string.APP_ID));
//        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
//        rewardedVideoAd.setRewardedVideoAdListener(this);
//        loadRewardedVideoAd();

        //Solved WebView SwipeUp Problem
        webView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (webView.getScrollY() == 0) {
                    swipeRefreshLayout.setEnabled(true);
                } else {
                    swipeRefreshLayout.setEnabled(false);
                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBarWeb.setVisibility(View.VISIBLE);
                progressBarWeb.setProgress(newProgress);
                setTitle("Loading...");
                progressDialog.show();
                if (newProgress == 100) {

                    progressBarWeb.setVisibility(View.GONE);
                    setTitle(view.getTitle());
                    progressDialog.dismiss();

                }


                super.onProgressChanged(view, newProgress);
            }
        });


        btnNoInternetConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConnection();
            }
        });

    }
    public void checkConnection () {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        if (wifi.isConnected()) {
            webView.loadUrl(pdfurl);
            webView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);


        } else if (mobileNetwork.isConnected()) {
            webView.loadUrl(pdfurl);
            webView.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
        } else {

            webView.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.VISIBLE);

        }


        //
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {

              /*  webView.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");*/
                //progressBar.setVisibility(View.GONE);

            }
        });

        String urlencode = null;

        if (pdfurl == null) {
            Toast.makeText(this, "URL NOT FOUND!!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            urlencode = URLEncoder.encode(pdfurl, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + urlencode);

    }

    @Override
    public void onBackPressed() {
        StartAppAd.onBackPressed(this);
        super.onBackPressed();
    }
}




