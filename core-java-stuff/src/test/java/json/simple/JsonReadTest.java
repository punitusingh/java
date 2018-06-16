package json.simple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class JsonReadTest {

    @Test
    public void readingToDoJsonFile(){
        JSONParser parser = new JSONParser();

        try {

            System.out.println(getClass().getClassLoader().getResource("todo.json").getFile());
            Object  obj = parser.parse(new FileReader( getClass().getClassLoader().getResource("todo.json").getFile()));


            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(jsonArray.toArray());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
