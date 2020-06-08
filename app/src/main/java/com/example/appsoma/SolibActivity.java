package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsoma.entities.OperacoesInSitu;

import java.text.DecimalFormat;

public class SolibActivity extends AppCompatActivity {
    private TextView textDeterminacao;
    private Button buttonSolib;
    private Spinner spinnerDeterminacao;
    EditText textPesoCilindroSoloUmido;
    private TextView textDensidadeUmida;
    private TextView textDensidadeSeca;

    String[] opcoesDeterminacao = {"", "SCC.064", "opcaoTeste"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SolibActivity.this.textDeterminacao = (TextView) findViewById(R.id.textDeterminacao);
        SolibActivity.this.buttonSolib = (Button) findViewById(R.id.buttonSolib);
        SolibActivity.this.spinnerDeterminacao =  findViewById(R.id.spinnerDeterminacao);
        SolibActivity.this.textPesoCilindroSoloUmido  = (EditText) findViewById(R.id.textpesoCilindroSoloUmido);
        SolibActivity.this.textDensidadeUmida = (TextView) findViewById(R.id.textDensidadeUmida);
        SolibActivity.this.textDensidadeSeca = (TextView) findViewById(R.id.textDensidadeSeca);

       final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, opcoesDeterminacao);
        spinnerDeterminacao.setAdapter(adapter);
      /* menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    texto.setText(opcoes[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


        buttonSolib.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textDeterminacao.setText(opcoesDeterminacao[spinnerDeterminacao.getSelectedItemPosition()]);


                if(spinnerDeterminacao.getSelectedItemPosition() == 1) {
                    //String[] determinacao =  {"SCC.064"};
                    double volumeCilindro = 998;
                    double pesoCilindro = 997;
                    double pesoCilindroSoloUmido = Double.parseDouble(textPesoCilindroSoloUmido.getText().toString());

                    double soloUmido;
                    double densidadeUmida;
                    double densidadeSeca;

                    soloUmido = pesoCilindroSoloUmido - pesoCilindro;

                    densidadeUmida = soloUmido/ volumeCilindro;
                    densidadeSeca = densidadeUmida * 0.00;//fator de conversão;

                    OperacoesInSitu operacoesInSitu = new OperacoesInSitu( volumeCilindro, pesoCilindro, pesoCilindroSoloUmido, soloUmido, densidadeUmida, densidadeSeca);
                    DecimalFormat df = new DecimalFormat("0.00");
                    textDensidadeSeca.setText(df.format(operacoesInSitu.getDensidadeSeca()));
                    textDensidadeUmida.setText(df.format(operacoesInSitu.getDensidadeUmida()));
                    Toast.makeText(SolibActivity.this, "Determinação Nº " + opcoesDeterminacao[spinnerDeterminacao.getSelectedItemPosition()], Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}