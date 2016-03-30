package com.github.alexgoncharov06.testWork.main;

import com.github.alexgoncharov06.testWork.services.MessageGetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alexwolf on 30.03.16.
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        MessageGetter getter = (MessageGetter) context.getBean("messageGetter");
        getter.getMessage().printMessage();

    }
}
