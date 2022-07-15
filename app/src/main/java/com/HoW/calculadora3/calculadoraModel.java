package com.HoW.calculadora3;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Entity(tableName = "tbResultados")
public class calculadoraModel {

    @PrimaryKey(autoGenerate = true)
    private int coResultado;
    private String deResultado;

    public calculadoraModel(String deResultado){
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
