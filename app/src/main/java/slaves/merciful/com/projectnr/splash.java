package slaves.merciful.com.projectnr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class splash extends Activity {

    Animation frombottom, fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Button startButton = findViewById(R.id.startButton);
        ImageView logo = findViewById(R.id.logo);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        startButton.setAnimation(frombottom);
        logo.setAnimation(fromtop);

    }

    public void startButton(View view){
        Intent mintent = new Intent(this, Main2Activity.class);
        startActivity(mintent);
    }
}