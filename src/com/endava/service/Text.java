package com.endava.service;

public enum Text {
    BASE("Please chose what to do :\n"
            + "1. Show current workers \n"
            + "2. Initialize Business Trips \n"
            + "3. Show current Trips \n"
            + "4. Exit"),

    BYE("Good Bye!"),
    INCORRECT("Incorrect command, try again!"),
    EMPTY_STRING("Empty String, please insert data again"),
    ERROR_STRING("Error String format, try again"),
    WRONG_NUMBER("Wrong number format, please try again");

    private String text;

    Text(String text) {
        this.text = text;
    }

    public void getText() {
        System.out.println(text);
    }

}
