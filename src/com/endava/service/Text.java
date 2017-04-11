package com.endava.service;

public enum Text {
    BASE("Please chose what to do :\n"
            + "1. Sum current Array \n"
            + "2. Find max in Array \n"
            + "3. Reverse \"Hello from Thread\" \n"
            + "4. Three Threads and their interaction \n"
            + "5. Lambda Threads \n"
            + "6. Exit"),

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
