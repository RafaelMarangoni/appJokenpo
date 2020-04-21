package com.udemy.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView pedra, papel, tesoura, imageResultado;
    TextView textResultado;
    //HashMap<Double, Double>;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        imageResultado = findViewById(R.id.jogadaDoApp);
        textResultado = findViewById(R.id.resultado_jogo);

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadoPedra();
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadoPapel();
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadoTesoura();
            }
        });
    }

    public void selecionadoPedra(){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoTesoura(){
        this.opcaoSelecionada("tesoura");
    }

    public void selecionadoPapel(){
        this.opcaoSelecionada("papel");
    }

    public void opcaoSelecionada(String escolhaUsuario){


        int numero = new Random().nextInt(3);
        String[]  opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
        }

        if(
                (escolhaApp.equals("tesoura") && escolhaUsuario == "papel")||
                (escolhaApp.equals("papel") && escolhaUsuario == "pedra") ||
                (escolhaApp.equals("pedra") && escolhaUsuario == "tesoura")
        ){
            textResultado.setText("App ganhou");
        }else if (
                (escolhaApp == "tesoura" && escolhaUsuario == "tesoura")||
                (escolhaApp == "papel" && escolhaUsuario == "papel") ||
                (escolhaApp == "pedra" && escolhaUsuario == "pedra")

        ){
            textResultado.setText("empate");
        }
        else{
            textResultado.setText("player ganhou");
        }

    }



}
