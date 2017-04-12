package com.endava.util;

import com.endava.service.Numbers;
import com.endava.service.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator {

    private BufferedReader reader;
    private String string;

    public Validator(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String isString(){

        for (int i = 0; i < 3; i++) {
            try {
                this.string = reader.readLine();

                if (string.length() == Numbers.ZERO.getNumber()){
                    Text.EMPTY_STRING.getText();
                    i++;
                } else {
                    i = Numbers.FIVE.getNumber();
                }

            } catch (IOException e) {
                Text.ERROR_STRING.getText();
            }
        }

        return string;
    }

    public int isDigit(){

        for (int j = 0; j < 3; j++) {
            boolean right = true;
            String numS = isString();
            for (int i = 0; i < numS.length(); i++) {
                if (!Character.isDigit(numS.charAt(i))){
                    Text.WRONG_NUMBER.getText();
                    right = false;
                    break;
                }
            }

            if (right) {
                j = Numbers.FIVE.getNumber();
                this.string = numS;
            }
        }

        try {
            return Integer.parseInt(this.string);
        } catch (NumberFormatException e){
            return 6;
        }
    }
}
