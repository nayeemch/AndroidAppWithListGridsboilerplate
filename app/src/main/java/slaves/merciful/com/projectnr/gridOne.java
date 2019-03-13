package slaves.merciful.com.projectnr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class gridOne extends AppCompatActivity {
    private AdView mAdView;

    private InterstitialAd mInterstitialAd;


    private List<Object> mRecyclerViewItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_one);

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

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(this, mRecyclerViewItems);
        mRecyclerView.setAdapter(adapter);

        addMenuItemsFromJson();

    }

    private void addMenuItemsFromJson() {
        try {
            String jsonDataString = readJsonDataFromFile();
            JSONArray menuItemsJsonArray = new JSONArray(jsonDataString);

            for (int i = 0; i < menuItemsJsonArray.length(); ++i) {

                JSONObject menuItemObject = menuItemsJsonArray.getJSONObject(i);

                String menuItemName = menuItemObject.getString("subjectName");
                String menuItemDescription = menuItemObject.getString("time");
                String menuItemPrice = menuItemObject.getString("date");
                String menuItemCategory = menuItemObject.getString("subjectCode");
                String menuItemImageName = menuItemObject.getString("photo");

                Pojo pojo = new Pojo(menuItemName, menuItemDescription, menuItemPrice,
                        menuItemCategory, menuItemImageName);
                mRecyclerViewItems.add(pojo);
            }
        } catch (IOException | JSONException exception) {
            Log.e(gridThree.class.getName(), "Unable to parse JSON file.", exception);
        }
    }

    private String readJsonDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            String jsonDataString = null;
            inputStream = getResources().openRawResource(R.raw.ssc);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            while ((jsonDataString = bufferedReader.readLine()) != null) {
                builder.append(jsonDataString);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return new String(builder);
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
