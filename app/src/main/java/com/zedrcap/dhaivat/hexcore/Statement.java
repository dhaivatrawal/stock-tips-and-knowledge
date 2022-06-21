package com.zedrcap.dhaivat.hexcore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Statement extends AppCompatActivity {

    LinearLayout llone,lltwo,llthree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        llone=findViewById(R.id.llone);
        lltwo=findViewById(R.id.lltwo);
        llthree=findViewById(R.id.llthree);

        llone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),One.class);
                startActivity(intent);
            }
        });
        lltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Two.class);
                startActivity(intent);
            }
        });
        llthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Three.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.customtwo);

            // set the custom dialog components - text, image and button
            TextView title_law = (TextView) dialog.findViewById(R.id.title_law);
            title_law.setText("Stock Market - Begginer to Advance");
            TextView text = (TextView) dialog.findViewById(R.id.text);
            text.setText("This app is basically on Stock Market and its complete knowledge from Begginer to Intermediate to Advance and Different Strategies and techniques . A complete guide of Stock Market.");
            ImageView image = (ImageView) dialog.findViewById(R.id.image);
            image.setImageResource(R.mipmap.applogo);

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
        if (id == R.id.action_rate) {
            Intent a = new Intent(Intent.ACTION_SEND);
            final  String appPackageNAm = getApplicationContext().getPackageName();
            String strAppLink ="";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + appPackageNAm)));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageNAm)));
            }
        }
        if (id == R.id.action_share) {
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
            String sharebody = "This app is basically on Stock Market, Here you will learn Stock Market from Beginner to Intermediate to Advance. How to invest , When to invest, Where to invest, and Why to invest. Everything about the market and its movement and flow ."+ "\n " +
                    " Please Comment and Rate Us.\n " + "Download this Exclusive application and Share it." + "\n\n"+""+strAppLink;
            String sharesub = "APP NAME ";
            a.putExtra(Intent.EXTRA_SUBJECT,sharesub);
            a.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(a,"Share Using"));
        }
        if (id == R.id.action_more) {
            Intent intent= new Intent(getApplicationContext(),moreapps.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
