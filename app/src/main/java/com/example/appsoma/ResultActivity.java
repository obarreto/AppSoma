package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appsoma.entities.OperacoesInSitu;
import com.example.appsoma.entities.OperacoesSolib;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    TextView textPesoCapsula,
             textCapsulaSoloUmido,
             textCapsulaSoloSeco,
             textPesoAgua,
             textSoloSeco,
             textUmidade,
             textFatorConversao;

    TextView textVolumeCilindro,
             textPesoCilindro,
             textDensidadeSeca,
             textDensidadeUmida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        OperacoesSolib  operacoesSolib  = (OperacoesSolib)  bundle.getSerializable("operacoesSolib");
        OperacoesInSitu operacoesInSitu = (OperacoesInSitu) bundle.getSerializable("operacoesInSitu");

        DecimalFormat dfg    = new DecimalFormat("0.00 g");
        DecimalFormat dfpct  = new DecimalFormat("0.00 %");
        DecimalFormat dfgcm3 = new DecimalFormat("0.00 g/cm³");
        DecimalFormat dfcm3  = new DecimalFormat("0.00 cm³");


        this.textPesoCapsula      = (TextView) findViewById(R.id.editPesoCapsula);
        this.textCapsulaSoloUmido = (TextView) findViewById(R.id.editCapsulaSoloUmido);
        this.textCapsulaSoloSeco  = (TextView) findViewById(R.id.editCapsulaSoloSeco);
        this.textPesoAgua         = (TextView) findViewById(R.id.textPesoAgua);
        this.textSoloSeco         = (TextView) findViewById(R.id.textSoloSeco);
        this.textUmidade          = (TextView) findViewById(R.id.textUmidade);
        this.textFatorConversao   = (TextView) findViewById(R.id.textFatorConversao);

        this.textPesoCapsula     .setText(dfg  .format(operacoesSolib.getPesoCapsula()));
        this.textCapsulaSoloUmido.setText(dfg  .format(operacoesSolib.getPesoCapsulaSoloUmido()));
        this.textCapsulaSoloSeco .setText(dfg  .format(operacoesSolib.getPesoCapsulaSoloSeco()));
        this.textPesoAgua        .setText(dfg  .format(operacoesSolib.getPesoAguaMa()));
        this.textSoloSeco        .setText(dfg  .format(operacoesSolib.getPesoSoloSecoMs()));
        this.textUmidade         .setText(dfpct.format(operacoesSolib.getUmidade()));
        this.textFatorConversao  .setText(dfpct.format(operacoesSolib.getFatorConversao()));

        this.textVolumeCilindro = (TextView) findViewById(R.id.textVolumeCilindro);
        this.textPesoCilindro   = (TextView) findViewById(R.id.textPesoCilindro);
        this.textDensidadeSeca  = (TextView) findViewById(R.id.textDensidadeSeca);
        this.textDensidadeUmida = (TextView) findViewById(R.id.textDensidadeUmida);

        this.textVolumeCilindro.setText(dfg.format(operacoesInSitu.getVolumeCilindro()));
        this.textPesoCilindro  .setText(dfg.format(operacoesInSitu.getPesoCilindro()));
        this.textDensidadeSeca .setText(dfg.format(operacoesInSitu.getDensidadeSeca()));
        this.textDensidadeUmida.setText(dfg.format(operacoesInSitu.getDensidadeUmida()));

    }
}
