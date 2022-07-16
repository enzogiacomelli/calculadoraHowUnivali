package com.HoW.calculadora3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "tbResultados")
public class ResultadoModel {

    @PrimaryKey(autoGenerate = true)
    private int coResultado;
    private String deResultado;

    public ResultadoModel(String deResultado){
        this.deResultado = deResultado;
    }

    public int getCoResultado() {
        return coResultado;
    }

    public void setCoResultado(int coResultado) {
        this.coResultado = coResultado;
    }

    public String getDeResultado() {
        return deResultado;
    }

    public void setDeResultado(String deResultado) {
        this.deResultado = deResultado;
    }
}
