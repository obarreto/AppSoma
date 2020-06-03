package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsoma.entities.Operacoes;

public class MainActivity extends AppCompatActivity {

    public static final long TEMPO_ESPERA = 2000;
    //TextView textView;
    EditText textPesoCapsula;
    EditText textCapsulaSoloUmido;
    EditText textCapsulaSoloSeco;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_main);

                MainActivity.this.textPesoCapsula = (EditText)findViewById(R.id.textPesoCapsula);
                MainActivity.this.textCapsulaSoloUmido = (EditText)findViewById(R.id.textCapsulaSoloUmido);
                MainActivity.this.textCapsulaSoloSeco = (EditText)findViewById(R.id.textCapsulaSoloSeco);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().show();
                }
            }
        }, TEMPO_ESPERA);
    }
    public void determinacaoUmidadeCampo(View view){

        double pesoCapsula = Double.parseDouble(this.textPesoCapsula.getText().toString());
        double pesoCapsulaSoloUmido = Double.parseDouble(this.textCapsulaSoloUmido.getText().toString());
        double pesoCapsulaSoloSeco = Double.parseDouble(this.textCapsulaSoloSeco.getText().toString());

        double pesoAguaMa;
        double pesoSoloSecoMs;
        double umidade;
        double fatorConversao;

        pesoAguaMa = pesoCapsulaSoloUmido - pesoCapsulaSoloSeco;
        pesoSoloSecoMs = pesoCapsulaSoloSeco - pesoCapsula;
        umidade = 100 * pesoAguaMa / pesoSoloSecoMs;
        fatorConversao = 100 / (100 + umidade);

        Operacoes operacoes = new Operacoes(pesoCapsula, pesoCapsulaSoloUmido, pesoCapsulaSoloSeco, pesoAguaMa,  pesoSoloSecoMs, umidade, fatorConversao);

        Intent it = new Intent(this, ResultActivity.class);
        it.putExtra("operacoes", operacoes);
        startActivity(it);

        Toast toast = Toast.makeText(this, "Determinação executado com sucesso", Toast.LENGTH_SHORT );
        toast.show();
    }
}
