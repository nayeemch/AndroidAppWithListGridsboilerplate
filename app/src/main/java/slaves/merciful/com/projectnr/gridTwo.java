package slaves.merciful.com.projectnr;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.webkit.WebView;

        import com.google.android.gms.ads.AdListener;
        import com.google.android.gms.ads.AdRequest;
        import com.google.android.gms.ads.AdView;
        import com.google.android.gms.ads.InterstitialAd;
        import com.google.android.gms.ads.MobileAds;


public class gridTwo extends AppCompatActivity {
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_one);

        getSupportActionBar().setTitle(R.string.gridTwo);


        setContentView(R.layout.activity_grid_two);
        WebView webView;
        webView =  findViewById(R.id.webview2);
        webView.loadUrl("file:///android_asset/adam.html");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);

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

        getSupportActionBar().setTitle(R.string.gridOne);


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
