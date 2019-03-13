package slaves.merciful.com.projectnr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        CardView gridOne =  findViewById(R.id.gridOne);
        CardView gridTwo =  findViewById(R.id.gridTwo);
        CardView gridThree =  findViewById(R.id.gridThree);
        CardView gridFour =  findViewById(R.id.gridFour);
        gridOne.setOnClickListener(this);
        gridTwo.setOnClickListener(this);
        gridThree.setOnClickListener(this);
        gridFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.gridOne : i = new Intent(this,gridOne.class);
            startActivity(i);
            break;
            case R.id.gridTwo : i = new Intent(this,gridTwo.class);
                startActivity(i);
                break;
            case R.id.gridThree : i = new Intent(this,gridThree.class);
                startActivity(i);
                break;
            case R.id.gridFour : i = new Intent(Intent.ACTION_VIEW,Uri.parse("market://search?q=pub:Creative Apps BD"));
                startActivity(i);
                break;
            default:break;
        }


    }
}
