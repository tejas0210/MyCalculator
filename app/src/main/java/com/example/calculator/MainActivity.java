package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR{
        PLUS,MINUS,DIVIDE,MULTIPLY,EQUAL;
    }
    private TextView txtCalSpace;

    //instance variables
    private String curretNumber;
    private String numberAtleft;
    private String numberAtRight;
    private OPERATOR currentOPERATOR;
    private float calculationResult;
    private String wholeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curretNumber = "";
        calculationResult = 0;
        wholeString = "";

        txtCalSpace = findViewById(R.id.txtCalSpace);

        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDivide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEqual).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn0:
                numberTapped(0);
                break;
            case R.id.btn1:
                numberTapped(1);
                break;
            case R.id.btn2:
                numberTapped(2);
                break;
            case R.id.btn3:
                numberTapped(3);
                break;
            case R.id.btn4:
                numberTapped(4);
                break;
            case R.id.btn5:
                numberTapped(5);
                break;
            case R.id.btn6:
                numberTapped(6);
                break;
            case R.id.btn7:
                numberTapped(7);
                break;
            case R.id.btn8:
                numberTapped(8);
                break;
            case R.id.btn9:
                numberTapped(9);
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnEqual:
                operatorTapped(OPERATOR.EQUAL);
                break;
            case R.id.btnPlus:
                operatorTapped(OPERATOR.PLUS);
                break;
            case R.id.btnMinus:
                operatorTapped(OPERATOR.MINUS);
                break;
            case R.id.btnDivide:
                operatorTapped(OPERATOR.DIVIDE);
                break;
            case R.id.btnMultiply:
                operatorTapped(OPERATOR.MULTIPLY);
                break;
        }
    }

    private void clearTapped(){
        numberAtleft = "";
        numberAtRight = "";
        curretNumber = "";
        calculationResult = 0;
        currentOPERATOR = null;
        txtCalSpace.setText("0");
        wholeString = "";
    }

    private void numberTapped(int tappedNumber){
        curretNumber = curretNumber + String.valueOf(tappedNumber);
        wholeString+=tappedNumber;
        txtCalSpace.setText(wholeString);

    }

    private void operatorTapped(OPERATOR operator){
        if(currentOPERATOR!=null){
            if(curretNumber!="") {
                numberAtRight = curretNumber;
                curretNumber = "";

                switch (currentOPERATOR) {
                    case PLUS:
                        calculationResult = Float.parseFloat(numberAtleft) + Float.parseFloat(numberAtRight);
                        break;
                    case MINUS:
                        calculationResult = Float.parseFloat(numberAtleft) - Float.parseFloat(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Float.parseFloat(numberAtleft) / Float.parseFloat(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Float.parseFloat(numberAtleft) * Float.parseFloat(numberAtRight);
                        break;
                    case EQUAL:
                        if(calculationResult!=0){
                            txtCalSpace.setText(String.valueOf(calculationResult));
                        }
                }
                numberAtleft = String.valueOf(calculationResult);
                txtCalSpace.setText(wholeString);
            }
        }
        else{
            numberAtleft = curretNumber;
            if(wholeString==""){
                wholeString+=numberAtleft;
            }
            curretNumber = "";
        }

        currentOPERATOR = operator;
        if(currentOPERATOR!=null){
            if(currentOPERATOR==OPERATOR.PLUS){
                wholeString+="+";
                txtCalSpace.setText(wholeString);
            }
            else if(currentOPERATOR==OPERATOR.MINUS){
                wholeString+="-";
                txtCalSpace.setText(wholeString);
            }
            else if(currentOPERATOR==OPERATOR.DIVIDE){
                wholeString+="/";
                txtCalSpace.setText(wholeString);
            }
            else if(currentOPERATOR==OPERATOR.MULTIPLY){
                wholeString+="*";
                txtCalSpace.setText(wholeString);
            }
            else{
                wholeString = String.valueOf(calculationResult);
                txtCalSpace.setText(wholeString);
            }
        }
    }
}