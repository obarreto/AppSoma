package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsoma.entities.OperacoesSolmef;

import java.text.DecimalFormat;

public class SolmefActivity extends AppCompatActivity {
        private EditText textPesoInicialFrasco;
        private EditText textPesoFinalFrasco;
        private EditText textPesoAreiaFunil;
        private EditText textPesoSoloUmido;
        private Button buttonCalcularDensidade;


        private TextView txtPesoInicialFrasco, txtPesoFinalFrasco, txtDiferenca,txtPesoAreiaFunil, txtPesoFinal,
                txtDensidadeAparenteAreia, txtVolumeFuro,  txtPesoSoloUmido, txtDensidadeUmida, txtDensidadeSeca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solmef);

        SolmefActivity.this.textPesoInicialFrasco = findViewById(R.id.textPesoInicialFrasco);
        SolmefActivity.this.textPesoFinalFrasco = findViewById(R.id.textPesoFinalFrasco);
        SolmefActivity.this.textPesoAreiaFunil = findViewById(R.id.textPesoAreiaFunil);
        SolmefActivity.this.textPesoSoloUmido = findViewById(R.id.textPesoSoloUmido);

    }


        public void calcularDensidadeAparente (View view){
            double pesoInicialFrasco = Double.parseDouble(this.textPesoInicialFrasco.getText().toString());
            double pesoFinalFrasco = Double.parseDouble(this.textPesoFinalFrasco.getText().toString());
            double pesoAreiaFunil = Double.parseDouble(this.textPesoAreiaFunil.getText().toString());
            double pesoSoloUmido = Double.parseDouble(this.textPesoSoloUmido.getText().toString());


            soloUmido = pesoCilindroSoloUmido - pesoCilindro;

            densidadeUmida = soloUmido / volumeCilindro;
            densidadeSeca = densidadeUmida * 0.00;//fator de conversão;

            OperacoesSolmef operacoesSolmef = new OperacoesSolmef(pesoInicialFrasco, );
            DecimalFormat df = new DecimalFormat("0.00");
            textDensidadeSeca.setText(df.format(operacoesSolmef.getDensidadeSeca()));
            textDensidadeUmida.setText(df.format(operacoesSolmef.getDensidadeUmida()));
            Toast.makeText(SolmefActivity.this, "Determinação Nº " , Toast.LENGTH_LONG).show();

        }

}