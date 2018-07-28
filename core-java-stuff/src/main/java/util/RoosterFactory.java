package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class RoosterFactory {

    public static List<Person> createRoosters(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(RoosterFactory.class.getClassLoader().getResource("roosters.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        System.out.println(createRoosters());
    }
}
