package slaves.merciful.com.projectnr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class gridThree extends AppCompatActivity {
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_three);
        mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //interestial

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed(){
                super.onAdClosed();
                finish();
            }
        });
        getSupportActionBar().setTitle(R.string.gridThree);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://eboardresults.com/app/");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
    }

    public void showInterestial(){
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        else{
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterestial();
    }
}
