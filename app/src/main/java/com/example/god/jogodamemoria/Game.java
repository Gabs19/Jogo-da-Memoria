package com.example.god.jogodamemoria;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[][] imgBtn;

    private ImageButton btn;
    private GridLayout grid;
    private CardInfo[][] cardInfo;
    private ImageButton selected;
    public Estado estado;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        estado = Estado.NAO_VIRADA;
        grid = (GridLayout) findViewById(R.id.grid);
        grid.setColumnCount(8);
        imgBtn = new ImageButton[4][8];
        cardInfo = new CardInfo[4][8];

        for (int i = 0; i < imgBtn.length; i++) {
            for (int j = 0; j < imgBtn[i].length; j++) {

                btn = new ImageButton(this);
                btn.setImageResource(R.drawable.nvirada);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
                btn.setLayoutParams(layoutParams);
                imgBtn[i][j] = btn;
                grid.addView(btn);
                btn.setOnClickListener(this);
                cardInfo[i][j] = new CardInfo(j, R.drawable.nvirada);
                btn.setTag(cardInfo[i][j]);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageButton) {
            ImageButton button = (ImageButton) v;
            Context context = getApplicationContext();

            if (estado == Estado.NAO_VIRADA) {
                button.setImageResource(R.mipmap.ic_launcher_round);
                button.setEnabled(false);
                selected = button;
                estado = Estado.VIRADA;


            } else if (estado == Estado.VIRADA) {
                if (selected != button) {
                    CardInfo second = (CardInfo) button.getTag();
                    if (((CardInfo) selected.getTag()).getType() == second.getType()) {
                        button.setImageResource(R.mipmap.ic_launcher_round);
                        button.setEnabled(false);
                        CharSequence  text = "Você Acertou!!";
                        int duration  = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    } else {
                        selected.setImageResource(R.drawable.nvirada);
                        selected.setEnabled(true);
                    }
                }
                estado = Estado.NAO_VIRADA;
                selected = null;

                CharSequence  text = "Você Errou!!";
                int duration  = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context,text,duration);
                toast.show();
            }
        }
    }


}



