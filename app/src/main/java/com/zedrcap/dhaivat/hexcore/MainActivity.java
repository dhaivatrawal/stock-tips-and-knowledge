package com.zedrcap.dhaivat.hexcore;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
ImageView circle_img , rateapp, shareapp , arrow, button;
TextView txttwo;
Button btnintraday;
//private AdView adView ;


    Context context = this;
    DatabaseReference databaseReference;
    public static final String Database_Path = "stockdata-3bc03";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //    AudienceNetworkAds.initialize(this);

        // top banner add
//        adView = new AdView(this, "936092000105067_1003674653346801", AdSize.BANNER_HEIGHT_50);
//
//        // Find the Ad Container
//        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
//
//        // Add the ad view to your activity layout
//        adContainer.addView(adView);
//
//        // Request an ad
//        adView.loadAd();


    databaseReference = FirebaseDatabase.getInstance().getReference(Database_Path);


        animation();

        button = (ImageView) findViewById(R.id.buttonShowCustomDialog);

        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.custom);

                // set the custom dialog components - text, image and button
                TextView title_law = (TextView) dialog.findViewById(R.id.title_law);
                title_law.setText("PRIVACY POLICY");
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("We encourage all investors to use the information on the application as a resource only to further their own research on all featured companies, stocks, sectors, markets and information presented on the App. \n \n" +
                        "With investment, your capital is at risk. The value of your portfolio can go down as well as up and you may get back less than you invest. A Stock,Commodity & Currency may not be right fit for everyone. \n \n "+
                        "Investing/Trading is subject to market risk. We are not responsible for any Profit or Loss. ");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.mipmap.app_logo);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });

                dialog.show();

            }
        });



    }

    private void animation() {

        ImageView img = (ImageView)findViewById(R.id.circle_img);
        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        img.startAnimation(aniRotate);



        rateapp = findViewById(R.id.rateapp);
        arrow = findViewById(R.id.arrow);
        shareapp = findViewById(R.id.shareapp);
        txttwo = findViewById(R.id.txttwo);

        rateapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation aniBounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                rateapp.startAnimation(aniBounce);


                Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
                }


               /* String AppId = "market://details?id= "+ getPackageName();
                Intent myIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(AppId));
                startActivity(myIntent);*/

            }
        });
        shareapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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


                /*Intent myintent = new Intent(Intent.ACTION_SEND);
                String AppShareText = "*Want to Earn Infinite Money ?*\n\n" +
                        "We provide daily *'Stock Market'- Intraday Tips* for Free. With proper StopLoss and Target Profit with least risk reward ratio . \n\n" +
                        "Escape from the Rat Race of world and get Financial Freedom. Just follow our daily tips and get maximum % of Accuracy in Stock Market. Be the king of the Market. \n" +
                        Uri.parse("https://play.google.com/store/apps/details?id = " + getPackageName());
                myintent.setType("text/plain");
                myintent.putExtra(Intent.EXTRA_TEXT,AppShareText);
                startActivity(Intent.createChooser(myintent,"Share this"));*/


        });
        txttwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniZoomout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
                txttwo.startAnimation(aniZoomout);

                Intent intent = new Intent(getApplicationContext(),howto.class);
                startActivity(intent);

            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniZoomout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
                arrow.startAnimation(aniZoomout);

                Intent intent = new Intent(getApplicationContext(),Statement.class);
                startActivity(intent);

            }
        });

        btnintraday=findViewById(R.id.btnintraday);
        //Button btn = (Button)findViewById(R.id.btnintraday);
        Animation btnbounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bouncebtn);
        btnintraday.startAnimation(btnbounce);

        btnintraday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(getApplicationContext(),Tipyo.class);
                startActivity(i);
            }
        });

    }



}
