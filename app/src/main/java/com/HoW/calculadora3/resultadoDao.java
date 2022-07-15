package com.HoW.calculadora3;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.HoW.calculadora3.calculadoraModel;

import java.util.List;

@androidx.room.Dao
public interface resultadoDao {
    //Resultado
    @Insert
    void insertResultado(calculadoraModel model);

    @Update
    void updateResultado(calculadoraModel model);

    @Delete
    void deleteResultado(calculadoraModel model);

    @Query("DELETE FROM tbResultados")
    void deleteTodosResultado();

    @Query("SELECT * FROM tbResultados ORDER BY CORESULTADO ASC")
    LiveData<List<calculadoraModel>> getTodosResultados();

}
