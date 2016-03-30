package com.github.alexgoncharov06.testWork.services;

import com.github.alexgoncharov06.testWork.structure.Message;

import java.io.IOException;
import java.util.Date;

/**
 * Created by alexwolf on 30.03.16.
 */
public class MessageGetterImpl implements MessageGetter {
    public Message getMessage() {

        Message message = new Message();
        LocalizationReader localizationReader = new LocalizationReaderImpl();
        try {
            message.setMessage(localizationReader.getMessageFromProp(new Date(System.currentTimeMillis())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }



}
