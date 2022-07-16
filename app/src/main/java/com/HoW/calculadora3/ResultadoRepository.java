package com.HoW.calculadora3;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.HoW.calculadora3.ResultadoDao;

import java.util.List;

public class ResultadoRepository {

    // criando variavel para o DAO e lista para todos os registros
    private final ResultadoDao dao;
    private final LiveData<List<ResultadoModel>> todosResultados;

    // criando construtor e passando as variaveis a ele
    public ResultadoRepository(Application application){
        CalculadoraDb database = CalculadoraDb.getInstance(application);
        dao = (ResultadoDao) database.resultadoDao();
        todosResultados = dao.getTodosResultados();
    }

    // metodos crud
    public void insert(ResultadoModel model){
        new InsertResultadoAsyncTask(dao).execute(model);
    }


    public void deleteTodosResultados(){
        new DeleteTodosResultadosAsyncTask(dao).execute();
    }
    public LiveData<List<ResultadoModel>> getTodosResultados(){
        return todosResultados;
    }

    // metodo para insert assincrono
    private static class InsertResultadoAsyncTask extends AsyncTask<ResultadoModel, Void, Void> {
        private final ResultadoDao dao;
        private InsertResultadoAsyncTask(ResultadoDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ResultadoModel... model){
            dao.insertResultado(model[0]);
            return null;
        }
    }

    // metodo para delete todos assincrono
    private static class DeleteTodosResultadosAsyncTask extends AsyncTask<Void, Void, Void> {
        private final ResultadoDao dao;
        private DeleteTodosResultadosAsyncTask(ResultadoDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids){
            dao.deleteTodosResultados();
            return null;
        }
    }
}