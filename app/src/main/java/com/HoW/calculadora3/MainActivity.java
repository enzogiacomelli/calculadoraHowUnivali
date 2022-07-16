package com.HoW.calculadora3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //declarações
    EditText resultadoText;
    EditText operacaoText;
    double num1 = 0;
    double num2 = 0;
    byte operador = 0;
    boolean decimal = false;
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
    Button historicoBtn;
    //public static List<String> saveData = new ArrayList<>();

    public static final String EXTRA_COD_RESULTADO = "com.gtappdevelopers.gfgroomdatabase.EXTRA_ID";
    public static final String EXTRA_DE_RESULTADO = "com.gtappdevelopers.gfgroomdatabase.EXTRA_COURSE_NAME";
    private ViewModelResultado viewModelResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        vincularComponentes();

        viewModelResultado = ViewModelProviders.of(this).get(ViewModelResultado.class);

        resultadoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    resultadoText.setText("");
                    String resultado = "";
                    @NonNull
                    String deResultado = "";
                    switch (operador){
                        case 1:
                            resultado = operacoes.soma(num1, num2);
                            operacaoText.setText(resultado);
                            resultadoText.setText(resultadoText.getText() + String.valueOf(num1) + "+" + String.valueOf(num2) + " = " + resultado + " ");
                            break;
                        case 2:
                            resultado = operacoes.subtracao(num1, num2);
                            operacaoText.setText(resultado);
                            resultadoText.setText(resultadoText.getText() + String.valueOf(num1) + "-" + String.valueOf(num2) + " = " + resultado + " ");
                            break;

                        case 3:
                            resultado = operacoes.divisao(num1, num2);
                            operacaoText.setText(resultado);
                            resultadoText.setText(resultadoText.getText() + String.valueOf(num1) + "/" + String.valueOf(num2) + " = " + resultado + " ");
                            break;

                        case 4:
                            resultado = operacoes.multiplicacao(num1, num2);
                            operacaoText.setText(resultado);
                            resultadoText.setText(resultadoText.getText() + String.valueOf(num1) + "*" + String.valueOf(num2) + " = " + resultado + " ");
                            break;

                        default:
                            return;
                    }

                    num1 = Double.parseDouble(resultado);//define o resultado como o primeiro valor da proxima operação e limpa o resto.
                    num2 = 0;
                    operador = 5;
                    decimal = false;

                    deResultado = resultadoText.getText().toString();

                    salvarDB(deResultado);
            }
        });


        historicoBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
                startActivity(intent);
            }
        }));

    }

    //metodo para salvar os dados recebidos da activity
    private void salvarDB(String deResultado){
        ResultadoModel model = new ResultadoModel(deResultado);
        viewModelResultado.insert(model);
    }

    private void vincularComponentes()//identifica os elementos da interface com as variaveis
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
        historicoBtn = findViewById(R.id.historicoBtn);
    }

    public void clickLimparBtn(View view){
        operacaoText.setText("");
        resultadoText.setText("");
        num1 = 0;
        num2 = 0;
        operador = 0;
        decimal = false;
    }//botao para "resetar" a calculadora

    public void clickPontoBtn(View view){
        if(!decimal) {
            operacaoText.setText(operacaoText.getText() + ".");
            decimal = true;
        }else{
            return;
        }
    }

    public void clickSomaBtn(View view){
        operacaoText.setText(operacaoText.getText() + " + ");
        operador = 1;
        decimal = false;
    }

    public void clickSubtracaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " - ");
        operador = 2;
        decimal = false;
    }

    public void clickDivisaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " / ");
        operador = 3;
        decimal = false;
    }

    public void clickMultiplicaoBtn(View view){
        operacaoText.setText(operacaoText.getText() + " * ");
        operador = 4;
        decimal = false;
    }


    public void click0btn(View view) {
        operacaoText.append("0");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 0.0;
                }else{
                    num1 = num1 * 10 + 0;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 1.0;
                }else{
                    num2 = num2 * 10 + 0;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.0;
            } else {
                num2 += 0.0;
            }
            decimal = false;
        }
    }

    public void click1btn(View view) {
        operacaoText.append("1");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 1.0;
                }else{
                    num1 = num1 * 10 + 1;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 1.0;
                }else{
                    num2 = num2 * 10 + 1;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.1;
            } else {
                num2 += 0.1;
            }
            decimal = false;
        }
    }

    public void click2btn(View view) {
        operacaoText.append("2");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 2.0;
                }else{
                    num1 = num1 * 10 + 2;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 2.0;
                }else{
                    num2 = num2 * 10 + 2;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.2;
            } else {
                num2 += 0.2;
            }
            decimal = false;
        }
    }

    public void click3btn(View view) {
        operacaoText.append("3");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 3.0;
                }else{
                    num1 = num1 * 10 + 3;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 3.0;
                }else{
                    num2 = num2 * 10 + 3;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.3;
            } else {
                num2 += 0.3;
            }
            decimal = false;
        }
    }

    public void click4btn(View view) {
        operacaoText.append("4");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 4.0;
                }else{
                    num1 = num1 * 10 + 4;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 4.0;
                }else{
                    num2 = num2 * 10 + 4;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.4;
            } else {
                num2 += 0.4;
            }
            decimal = false;
        }
    }

    public void click5btn(View view) {
        operacaoText.append("5");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 5.0;
                }else{
                    num1 = num1 * 10 + 5;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 5.0;
                }else{
                    num2 = num2 * 10 + 5;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.5;
            } else {
                num2 += 0.5;
            }
            decimal = false;
        }
    }

    public void click6btn(View view) {
        operacaoText.append("6");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 6.0;
                }else{
                    num1 = num1 * 10 + 6;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 6.0;
                }else{
                    num2 = num2 * 10 + 6;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.6;
            } else {
                num2 += 0.6;
            }
            decimal = false;
        }
    }

    public void click7btn(View view) {
        operacaoText.append("7");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 7.0;
                }else{
                    num1 = num1 * 10 + 7;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 7.0;
                }else{
                    num2 = num2 * 10 + 7;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.7;
            } else {
                num2 += 0.7;
            }
            decimal = false;
        }
    }

    public void click8btn(View view) {
        operacaoText.append("8");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 8.0;
                }else{
                    num1 = num1 * 10 + 8;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 8.0;
                }else{
                    num2 = num2 * 10 + 8;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.8;
            } else {
                num2 += 0.8;
            }
            decimal = false;
        }
    }

    public void click9btn(View view) {
        operacaoText.append("9");
        if (!decimal) {
            if (operador == 0) {
                if(num1 == 0)
                {
                    num1 = 9.0;
                }else{
                    num1 = num1 * 10 + 9;
                }

            } else {
                if(num2 == 0)
                {
                    num2 = 9.0;
                }else{
                    num2 = num2 * 10 + 9;
                }
            }
        } else {
            if (operador == 0) {
                num1 += 0.9;
            } else {
                num2 += 0.9;
            }
            decimal = false;
        }
    }

}