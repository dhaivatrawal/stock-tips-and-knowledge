package com.zedrcap.dhaivat.hexcore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;

public class howto extends AppCompatActivity {
   // private AdView adView2,adView3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howto);
        AudienceNetworkAds.initialize(this);

        // top banner add
      //  adView2 = new AdView(this, "936092000105067_1003485546699045", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
      //  LinearLayout adContainer2 = (LinearLayout) findViewById(R.id.banner_container2);

        // Add the ad view to your activity layout
     //   adContainer2.addView(adView2);

        // Request an ad
       // adView2.loadAd();

       // AudienceNetworkAds.initialize(this);

        // top banner add
      //  adView3 = new AdView(this, "936092000105067_1003549600025973", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
      //  LinearLayout adContainer3 = (LinearLayout) findViewById(R.id.banner_container3);

        // Add the ad view to your activity layout
     //   adContainer3.addView(adView3);

        // Request an ad
      //  adView3.loadAd();
    }
}
