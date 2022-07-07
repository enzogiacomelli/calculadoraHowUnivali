package com.HoW.calculadora3;

import java.io.FileOutputStream;
import java.io.FileWriter;




public class salvarDados {

    public static void save() {
        String string1 = "Hey you";

        FileOutputStream fos;

        try {
            fos = new FileOutputStream("C:/Users/egiac/AndroidStudioProjects/calculadora3/dados/historico.txt", true);

            FileWriter fWriter;

            try {
                fWriter = new FileWriter(fos.getFD());
                fWriter.write("hi");
                fWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                fos.getFD().sync();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





   /* public static void criarArquivo() {

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
    }*/


