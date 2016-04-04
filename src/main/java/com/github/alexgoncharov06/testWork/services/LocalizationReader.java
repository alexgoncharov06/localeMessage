package com.github.alexgoncharov06.testWork.services;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by alexwolf on 30.03.16.
 */
public interface LocalizationReader {
    String getMessageFromProp(Calendar current, Locale locale) throws IOException;
}
