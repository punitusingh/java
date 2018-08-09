package util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;

public class JSONIgnorePropTest {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        MyTestClass mtc2 = null;
        try {
            mtc2 = mapper.readValue(RoosterFactory.class.getClassLoader().getResource("unknown.json"),
                    mapper.getTypeFactory().constructType(MyTestClass.class));
        }
        catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(mtc2.toString());

    }
}
