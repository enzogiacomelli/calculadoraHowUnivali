package com.HoW.calculadora3;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricoActivity extends AppCompatActivity {

    // criando as variaveis do Recycler View
    private RecyclerView resultadoRV;
    private ViewModelResultado viewModelResultado;

//    private static final int ADD_ALUNO_REQUEST = 1;
//    private static final int EDIT_ALUNO_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_historico);

                // inicializando variaveis
        resultadoRV = findViewById(R.id.idRVResultado);

        // layout manager para o adapter
        resultadoRV.setLayoutManager(new LinearLayoutManager(this));
        resultadoRV.setHasFixedSize(true);

        //inicializa adapter para o Recycler View
        final ResultadoRVAdapter adapter = new ResultadoRVAdapter();

        resultadoRV.setAdapter(adapter);

        // passando os dados para o View Model
        viewModelResultado = ViewModelProviders.of(this).get(ViewModelResultado.class);


        // pega todos os registros para o View Model
        viewModelResultado.getTodosResultados().observe(this, new Observer<List<ResultadoModel>>() {
            @Override
            public void onChanged(List<ResultadoModel> resultadoModels) {
                adapter.submitList(resultadoModels);
            }
        });

    }
}