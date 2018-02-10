package inc.peace.formbuilder;

import org.junit.Test;

import java.sql.Connection;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getUUIDandRefId(){
        //System.out.println(UUID.fromString("Firstname"));
        System.out.println(UUID.randomUUID().toString());
        //System.out.println(randomAlphaNumeric(6,"firstname"));
    }


    //private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String getRandomRefId(int count,String fieldName) {
        StringBuilder builder = new StringBuilder();
        String alphanumericString = fieldName + "0123456789";
        while (count-- != 0) {
            int character = (int)(Math.random()*alphanumericString.length());
            builder.append(alphanumericString.charAt(character));
        }
        return builder.toString();
    }

    public void DBTest(){
    }
}