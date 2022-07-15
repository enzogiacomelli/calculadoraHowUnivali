package com.HoW.calculadora3;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.HoW.calculadora3.calculadoraModel;
import com.HoW.calculadora3.resultadoDao;

@Database(entities = {calculadoraModel.class}, version = 1)
public abstract class database extends RoomDatabase {

    private static database instance;

    public abstract resultadoDao resultadoDao();

    // metodo para instanciar a base de dados
    public static synchronized database getInstance(Context context){
        // verifica se ja esta criado
        if (instance == null){
            // criando base de dados passando a classe calculadora
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            database.class,"calculadora database")
                    // informa room database para destruir (e recriar) a base de dados em migracoes
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }
        // retorna instancia da base de dados
        return instance;
    }

    // criando callback
    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            // popular dados na criacao da tabela
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    // metodo para executar tarefas assincronas em segundo plano
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        @Deprecated
        PopulateDbAsyncTask(database instace){
            // Informando os DAOs das entidades
            resultadoDao instrutorDao = instance.resultadoDao();
        }
        @Override
        protected Void doInBackground(Void... voids){
            return null;
        }
    }
}
