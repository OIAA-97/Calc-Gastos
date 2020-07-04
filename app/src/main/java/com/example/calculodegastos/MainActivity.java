package com.example.calculodegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNom;
    private EditText txtPuntoSal;
    private EditText txtDest;
    private EditText txtHoraSal;
    private EditText txtCostoComb;
    private EditText txtDist;
    private EditText txtHoraLleg;
    private EditText txtTot;
    private Button btnCalcularTiemp;
    private Button btnTota;

    private void Iniciar(){

        txtNom = (EditText)findViewById(R.id.txtNom);
        txtPuntoSal = (EditText)findViewById(R.id.txtPuntoSal);
        txtDest = (EditText)findViewById(R.id.txtDest);
        txtHoraSal = (EditText)findViewById(R.id.txtHoraSal);
        txtCostoComb = (EditText)findViewById(R.id.txtCostoComb);
        txtDist = (EditText)findViewById(R.id.txtDist);
        txtHoraLleg = (EditText)findViewById(R.id.txtHoraLleg);
        txtTot = (EditText)findViewById(R.id.txtTot);
        btnCalcularTiemp = (Button)findViewById(R.id.btnCalcularTiemp);
        btnTota = (Button)findViewById(R.id.btnTota);


        btnCalcularTiemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalcularTiempo();
            }
        });

        btnTota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CalcularTotal();

            }
        });


    }

    private void CalcularTiempo(){
        int dkm = Integer.parseInt(txtDist.getText().toString());
        int Segundos = (dkm * 3600)/100;
        int Hora = Segundos / 3600;
        int Minuto = (Segundos - Hora * 3600);
        int SegR = Segundos - Hora * 3600 - Minuto * 60;
        txtHoraLleg.setText(String.valueOf(Hora + "Hora" + Minuto + "Min" + SegR + "Segundo"));
    }

    private void CalcularTotal(){
        int costoComb = Integer.parseInt(txtCostoComb.getText().toString());
        int dkm = Integer.parseInt(txtDist.getText().toString());

        int Ren = 14;
        int ct = (dkm / Ren) * costoComb;

        txtTot.setText(String.valueOf("$ " + ct + ".00"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }
}
