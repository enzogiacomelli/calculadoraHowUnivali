package com.HoW.calculadora3;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class salvarDados {

    public static void criarArquivo() {

            File myObj = new File("C:\\Users\\egiac\\AndroidStudioProjects\\calculadora3\\dados\\historico.txt");
        try {
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void editarArquivo() {
        try {
            FileWriter myWriter = new FileWriter("historico.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
