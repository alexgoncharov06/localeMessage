package tests;

import com.github.alexgoncharov06.testWork.services.LocalizationReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexwolf on 31.03.16.
 */

@RunWith(value = Parameterized.class)
public class AppTest {




    private Locale lang;
    private Date current;
    private String message;

    private final Logger logger = LogManager.getLogger(AppTest.class.getName());



    public AppTest(Locale lang, Date current, String message) {
        this.lang = lang;
        this.current = current;
        this.message = message;
    }



    @Parameterized.Parameters(name = "{index}: lang: {0}, time: {1}, message: {2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                { Locale.US, new Date(116,2,31,6,3,0), "Good morning, World!" },
                { Locale.US, new Date(116,2,31,9,3,0), "Good day, World!" },
                { Locale.US, new Date(116,2,31,19,3,0), "Good evening, World!" },
                { Locale.US, new Date(116,2,31,23,3,0), "Good night, World!" },
                { Locale.forLanguageTag("ru-RU"), new Date(116,2,31,6,3,0), "Доброе утро, Мир!" },
                { Locale.forLanguageTag("ru-RU"), new Date(116,2,31,9,3,0), "Добрый день, Мир!" },
                { Locale.forLanguageTag("ru-RU"), new Date(116,2,31,19,3,0), "Добрый вечер, Мир!" },
                { Locale.forLanguageTag("ru-RU"), new Date(116,2,31,23,3,0), "Доброй ночи, Мир!" }
        });
    }




    @Before
    public void setUp() {

        Locale.setDefault(lang);
    }


    @After
    public void tearDown() {

        Locale.setDefault(Locale.forLanguageTag("ru-RU"));
    }

    @Test
    public void testGettMessage() throws IOException {

        logger.info("Locale: " + lang.toString() + ", Time: " + current.toGMTString() + ", Message: " + message);
        assertEquals(message, new LocalizationReaderImpl().getMessageFromProp(current));
    }


}

