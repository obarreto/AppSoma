package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appsoma.entities.Operacoes;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ResultActivity extends AppCompatActivity {
    TextView textPesoCapsula, textCapsulaSoloUmido,
             textCapsulaSoloSeco, textMa,
             textMs, textH, textFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        Operacoes operacoes = (Operacoes) bundle.getSerializable("operacoes");

        DecimalFormat df = new DecimalFormat("0.00");

        this.textPesoCapsula = findViewById(R.id.textPesoCapsula);
        this.textCapsulaSoloUmido = findViewById(R.id.textCapsulaSoloUmido);
        this.textCapsulaSoloSeco = findViewById(R.id.textCapsulaSoloSeco);
        this.textMa = findViewById(R.id.textMa);
        this.textMs = findViewById(R.id.textMs);
        this.textH = findViewById(R.id.textH);
        this.textFC = findViewById(R.id.textFC);

        this.textPesoCapsula.setText(df.format(operacoes.getPesoCapsula()));
        this.textCapsulaSoloUmido.setText(df.format(operacoes.getPesoCapsulaSoloUmido()));
        this.textCapsulaSoloSeco.setText(df.format(operacoes.getPesoCapsulaSoloSeco()));
        this.textMa.setText(df.format(operacoes.getPesoAguaMa()));
        this.textMs.setText(df.format(operacoes.getPesoSoloSecoMs()));
        this.textH.setText(df.format(operacoes.getUmidade()));
        this.textFC.setText(df.format(operacoes.getFatorConversao()));
    }
}
