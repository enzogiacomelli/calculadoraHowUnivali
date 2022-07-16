package com.HoW.calculadora3;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class salvarDados extends Activity {
    String escrita = "aa";
    String leitura;
    //File file = new File("file");


    public void save() {
        FileOutputStream fos;
        try {
            fos = this.openFileOutput("file", MODE_APPEND); //abre ou cria arquivo com nome
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.write(escrita.getBytes());
            oos.close();

            Toast.makeText(getBaseContext(), "arquivo salvo", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){
        FileInputStream fis;
        try {
            fis = this.openFileInput("C:/Users/egiac/AndroidStudioProjects/calculadora3/dados/historico.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            leitura = ois.readUTF();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



