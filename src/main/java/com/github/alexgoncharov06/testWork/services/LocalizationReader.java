package com.github.alexgoncharov06.testWork.services;

import java.io.IOException;
import java.util.Date;

/**
 * Created by alexwolf on 30.03.16.
 */
public interface LocalizationReader {
    String getMessageFromProp(Date current) throws IOException;
}
