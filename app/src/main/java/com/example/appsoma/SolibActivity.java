package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsoma.entities.OperacoesInSitu;
import com.example.appsoma.entities.OperacoesSolib;

import java.text.DecimalFormat;

public class SolibActivity extends AppCompatActivity {

    private Button buttonSolib;

    private Spinner spinnerDeterminacao;

    private TextView
                     textDeterminacao,
                     textPesoCilindroSoloUmido,
                     textVolumeCilindro,
                     textPesoCilindro,
                     textDensidadeUmida,
                     textDensidadeSeca,
                     textFatorConversao;

    String[] opcoesDeterminacao = {
           "Selecionar Determinação",
           "SCC.064",
           "opcaoTeste"
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solib);
            //
        /*Bundle bundle = getIntent().getExtras();
        OperacoesSolib operacoesSolib = (OperacoesSolib) bundle.getSerializable("operacoesSolib");

        DecimalFormat dfpct  = new DecimalFormat("0.00 %");

        SolibActivity.this.textFatorConversao   = (TextView) findViewById(R.id.textFatorConversao);

        this.textFatorConversao  .setText(dfpct.format(operacoesSolib.getFatorConversao()));*/
        //
        SolibActivity.this.textDeterminacao           = (TextView) findViewById(R.id.textDeterminacao);
        SolibActivity.this.buttonSolib                = (Button) findViewById(R.id.buttonSolib);
        SolibActivity.this.spinnerDeterminacao        =  findViewById(R.id.spinnerDeterminacao);
        SolibActivity.this.textPesoCilindroSoloUmido  = (EditText) findViewById(R.id.editPesoCilindroSoloUmido);

        SolibActivity.this.textVolumeCilindro = (TextView) findViewById(R.id.textVolumeCilindro);
        SolibActivity.this.textPesoCilindro   = (TextView) findViewById(R.id.textPesoCilindro);
        SolibActivity.this.textDensidadeUmida = (TextView) findViewById(R.id.textDensidadeUmida);
        SolibActivity.this.textDensidadeSeca  = (TextView) findViewById(R.id.textDensidadeSeca);




       final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, opcoesDeterminacao);
        spinnerDeterminacao.setAdapter(adapter);


        buttonSolib.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textDeterminacao.setText(opcoesDeterminacao[spinnerDeterminacao.getSelectedItemPosition()]);
                if(spinnerDeterminacao.getSelectedItemPosition() == 1) {

                    double volumeCilindro = 998;
                    double pesoCilindro = 997;
                    double pesoCilindroSoloUmido = Double.parseDouble(textPesoCilindroSoloUmido.getText().toString());

                    double soloUmido;
                    double densidadeUmida;
                    double densidadeSeca;
                    double fatorConversao = 0.82;
                    soloUmido = pesoCilindroSoloUmido - pesoCilindro;

                    densidadeUmida = soloUmido/ volumeCilindro;
                    densidadeSeca = densidadeUmida * fatorConversao;

                    OperacoesInSitu operacoesInSitu = new OperacoesInSitu(
                            volumeCilindro,
                            pesoCilindro,
                            pesoCilindroSoloUmido,
                            soloUmido,
                            densidadeUmida,
                            densidadeSeca
                    );
                    DecimalFormat df = new DecimalFormat("0.00");

                    textVolumeCilindro.setText(df.format(operacoesInSitu.getVolumeCilindro()));
                    textPesoCilindro  .setText(df.format(operacoesInSitu.getPesoCilindro()));
                    textDensidadeSeca .setText(df.format(operacoesInSitu.getDensidadeSeca()));
                    textDensidadeUmida.setText(df.format(operacoesInSitu.getDensidadeUmida()));

                    Toast.makeText(SolibActivity.this, "Determinação Nº " + opcoesDeterminacao[spinnerDeterminacao.getSelectedItemPosition()], Toast.LENGTH_LONG).show();
                }
            }
        });
    }

   /* private Intent onInSitu(View.OnLongClickListener){

        Intent it = new Intent(this, ResultActivity.class);
        it.putExtra("operacoesInSitu", operacoesInSitu);
        startActivity(it);
    }*/
}