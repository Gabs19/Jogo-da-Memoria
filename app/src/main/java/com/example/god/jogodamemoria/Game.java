package com.example.god.jogodamemoria;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[] imgBtn;

    private ImageButton btn;
    private GridLayout grid;
    //private CardInfo[] cardInfo;
    private ImageButton selected;
    public Estado estado;
    public int resources[] = {
            R.mipmap.calunga,
            R.mipmap.capela_bjesus,
            R.mipmap.capela_rosario,
            R.mipmap.comes_damiao,
            R.mipmap.coroa_aviao,
            R.mipmap.refugio,
            R.mipmap.sitio_marcos,
            R.mipmap.velho_faceta
    };///////

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
        imgBtn = new ImageButton[16];
        //cardInfo = new CardInfo[32];

        for (int i = 0; i < imgBtn.length; i++) {
                btn = new ImageButton(this);
                btn.setImageResource(R.drawable.nvirada);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
                btn.setLayoutParams(layoutParams);
                imgBtn[i] = btn;

                grid.addView(btn);
                btn.setOnClickListener(this);
                btn.setTag(new CardInfo(resources[i % 8]));
            }
        }


    @Override
    public void onClick(View v) {
        if (v instanceof ImageButton) {
            ImageButton button = (ImageButton) v;
            Context context = getApplicationContext();
            CardInfo cardInfo = (CardInfo) button.getTag();


            if (estado == Estado.NAO_VIRADA) {
                button.setImageResource(cardInfo.getResource());
                button.setEnabled(false);
                selected = button;
                estado = Estado.VIRADA;


            } else if (estado == Estado.VIRADA) {
                if (selected != button) {
                    if (((CardInfo) selected.getTag()).getResource() == cardInfo.getResource()) {
                        button.setImageResource(cardInfo.getResource());
                        button.setEnabled(false);
                        CharSequence  text = "Você Acertou!!";
                        int duration  = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    } else {
                        selected.setImageResource(R.mipmap.ic_costas);
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



