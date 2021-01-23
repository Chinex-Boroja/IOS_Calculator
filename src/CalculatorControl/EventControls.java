package CalculatorControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EventControls {

    //Declaration of Variables to be made use of.
    private String operator = "";
    private double firstValue;
    private double secondValue;
    private double output;
    private boolean startScreen; // the variable is used to set the screen to Zero.
    private boolean decimalDisplay;

    //This displays the content of the calculator
    @FXML
    private Label displayValues;

    /**This is a method that accepts an integer and displays its content on the screen whenever a button from 1-9 is clicked.
     * This sets the display screen initially to zero, then once a button is fired or clicked, it displays the number.*/
    @FXML
    public void onNumberButtonClicked(ActionEvent actionEvent){
        if (!startScreen && !decimalDisplay){
            displayValues.setText("");
        }
        String buttonText = ((Button)actionEvent.getSource()).getText();
        displayValues.setText(displayValues.getText() + buttonText);
        startScreen = true;
    }
    /**This method is for the arithmetic operators (plus, minus, division and multiplication) as well as the equal sign.
     * It accepts the firstNumber and the secondNumber with the argument and outputs the results once the equal sign button
     * is fired*/
    @FXML
    public void onOperatorButtonClicked(ActionEvent actionEvent){
        String buttonForOperators = ((Button)actionEvent.getSource()).getText();
        if (!buttonForOperators.equals("=")){
            if (!operator.equals("")){
                return;
            }
            operator = buttonForOperators;
            firstValue = Double.parseDouble(displayValues.getText());
            displayValues.setText("");
        }
        else {
            if (operator.equals("")){
                return;
            }
            secondValue = Double.parseDouble(displayValues.getText());
            //method call to evaluate and calculate the results based on the operator used.
            evaluateValues(firstValue, secondValue, operator);
            operator = "";
        }
        startScreen = true;
    }
    //method for the decimal point, essentially used to append integers for floating point numbers.
    @FXML
    public void decimalPoint(ActionEvent actionEvent){
        if (!decimalDisplay){
            displayValues.setText(displayValues.getText() + ".");
            decimalDisplay = true;
        }
    }
    //method to clear the content of the screen and reset it to zero.
    @FXML
    public void clearDisplay() {
        displayValues.setText("0");
        startScreen = false;
        decimalDisplay = false;
        operator = "";
    }
    //method for deleting numbers(integers).
    @FXML
    private void backspaceValues(){
        String text = displayValues.getText();
        if (text.isEmpty()){
            displayValues.setText("0");
        }else {
            displayValues.setText(text.substring(0, text.length() - 1));
        }
    }
    //This is method used for negation of a number, which outputs the result to a double value and it has a range which it can accept.
    public void onButtonClickNegateVariables(ActionEvent event) {
        secondValue = Double.parseDouble(String.valueOf(displayValues.getText()));
        output = secondValue * -1;
        if (output > -1000000000 && output < 1000000000){
            displayValues.setText(String.valueOf(output));
        }else {
            displayValues.setText("Error");
        }
        decimalDisplay = true;
        output = 0;
    }
    //This method is used to restrict Zeros from appearing or displaying multiple times when clicked as the first input.
    public void onZeroClicked(ActionEvent actionEvent) {
        if (!startScreen && !decimalDisplay){
            displayValues.setText("");
        }
        displayValues.setText(displayValues.getText() + "0");
    }
    /**Method creation used for evaluating arithmetic operations for addition, subtraction, multiplication
     * and division*/
    public void evaluateValues(double firstValue, double secondValue, String operator){
        switch (operator){
            case "+":
                displayValues.setText(firstValue + secondValue + "");
                break;
            case "-":
                displayValues.setText(firstValue - secondValue + "");
                break;
            case "×":
                displayValues.setText(firstValue * secondValue + "");
                break;
            case "÷":
                if (secondValue == 0){
                    displayValues.setText("Math Error");
                    break;
                }
                displayValues.setText(firstValue / secondValue + "");
                break;
            default:
        }
    }
}