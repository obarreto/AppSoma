package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.appsoma.entities.OperacoesSolib;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{

    public static final long TEMPO_ESPERA = 2000;
    private Switch selectSolib;

    TextView textPesoCapsula,
             textCapsulaSoloUmido,
             textCapsulaSoloSeco,
             textPesoAgua,
             textSoloSeco,
             textUmidade,
             textFatorConversao;
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

                MainActivity.this.textPesoCapsula      = (EditText) findViewById(R.id.editPesoCapsula);
                MainActivity.this.textCapsulaSoloUmido = (EditText) findViewById(R.id.editCapsulaSoloUmido);
                MainActivity.this.textCapsulaSoloSeco  = (EditText) findViewById(R.id.editCapsulaSoloSeco);
                MainActivity.this.selectSolib          = (Switch)   findViewById(R.id.switch3);


                selectSolib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        onSolib(isChecked);
                    }
                });
                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }
            }
        }, TEMPO_ESPERA);
    }

    public void calcularUmidadeCampo(View view){

        double pesoCapsula          = Double.parseDouble(this.textPesoCapsula     .getText().toString());
        double pesoCapsulaSoloUmido = Double.parseDouble(this.textCapsulaSoloUmido.getText().toString());
        double pesoCapsulaSoloSeco  = Double.parseDouble(this.textCapsulaSoloSeco .getText().toString());

        double pesoAguaMa;
        double pesoSoloSecoMs;
        double umidade;
        double fatorConversao;

        pesoAguaMa      = pesoCapsulaSoloUmido - pesoCapsulaSoloSeco;
        pesoSoloSecoMs  = pesoCapsulaSoloSeco - pesoCapsula;
        umidade         = 1.00 * pesoAguaMa / pesoSoloSecoMs;
        fatorConversao  = 1.00 / (1.00 + umidade);

        OperacoesSolib operacoesSolib = new OperacoesSolib(
                pesoCapsula,
                pesoCapsulaSoloUmido,
                pesoCapsulaSoloSeco,
                pesoAguaMa,
                pesoSoloSecoMs,
                umidade,
                fatorConversao
        );


        DecimalFormat df     = new DecimalFormat("0.00");
        DecimalFormat dfg    = new DecimalFormat("0.00g");
        DecimalFormat dfpct  = new DecimalFormat("0.00%");

        this.textPesoCapsula      = (TextView) findViewById(R.id.textPesoCapsula);
        this.textCapsulaSoloUmido = (TextView) findViewById(R.id.textCapsulaSoloUmido);
        this.textCapsulaSoloSeco  = (TextView) findViewById(R.id.textCapsulaSoloSeco);
        this.textPesoAgua         = (TextView) findViewById(R.id.textPesoAgua);
        this.textSoloSeco         = (TextView) findViewById(R.id.textSoloSeco);
        this.textUmidade          = (TextView) findViewById(R.id.textUmidade);
        this.textFatorConversao   = (TextView) findViewById(R.id.textFatorConversao);

        this.textPesoCapsula     .setText(dfg   .format(operacoesSolib.getPesoCapsula()));
        this.textCapsulaSoloUmido.setText(dfg   .format(operacoesSolib.getPesoCapsulaSoloUmido()));
        this.textCapsulaSoloSeco .setText(dfg   .format(operacoesSolib.getPesoCapsulaSoloSeco()));
        this.textPesoAgua        .setText(dfg   .format(operacoesSolib.getPesoAguaMa()));
        this.textSoloSeco        .setText(dfg   .format(operacoesSolib.getPesoSoloSecoMs()));
        this.textUmidade         .setText(dfpct .format(operacoesSolib.getUmidade()));
        this.textFatorConversao  .setText(df    .format(operacoesSolib.getFatorConversao()));

        Intent it = new Intent(this, ResultActivity.class);
        it.putExtra("operacoesSolib", operacoesSolib);
    }

    private Intent onSolib(boolean isChecked){

        Intent it = new Intent(this,SolibActivity.class);

        if(isChecked) {
            startActivity(it);
        }
        return it;
    }
}

