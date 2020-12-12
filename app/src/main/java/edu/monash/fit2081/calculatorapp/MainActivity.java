package edu.monash.fit2081.calculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char NO_OPERATION = '?';

    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;
    public TextView interScreen;
    private TextView resultScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interScreen =  findViewById(R.id.InterScreen);
        resultScreen =  findViewById(R.id.resultScreen);
        decimalFormat = new DecimalFormat("#.##########");
    }



    public void buttonSevenClick(View v) {
        interScreen.setText(interScreen.getText() + "7");
    }

    public void buttonEightClick(View v) {
        interScreen.setText(interScreen.getText() + "8");
    }

    public void buttonNineClick(View v) {
        interScreen.setText(interScreen.getText() + "9");
    }

    public void buttonSixClick(View v) {
        interScreen.setText(interScreen.getText() + "6");
    }

    public void buttonFiveClick(View v) {
        interScreen.setText(interScreen.getText() + "5");
    }

    public void buttonFourClick(View v) {
        interScreen.setText(interScreen.getText() + "4");
    }

    public void buttonThreeClick(View v) {
        interScreen.setText(interScreen.getText() + "3");
    }

    public void buttonTwoClick(View v) {
        interScreen.setText(interScreen.getText() + "2");
    }

    public void buttonOneClick(View v) {
        interScreen.setText(interScreen.getText() + "1");
    }

    public void buttonZeroClick(View v) {
        interScreen.setText(interScreen.getText() + "0");
    }

    public void buttonDecimalClick(View v){interScreen.setText(interScreen.getText() + ".");}

    public void buttonDivisionClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = DIVISION;
            String result = decimalFormat.format(valueOne) + "/";
            resultScreen.setText(result);
            interScreen.setText("");
        }
    }

    public void buttonMultiplyClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = MULTIPLICATION;
            String result = decimalFormat.format(valueOne) + "*";
            resultScreen.setText(result);
            interScreen.setText("");
        }
    }

    public void buttonMinusClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = SUBTRACTION;
            String result = decimalFormat.format(valueOne) + "-";
            resultScreen.setText(result);
            interScreen.setText("");
        }
    }
    public void buttonPlusClick(View v) {
        computeCalculation();
        if (Double.isNaN(valueOne)) {
            showToast("Invalid Key");
        } else {
            CURRENT_ACTION = ADDITION;
            String result = decimalFormat.format(valueOne) + "+";
            resultScreen.setText(result);
            interScreen.setText("");
        }
    }


    public void buttonEqualClick(View v) {

        computeCalculation();
        String current = resultScreen.getText().toString();
        String finalRes = current + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne);
        valueOne = Double.NaN;
        resultScreen.setText(finalRes);
        CURRENT_ACTION = NO_OPERATION;
    }

    public void buttonClearClick(View v) {
        if (!interScreen.getText().toString().isEmpty()){
            int len = interScreen.getText().toString().length();
            String temp = interScreen.getText().toString().substring(0,len-1);
            interScreen.setText(temp);
        } else {
            valueOne = Double.NaN;
            valueTwo = Double.NaN;
            resultScreen.setText("");
            interScreen.setText("");
        }
    }


    private void computeCalculation() {

        if (!Double.isNaN(valueOne)) {
            String valueTwoString = interScreen.getText().toString();
            if (!valueTwoString.equals("")) {
                valueTwo = Double.parseDouble(valueTwoString);
                interScreen.setText(null);
                if (CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if (CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if (CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if (CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;
            }
        } else {
            try {
                valueOne = Double.parseDouble(interScreen.getText().toString());
            } catch (Exception e) {
            }

        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
