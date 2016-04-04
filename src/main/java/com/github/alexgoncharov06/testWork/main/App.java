package com.github.alexgoncharov06.testWork.main;

import com.github.alexgoncharov06.testWork.services.MessageGetter;
import com.github.alexgoncharov06.testWork.services.MessageGetterImpl;

/**
 * Created by alexwolf on 30.03.16.
 */
public class App {

    public static void main(String[] args) {


        MessageGetter getter = new MessageGetterImpl();

        getter.getMessage().printMessage();

    }
}

