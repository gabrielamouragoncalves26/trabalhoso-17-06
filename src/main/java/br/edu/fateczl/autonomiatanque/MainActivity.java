package br.edu.fateczl.autonomiatanque;
/*
@author: Gabriela Moura Gonçalves
RA: 1110482213016
 */
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText qtdLitro;
    private EditText consumoMedio;
    private EditText qtdAtual;
    private TextView txtRes;
    private TextView txtRes2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        qtdLitro = findViewById(R.id.qtdLitro);
        qtdLitro.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        consumoMedio = findViewById(R.id.consumoMedio);
        consumoMedio.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes = findViewById(R.id.txtRes);
        txtRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        qtdAtual = findViewById(R.id.qtdAtual);
        qtdAtual.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        txtRes2 = findViewById(R.id.txtRes2);
        txtRes2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op-> calc());

    }

    public void calc(){
        double qtd = Double.parseDouble(qtdLitro.getText().toString());
        double consumo = Double.parseDouble(consumoMedio.getText().toString());
        double atual = Double.parseDouble(qtdAtual.getText().toString());

        double autonomia = qtd * consumo;
        double at = (atual * consumo)*1000;
        String res = "O tanque tem capacidade para " +qtd+ " e alcança " +autonomia+ " km";
        String res2 = "A autonomia atual do veículo é de " +at+ " metros";

        txtRes.setText(res);
        txtRes2.setText(res2);
        qtdLitro.setText("");
        consumoMedio.setText("");
        qtdAtual.setText("");
    }
}
