package com.example.appsoma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsoma.entities.OperacoesSolib;
import com.example.appsoma.entities.OperacoesSolmef;

import java.text.DecimalFormat;

public class SolmefActivity extends AppCompatActivity {
        private EditText editPesoInicialFrasco;
        private EditText editPesoFinalFrasco;
        private EditText editPesoAreiaFunil;
        private EditText editPesoSoloUmido;
        private Button   buttonCalcularDensidade;


        private TextView txtPesoInicialFrasco,
                         txtPesoFinalFrasco,
                         txtDiferenca,
                         txtPesoAreiaFunil,
                         txtPesoFinal,
                         txtDensidadeAparenteAreia,
                         txtVolumeFuro,
                         txtPesoSoloUmido,
                         txtDensidadeUmida,
                         txtDensidadeSeca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solmef);
        getSupportActionBar().hide();

        SolmefActivity.this.txtPesoInicialFrasco    = (EditText) findViewById(R.id.editPesoInicialFrasco);
        SolmefActivity.this.txtPesoFinalFrasco      = (EditText) findViewById(R.id.editPesoFinalFrasco);
        SolmefActivity.this.txtPesoAreiaFunil       = (EditText) findViewById(R.id.editPesoAreiaFunil);
        SolmefActivity.this.txtPesoSoloUmido        = (EditText) findViewById(R.id.editPesoSoloUmido);
        SolmefActivity.this.buttonCalcularDensidade = (Button) findViewById(R.id.buttonCalcularDensidade);


    }
            public void calcularDensidadeAparente (View view){

            Bundle bundle = getIntent().getExtras();
            OperacoesSolib operacoesSolib = (OperacoesSolib) bundle.getSerializable("operacoes");

            double pesoInicialFrasco = Double.parseDouble(this.editPesoInicialFrasco.getText().toString());
            double pesoFinalFrasco   = Double.parseDouble(this.editPesoFinalFrasco  .getText().toString());
            double pesoAreiaFunil    = Double.parseDouble(this.editPesoAreiaFunil   .getText().toString());
            double pesoSoloUmido     = Double.parseDouble(this.editPesoSoloUmido    .getText().toString());


            double diferenca;
            double pesoFinal;
            double densidadeAparenteAreia = 1330;
            double volumeFuro;
            double densidadeUmida;
            double densidadeSeca;

            diferenca  = pesoInicialFrasco - pesoFinalFrasco;
            pesoFinal  = diferenca - pesoAreiaFunil;
            volumeFuro = pesoFinal / densidadeAparenteAreia;

            densidadeUmida = pesoSoloUmido / volumeFuro;
            densidadeSeca  = densidadeUmida/ (1 + operacoesSolib.getUmidade() / 100);

            OperacoesSolmef operacoesSolmef = new OperacoesSolmef(
                    pesoInicialFrasco,
                    pesoFinalFrasco,
                    diferenca,
                    pesoAreiaFunil,
                    pesoFinal,
                    densidadeAparenteAreia,
                    volumeFuro,
                    pesoSoloUmido,
                    densidadeUmida,
                    densidadeSeca
            );

            DecimalFormat dfg    = new DecimalFormat("0.00 G");
            DecimalFormat dfgcm3 = new DecimalFormat("0.00 G/CM³");
            DecimalFormat dfcm3  = new DecimalFormat("0.00 CM³");

                SolmefActivity.this.txtPesoInicialFrasco      = (TextView) findViewById(R.id.txtPesoInicialFrasco);
                SolmefActivity.this.txtPesoFinalFrasco        = (TextView) findViewById(R.id.txtPesoFinalFrasco);
                SolmefActivity.this.txtDiferenca              = (TextView) findViewById(R.id.txtDiferenca);
                SolmefActivity.this.txtPesoAreiaFunil         = (TextView) findViewById(R.id.txtPesoAreiaFunil);
                SolmefActivity.this.txtPesoFinal              = (TextView) findViewById(R.id.txtPesoFinal);
                SolmefActivity.this.txtDensidadeAparenteAreia = (TextView) findViewById(R.id.txtDensidadeAparenteAreia);
                SolmefActivity.this.txtVolumeFuro             = (TextView) findViewById(R.id.txtVolumeFuro);
                SolmefActivity.this.txtPesoSoloUmido          = (TextView) findViewById(R.id.txtPesoSoloUmido);
                SolmefActivity.this.txtDensidadeUmida         = (TextView) findViewById(R.id.txtDensidadeUmida);
                SolmefActivity.this.txtDensidadeSeca          = (TextView) findViewById(R.id.txtDensidadeSeca);



            txtPesoInicialFrasco     .setText(dfg   .format(operacoesSolmef.getPesoInicialFrasco()));
            txtPesoFinalFrasco       .setText(dfg   .format(operacoesSolmef.getPesoFinalFrasco()));
            txtDiferenca             .setText(dfg   .format(operacoesSolmef.getDiferenca()));
            txtPesoAreiaFunil        .setText(dfg   .format(operacoesSolmef.getPesoAreiaFunil()));
            txtPesoFinal             .setText(dfg   .format(operacoesSolmef.getPesoFinal()));
            txtDensidadeAparenteAreia.setText(dfgcm3.format(operacoesSolmef.getDensidadeAparenteAreia()));
            txtVolumeFuro            .setText(dfcm3 .format(operacoesSolmef.getVolumeFuro()));
            txtPesoSoloUmido         .setText(dfg   .format(operacoesSolmef.getPesoSoloUmido()));
            txtDensidadeSeca         .setText(dfgcm3.format(operacoesSolmef.getDensidadeSeca()));
            txtDensidadeUmida        .setText(dfgcm3.format(operacoesSolmef.getDensidadeUmida()));

            Toast.makeText(SolmefActivity.this, "Densidade Aparente - Processo Funil" , Toast.LENGTH_LONG).show();
     }
}