package com.example.god.jogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.logging.Logger;


public class Game extends AppCompatActivity implements View.OnClickListener {

    private Button[][] imgBtn;
    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //
        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        grid.setColumnCount(4);
        imgBtn = new Button[2][4];

        for (int i = 0; i < imgBtn.length; i++) {
           for (int j = 0; j < imgBtn[i].length; j++) {


            Button btn = new Button(getApplicationContext());
            btn.setText("" + i + "," + j);
            imgBtn[i][j] = btn;
            grid.addView(btn);
            btn.setOnClickListener(this);

                /*View v = grid.getChildAt(i);

                if (v instanceof ImageButton) {
                    ImageButton ib = new ImageButton(this);
                    // adicionar botão no grid
                    //                    grid.
//                                grid.add
                    imgBtn[i][j] = (ImageButton) grid.getChildAt(i);
                }*/
            }
        }
    }
    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            CharSequence text = ((Button) v).getText();
            Log.d("CARD", text.toString());
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
    }
}


