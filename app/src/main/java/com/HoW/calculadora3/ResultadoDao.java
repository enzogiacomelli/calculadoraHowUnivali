package com.HoW.calculadora3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ResultadoDao {
    //Resultado
    @Insert
    void insertResultado(ResultadoModel model);

    @Update
    void updateResultado(ResultadoModel model);

    @Delete
    void deleteResultado(ResultadoModel model);

    @Query("DELETE FROM tbResultados")
    void deleteTodosResultados();

    @Query("SELECT * FROM TBRESULTADOS ORDER BY CORESULTADO DESC")
    LiveData<List<ResultadoModel>> getTodosResultados();

}
