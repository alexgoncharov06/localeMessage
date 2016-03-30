package tests;

import com.github.alexgoncharov06.testWork.services.LocalizationReaderImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexwolf on 31.03.16.
 */

@RunWith(value = Parameterized.class)
public class AppTest {


    private String lang;
    private Date current;
    private String message;



    public AppTest(String lang, Date current, String message) {
        this.lang = lang;
        this.current = current;
        this.message = message;
    }



    @Parameterized.Parameters(name = "{index}: lang: {0}, time: {1}, message: {2}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][] {
                { "en", new Date(2016,3,31,6,3,0), "Good morning, World!" },
                { "en", new Date(2016,3,31,9,3,0), "Good day, World!" },
                { "en", new Date(2016,3,31,19,3,0), "Good evening, World!" },
                { "en", new Date(2016,3,31,23,3,0), "Good night, World!" },
                { "ru", new Date(2016,3,31,6,3,0), "Доброе утро, Мир!" },
                { "ru", new Date(2016,3,31,9,3,0), "Добрый день, Мир!" },
                { "ru", new Date(2016,3,31,19,3,0), "Добрый вечер, Мир!" },
                { "ru", new Date(2016,3,31,23,3,0), "Доброй ночи, Мир!" }
        });
    }


    @Before
    public void setUp() {

        System.setProperty("user.language", lang);
    }


    @After
    public void tearDown() {
        System.setProperty("user.language", "ru");
    }

    @Test
    public void testGettMessage() throws IOException {
        assertEquals(message, new LocalizationReaderImpl().getMessageFromProp(current));
    }


}
