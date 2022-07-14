package com.HoW.calculadora3;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;




public class HistoricoActivity extends AppCompatActivity {


    EditText historico;
    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        main = new MainActivity();
        vincularCampo();


        listarDadosHistorico();
    }

    private void vincularCampo()
    {
        historico = findViewById(R.id.listagemHistorico);
    }

    private void listarDadosHistorico ()
    {

        if (main.saveData.isEmpty()) {
            historico.setText("Vazio");
        }else{
            for (int i=0;i < main.saveData.size();i++) {
                String a = main.saveData.get(i);
                historico.setText(historico.getText() + "\n\r" + a);
            }
        }
    }
}