package com.example.god.jogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.logging.Logger;

import static com.example.god.jogodamemoria.R.id.grid;


public class Game extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[][] imgBtn;
    private ImageButton btn;
    private GridLayout grid;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        grid = (GridLayout) findViewById(R.id.grid);
        grid.setColumnCount(4);
        imgBtn = new ImageButton[2][4];

        for (int i = 0; i < imgBtn.length; i++) {
            for (int j = 0; j < imgBtn[i].length; j++) {

                btn = new ImageButton(this);
                btn.setImageResource(R.mipmap.ic_launcher);
                imgBtn[i][j] = btn;
                grid.addView(btn);
                btn.setOnClickListener(this);

            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageButton) {
            for (int i = 0; i < imgBtn.length; i++) {
                for (int j = 0; j < imgBtn[i].length; j++) {
                    if (imgBtn[i][j].isPressed()) {
                        imgBtn[i][j].setImageResource(R.mipmap.ic_launcher_round);
                    }
                }
            }
        }
    }
}


