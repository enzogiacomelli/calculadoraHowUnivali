package com.HoW.calculadora3;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class ViewModelResultado extends AndroidViewModel {

    // Resultado
    private final ResultadoRepository repositoryResultado;

    private final LiveData<List<ResultadoModel>> todosResultados;

    // recuperar todos os Resultados
    public LiveData<List<ResultadoModel>> getTodosResultados() {
        return todosResultados;
    }

    // construtor Resultado
    public ViewModelResultado(@NonNull Application application) {
        super(application);
        repositoryResultado = new ResultadoRepository(application);
        todosResultados = repositoryResultado.getTodosResultados();
    }

    // insert Resultado
    public void insert(ResultadoModel model) {
        repositoryResultado.insert(model);
    }

    public void deleteTodosResultados() {
        repositoryResultado.deleteTodosResultados();
    }

}