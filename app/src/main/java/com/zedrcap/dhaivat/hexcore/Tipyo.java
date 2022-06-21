package com.zedrcap.dhaivat.hexcore;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tipyo extends AppCompatActivity {

    Context context = this;
    DatabaseReference databaseReference;
    public static final String Database_Path = "stockdata-3bc03";
    private LinearLayoutManager mLayoutManager;
    ProgressDialog progressDialog;
    ImageView shareapp;
    private AdView adView4 ;
    private InterstitialAd interstitialAd;
    private final String TAG = Tipyo.class.getSimpleName();

    List<trading> list = new ArrayList<>();

    RecyclerView recview;

    RecyclerView.Adapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipyo);
        AudienceNetworkAds.initialize(this);

        // top banner add
        adView4 = new AdView(this, "936092000105067_1003713750009558", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer4 = (LinearLayout) findViewById(R.id.banner_container4);

        // Add the ad view to your activity layout
        adContainer4.addView(adView4);

        // Request an ad
        adView4.loadAd();
        shareapp = findViewById(R.id.shareapp);
        recview = (RecyclerView) findViewById(R.id.recview);

        recview.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //recyclerView.setLayoutManager(new LinearLayoutManager(ShowStudentDetailsActivity.this));
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);// THIS ALSO SETS setStackFromBottom to true
        recview.setLayoutManager(mLayoutManager);


        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation aniBounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                shareapp.startAnimation(aniBounce);


                Intent a = new Intent(Intent.ACTION_SEND);
                final  String appPackageNAme = getApplicationContext().getPackageName();
                String strAppLink ="";

                try
                {
                    strAppLink = "http://play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                catch (android.content.ActivityNotFoundException anfe)
                {
                    strAppLink = "https:/play.google.com/store/apps/details?id=" + appPackageNAme;
                }
                a.setType("text/link");
                String sharebody = "*Want to Earn Infinite Money ?*\n\n" +
                        "We provide daily *'Stock Market'- Intraday Tips* for Free. With proper StopLoss and Target Profit with least risk reward ratio . \n\n" +
                        "Escape from the Rat Race of world and get Financial Freedom. Just follow our daily tips and get maximum % of Accuracy in Stock Market. Be the king of the Market. \n" + strAppLink;
                String sharesub = "APP NAME ";
                a.putExtra(Intent.EXTRA_SUBJECT,sharesub);
                a.putExtra(Intent.EXTRA_TEXT,sharebody);
                startActivity(Intent.createChooser(a,"Share Using"));

            }
        });


       // recview.setLayoutManager(new LinearLayoutManager(Tipyo.this));

         progressDialog = new ProgressDialog(Tipyo.this);

        progressDialog.setMessage("Loading Data");


        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    trading trade = dataSnapshot.getValue(trading.class);


                    list.add(trade);
                }

                adapter = new RecyclerViewAdapter(Tipyo.this, list);

                recview.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                progressDialog.dismiss();

            }
        });
    }
    private void intrestrialads()
    {
        interstitialAd = new InterstitialAd(this, "936092000105067_1003706053343661");
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        intrestrialads();

    }
    @Override
    protected void onDestroy() {
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}
