package com.github.alexgoncharov06.testWork.services;

import com.github.alexgoncharov06.testWork.structure.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Date;

/**
 * Created by alexwolf on 30.03.16.
 */
public class MessageGetterImpl implements MessageGetter {

    private static final Logger log = LogManager.getLogger(MessageGetter.class);
    public Message getMessage() {
        log.info("Started method getMessage()");
        Message message = new Message();
        LocalizationReader localizationReader = new LocalizationReaderImpl();
        try {
            message.setMessage(localizationReader.getMessageFromProp(new Date(System.currentTimeMillis())));
        } catch (IOException e) {

            log.error("error message: " + e.getMessage());
        }

        return message;
    }



}
