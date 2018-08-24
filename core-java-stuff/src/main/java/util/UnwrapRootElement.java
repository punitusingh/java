package util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.MLTEligibilityDTO;
import model.MLTEligibilityDTOWrapper;

import java.io.IOException;

public class UnwrapRootElement {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        MLTEligibilityDTOWrapper mlt = null;
        try {
            mlt = mapper.readValue(MLTEligibilityDTO.class.getClassLoader().getResource("unwrapRootElement.json"),
                    mapper.getTypeFactory().constructType(MLTEligibilityDTOWrapper.class));
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

        System.out.println(mlt.toString());

    }
}
