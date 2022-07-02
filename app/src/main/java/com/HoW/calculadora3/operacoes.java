package com.HoW.calculadora3;




public class operacoes {

    public static String soma(Double numero1, Double numero2)
    {
        double resultado = numero1 + numero2;

        return String.valueOf(resultado);
    }


    public static String subtracao(Double numero1, Double numero2)
    {
        double resultado = numero1 - numero2;

        return String.valueOf(resultado);
    }


    public static String multiplicacao(Double numero1, Double numero2)
    {
        double resultado = numero1 * numero2;

        return String.valueOf(resultado);
    }


    public static String divisao(Double numero1, Double numero2)
    {
        double resultado = numero1 / numero2;

        return String.valueOf(resultado);
    }
}
