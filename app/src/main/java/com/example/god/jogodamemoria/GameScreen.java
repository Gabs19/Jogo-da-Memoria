package com.example.god.jogodamemoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
//
        Button Jogar = (Button) findViewById(R.id.Jogar);

        Jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent game  = new Intent(GameScreen.this,Game.class);
                startActivity(game);
            }
        });

        Button sobre = (Button) findViewById(R.id.sobre);

        sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sobre = new Intent(GameScreen.this,Sobre.class);
                startActivity(sobre);
            }
        });
    }
}
