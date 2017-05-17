package com.example.god.jogodamemoria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.ProgressBar;

/**
 * Created by god on 12/05/17.
 */

public class SplashScreen extends FragmentActivity implements Runnable{

    private ProgressBar rodinha;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        rodinha = (ProgressBar) findViewById(R.id.roda);
        rodinha.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FF4C35"), PorterDuff.Mode.MULTIPLY);
        rodinha.postDelayed(this, 5000);
    }
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, GameScreen.class);
                startActivity(intent);
                finish();
            }

    }


