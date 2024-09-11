package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] perguntas = {"Quanto é 5 + 5 ", "Qual é o número de PI", "Que ano acabou a Segunda Guerra Mundial",
    "Em que ano o Homem pisou na Lua"};
    String [][] respostas = {{"10","30","24","15","120"}, {"1,34303","3,32130","2,34213","3,14159","120"},
            {"1944","1965","2023","1520","1945"}, {"1999","1986","1969","1971","2000"}};
    int perguntaatual = 0;
    int[] respostaCerta = {0,3,4,2};

    int[] respostasSelecionadas = {-1,-1,-1,-1};
    int acertos = 0;



    RadioGroup radioGroup;
    TextView text_pergunta, text_resultado, textArea;
    TextView numero_pergunta;

    RadioButton opcao1;
    RadioButton opcao2;
    RadioButton opcao3;
    RadioButton opcao4;
    RadioButton opcao5;
    Button btnConfirmar, btnReiniciar, btnAvan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_pergunta = (TextView) findViewById(R.id.Text_pergunta);
        numero_pergunta = (TextView) findViewById(R.id.numero_pergunta);
        text_resultado = (TextView) findViewById(R.id.text_resultado);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        textArea = (TextView) findViewById(R.id.textArea);
        opcao1 = (RadioButton) findViewById(R.id.radioButton2);
        opcao2 = (RadioButton) findViewById(R.id.radioButton3);
        opcao3 = (RadioButton) findViewById(R.id.radioButton4);
        opcao4 = (RadioButton) findViewById(R.id.radioButton5);
        opcao5 = (RadioButton) findViewById(R.id.radioButton6);

        if(perguntaatual == 0){
            textArea.setText("Matematica");
        };

        btnAvan = findViewById(R.id.button4);
        btnConfirmar = findViewById(R.id.button3);

        btnReiniciar = findViewById(R.id.button2);
        atualizarQuestoes();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int respostaSelect = radioGroup.getCheckedRadioButtonId();
                int indice = -1;

                if (respostaSelect == R.id.radioButton2){
                    indice = 0;
                } else if (respostaSelect == R.id.radioButton3) {
                    indice = 1;
                } else if (respostaSelect == R.id.radioButton4) {
                    indice = 2;
                } else if (respostaSelect == R.id.radioButton5) {
                    indice = 3;
                } else if (respostaSelect == R.id.radioButton6) {
                    indice = 4;
                }

                if(indice == -1) {
                    Toast.makeText(MainActivity.this, "Responda !", Toast.LENGTH_SHORT).show();
                } else {
                    respostasSelecionadas[perguntaatual] = indice;

                    if ( indice == respostaCerta[perguntaatual]){
                        acertos++;
                        text_resultado.setText("Parabens! Correto!!");
                    } else {
                        text_resultado.setText("VocÊ Errou!! Resposta Certa = " + respostas[perguntaatual][respostaCerta[perguntaatual]]);
                    }
                }
            }
        });
        btnAvan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atualizar();
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reiniciar();
            }
        });



    }
    private void atualizarQuestoes(){
        text_pergunta.setText(perguntas[perguntaatual]);
        opcao1.setText(respostas[perguntaatual][0]);
        opcao2.setText(respostas[perguntaatual][1]);
        opcao3.setText(respostas[perguntaatual][2]);
        opcao4.setText(respostas[perguntaatual][3]);
        opcao5.setText(respostas[perguntaatual][4]);
    }
    private void reiniciar(){
        perguntaatual = 0;
        acertos = 0;
        radioGroup.clearCheck();
        respostasSelecionadas = new int[]{-1,-1,-1,-1};
        atualizarQuestoes();
    };

    private void atualizar(){
        perguntaatual++;
        if(perguntaatual == 1){
            textArea.setText("Matematica");
        } else if (perguntaatual == 2) {
            textArea.setText("História");
        } else if (perguntaatual == 3) {
            textArea.setText("História");

        }

        if (perguntaatual < perguntas.length){
            atualizarQuestoes();
            text_resultado.setText("");
            radioGroup.clearCheck();
        } else{
            text_resultado.setText("VocÊ terminou o Quiz, Acertou : " + acertos);
        }
    }
}