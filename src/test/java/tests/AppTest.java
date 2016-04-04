package tests;

import com.github.alexgoncharov06.testWork.services.LocalizationReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexwolf on 31.03.16.
 */

@RunWith(value = Parameterized.class)
public class AppTest {


    private final Logger logger = LogManager.getLogger(AppTest.class.getName());
    private Locale lang;
    private int currentHours;
    private String message;


    public AppTest(Locale lang, int currentHours, String message) {
        this.lang = lang;
        this.currentHours = currentHours;
        this.message = message;
    }


    @Parameterized.Parameters(name = "{index}: lang: {0}, time: {1}, message: {2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {Locale.US, 6, "Good morning, World!"},
                {Locale.US, 9, "Good day, World!"},
                {Locale.US, 19, "Good evening, World!"},
                {Locale.US, 23, "Good night, World!"},
                {Locale.forLanguageTag("ru-RU"), 6, "Доброе утро, Мир!"},
                {Locale.forLanguageTag("ru-RU"), 9, "Добрый день, Мир!"},
                {Locale.forLanguageTag("ru-RU"), 19, "Добрый вечер, Мир!"},
                {Locale.forLanguageTag("ru-RU"), 23, "Доброй ночи, Мир!"}
        });
    }


    @Test
    public void testGettMessage() throws IOException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, currentHours);


        logger.info("Locale: " + lang.toString() + ", Time: " + calendar.getTime().toString() + ", Message: " + message);
        assertEquals(message, new LocalizationReaderImpl().getMessageFromProp(calendar, lang));
    }


}

