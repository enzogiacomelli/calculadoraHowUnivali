package com.HoW.calculadora3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    EditText resultadoText;
    EditText operacaoText;
    double num1 = 0;
    double num2 = 0;
    //String decimal1 = "";
    //String decimal2 = "";
    byte operador = 0;
    Button adicaoBtn;
    Button subtracaoBtn;
    Button multiplicacaoBtn;
    Button divisaoBtn;
    Button resultadoBtn;
    Button apagarBtn;
    Button num0Btn;
    Button num1Btn;
    Button num2Btn;
    Button num3Btn;
    Button num4Btn;
    Button num5Btn;
    Button num6Btn;
    Button num7Btn;
    Button num8Btn;
    Button num9Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste);

        vincularComponentes();

        operacoes Operacoes = new operacoes();
    }

    private void vincularComponentes()
    {
        resultadoText = findViewById(R.id.resultadoTxt);
        operacaoText = findViewById(R.id.operacaoTxt);
        adicaoBtn = findViewById(R.id.somaBtn);
        subtracaoBtn = findViewById(R.id.subtracaoBtn);
        multiplicacaoBtn = findViewById(R.id.multiplicacaoBtn);
        divisaoBtn = findViewById(R.id.divisaoBtn);
        resultadoBtn = findViewById(R.id.igualBtn);
        apagarBtn = findViewById(R.id.apagarBtn);
        num0Btn = findViewById(R.id.num0Btn);
        num1Btn = findViewById(R.id.num1Btn);
        num2Btn = findViewById(R.id.num2Btn);
        num3Btn = findViewById(R.id.num3Btn);
        num4Btn = findViewById(R.id.num4Btn);
        num5Btn = findViewById(R.id.num5Btn);
        num6Btn = findViewById(R.id.num6Btn);
        num7Btn = findViewById(R.id.num7Btn);
        num8Btn = findViewById(R.id.num8Btn);
        num9Btn = findViewById(R.id.num9Btn);
    }

    public void separaNumeros(String operacao){
        //operacao = "5 + 6"; //teste
        String apenasNumeros;
        apenasNumeros = operacao.replaceAll("[^0-9]", " ");
        String partes[];
        partes = apenasNumeros.split(" ");

        num1 = Double.parseDouble(partes[0]);
        num2 = Double.parseDouble(partes[3]);

        resultadoText.setText(partes[0]);
        switch (operador){
            case 1:
                resultadoText.setText(resultadoText.getText() + " + ");
                break;

            case 2:
                resultadoText.setText(resultadoText.getText() + " - ");
                break;

            case 3:
                resultadoText.setText(resultadoText.getText() + " / ");
                break;

            case 4:
                resultadoText.setText(resultadoText.getText() + " * ");
                break;
        }
        resultadoText.setText(resultadoText.getText() + partes[3]);

    }



    public void clickLimparBtn(View view){
        operacaoText.setText("");
        resultadoText.setText("");
    }

    public void clickIgualBtn(View view){
        separaNumeros(operacaoText.getText().toString());
        resultadoText.setText(resultadoText.getText() + " = ");
        String resultado;
        switch (operador){
            case 1:
                resultado = operacoes.soma(num1, num2);
                operacaoText.setText(resultado);
                resultadoText.setText(resultadoText.getText() + resultado);
                break;
            case 2:
                resultado = operacoes.subtracao(num1, num2);
                operacaoText.setText(resultado);
                resultadoText.setText(resultadoText.getText() + resultado);
                break;

            case 3:
                resultado = operacoes.divisao(num1, num2);
                operacaoText.setText(resultado);
                resultadoText.setText(resultadoText.getText() + resultado);
                break;

            case 4:
                resultado = operacoes.multiplicacao(num1, num2);
                operacaoText.setText(resultado);
                resultadoText.setText(resultadoText.getText() + resultado);
                break;
        }
    }

    public void clickPontoBtn(){
        operacaoText.setText(operacaoText.getText() + ".");
    }

    public void clickSomaBtn(View view){
        operacaoText.setText(operacaoText.getText() + " + ");
        operador = 1;
    }

    public void clickSubtracaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " - ");
        operador = 2;
    }

    public void clickDivisaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " / ");
        operador = 3;
    }

    public void clickMultiplicaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " * ");
        operador = 4;
    }


    public void click0btn(View view) {
        operacaoText.append("0");
        //verificaNumero("0");
    }

    public void click1btn(View view) {
        operacaoText.append("1");
        //verificaNumero("1");
    }

    public void click2btn(View view) {
        operacaoText.append("2");
        //verificaNumero("2");
    }

    public void click3btn(View view) {
        operacaoText.append("3");
        //verificaNumero("3");
    }

    public void click4btn(View view) {
        operacaoText.append("4");
        //verificaNumero("4");
    }

    public void click5btn(View view) {
        operacaoText.append("5");
        //verificaNumero("5");
    }

    public void click6btn(View view) {
        operacaoText.append("6");
       // verificaNumero("6");
    }

    public void click7btn(View view) {
        operacaoText.append("7");
       // verificaNumero("7");
    }

    public void click8btn(View view) {
        operacaoText.append("8");
        //verificaNumero("8");
    }

    public void click9btn(View view) {
        operacaoText.append("9");
        //verificaNumero("9");
    }
}