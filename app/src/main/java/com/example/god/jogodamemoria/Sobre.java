package com.example.god.jogodamemoria;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sobre extends FragmentActivity {
  private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        text = (TextView) findViewById(R.id.texto);
        text.setText("Projeto de Extensão do Instituto\n" +
                "Federal de Pernambuco - Campus Igarassu\n" +
                "\n" +
                "\tCriadores:\n" +
                "\n" +
                "\tGabriel Lima Gonçalves da Silva" +
                "\n" +
                "\tJóse Gabriel Vicente das Neves da Silva\n" +
                "\n" +
                "\tOrientador:\n" +
                "\n" +
                "\tAllan Diego Silva Lima");
    }
}