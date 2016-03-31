package com.github.alexgoncharov06.testWork.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by alexwolf on 30.03.16.
 */
public class LocalizationReaderImpl  implements LocalizationReader{


    private static final Logger log = LogManager.getLogger(LocalizationReader.class);
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("localeBean.xml");


    public String getMessageFromProp(Date current) throws IOException {
        log.info("start method getMessageFromProp() for date " + current.toLocaleString());

        String message = null;



        if (current.getHours() >= 6 && current.getHours() < 9){
            message = context.getMessage("morning", null, Locale.getDefault());

        }

        if (current.getHours() >= 9 && current.getHours() < 19){
            message = context.getMessage("day", null,  Locale.getDefault());

        }

        if (current.getHours() >= 19 && current.getHours() < 23){
            message = context.getMessage("evening", null,  Locale.getDefault());

        }

        if (current.getHours() >= 23 || current.getHours() < 6){
            message = context.getMessage("night", null,  Locale.getDefault());

        }

        log.info("displayed message: " + message);
        return message;
    }
}
