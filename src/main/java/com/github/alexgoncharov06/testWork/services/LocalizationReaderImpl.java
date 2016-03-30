package com.github.alexgoncharov06.testWork.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

/**
 * Created by alexwolf on 30.03.16.
 */
public class LocalizationReaderImpl  implements LocalizationReader{

    private static Properties props = new Properties();


    public String getMessageFromProp(Date current) throws IOException {

        String lang =  System.getProperty("user.language");

        String message = null;

        String resourceName = "locale_" + lang + ".properties";

        InputStream resourceStream = ClassLoader.getSystemResourceAsStream(resourceName);

        InputStreamReader isr = new InputStreamReader(resourceStream, "UTF-8");

        props.load(isr);


        if (current.getHours() >= 6 && current.getHours() < 9){
            message = props.getProperty("morning");

        }

        if (current.getHours() >= 9 && current.getHours() < 19){
            message = props.getProperty("day");
        }

        if (current.getHours() >= 19 && current.getHours() < 23){
            message = props.getProperty("evening");
        }

        if (current.getHours() >= 23 || current.getHours() < 6){
            message = props.getProperty("night");
        }

        return message;
    }
}
