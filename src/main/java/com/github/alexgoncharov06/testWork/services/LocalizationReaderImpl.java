package com.github.alexgoncharov06.testWork.services;

import com.github.alexgoncharov06.testWork.helpers.UTF8Control;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * Created by alexwolf on 30.03.16.
 */
public class LocalizationReaderImpl  implements LocalizationReader{


    private static final Logger log = LogManager.getLogger(LocalizationReader.class);


    public static final ArrayList<String> LOCALES = getLocaleList();



    private static ArrayList<String> getLocaleList() {
        ArrayList<String> locales = new ArrayList<String>();
        locales.add("ru_RU");
        locales.add("en_US");

        return locales;
    }


    public String getMessageFromProp(Calendar current, Locale locale) throws IOException {
        log.info("start method getMessageFromProp() for date " + current.getTime().toString());

        String message = null;
        ResourceBundle bundle = null;
        

        if(LOCALES.contains(locale.toString())){

            bundle = ResourceBundle.getBundle("locale.locale", locale, new UTF8Control());


        } else{

            bundle = ResourceBundle.getBundle("locale.locale", Locale.US, new UTF8Control());

        }


        if (current.get(Calendar.HOUR_OF_DAY) >= 6 && current.get(Calendar.HOUR_OF_DAY) < 9){

            message = bundle.getString("morning");

        }

        if (current.get(Calendar.HOUR_OF_DAY) >= 9 && current.get(Calendar.HOUR_OF_DAY) < 19){

            message = bundle.getString("day");

        }

        if (current.get(Calendar.HOUR_OF_DAY) >= 19 && current.get(Calendar.HOUR_OF_DAY) < 23){

            message = bundle.getString("evening");

        }

        if (current.get(Calendar.HOUR_OF_DAY) >= 23 || current.get(Calendar.HOUR_OF_DAY) < 6){

            message = bundle.getString("night");

        }

        log.info("displayed message: " + message);
        return message;
    }


}
