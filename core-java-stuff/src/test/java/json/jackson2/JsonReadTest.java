package json.jackson2;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ToDo;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class JsonReadTest {


    @Test
    public void readingToDoJsonFile(){
        ObjectMapper mapper = new ObjectMapper();

        try {


            List<ToDo> tasks=mapper.readValue(getClass().getClassLoader().getResource("todo.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, ToDo.class));

            tasks.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
