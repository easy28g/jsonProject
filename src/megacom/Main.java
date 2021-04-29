package megacom;

import megacom.service.GetJsonData;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        GetJsonData getJsonData = new GetJsonData();

        getJsonData.getJson();


    }
}
