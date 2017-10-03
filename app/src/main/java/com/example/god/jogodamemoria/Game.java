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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.logging.Logger;

import static com.example.god.jogodamemoria.R.id.grid;


public class Game extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[][] imgBtn;
    private ImageButton btn;
    private GridLayout grid;
    private CardInfo [][] cardInfo;
    private ImageButton selected;

    public int count = 0;

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
        cardInfo = new CardInfo[2][4];

        for (int i = 0; i < imgBtn.length; i++) {
            for (int j = 0; j < imgBtn[i].length; j++) {

                btn = new ImageButton(this);
                btn.setImageResource(R.mipmap.ic_launcher);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,150);
                btn.setLayoutParams(layoutParams);
                imgBtn[i][j] = btn;
                grid.addView(btn);
                btn.setOnClickListener(this);
                cardInfo[i][j] = new CardInfo(j, R.mipmap.ic_launcher);
                btn.setTag(cardInfo[i][j]);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageButton) {
            ImageButton button = (ImageButton) v;

            if(count == 0){
                button.setImageResource(R.mipmap.ic_launcher_round);
                button.setEnabled(false);
                selected = button;
                count++;
            }
        else if (count == 1){
                if (selected != button) {
                    CardInfo second = (CardInfo) button.getTag();
                    if (((CardInfo) selected.getTag()).getType() == second.getType()) {
                        button.setImageResource(R.mipmap.ic_launcher_round);
                        button.setEnabled(false);
                    } else {
                        selected.setImageResource(R.mipmap.ic_launcher);
                        selected.setEnabled(true);
                    }
                }

                count = 0;
                selected = null;
            }
        }
    }


}



