package com.github.alexgoncharov06.testWork.structure;

/**
 * Created by ALeksandr Honcharov on 30.03.16.
 */
public class Message {


    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void printMessage(){

      System.out.println(message);
  }
}
