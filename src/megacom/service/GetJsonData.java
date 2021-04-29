package megacom.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import megacom.models.PagePlaceHolder;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetJsonData {

    public void getJson() throws IOException {

        Gson gson = new Gson();

        URL url = new URL("https://jsonplaceholder.typicode.com/posts");

        HttpURLConnection urlConnection =  (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");



        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();



//        String sbString = String.valueOf(sb);
        String sbString = sb.toString();
        System.out.println(sb);
//        String sub = sb.substring(1,26918);

//        String[] ary = sbString.split("\t");

        ArrayList<PagePlaceHolder> pagePlaceHolderArrayList;

        pagePlaceHolderArrayList = gson.fromJson(String.valueOf(sb), new TypeToken<ArrayList<PagePlaceHolder>>(){}.getType());

        for(PagePlaceHolder item: pagePlaceHolderArrayList){
            System.out.println(item+"\n");
        }

    }

}
