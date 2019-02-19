import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GoogleRequest {

    @SneakyThrows
    public static void main(String arg[]) {

        long start = System.currentTimeMillis();
        String query = "test";
        String urlString = "https://www.google.de/search?hl=de&q=" +query;


        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        String result = content.toString();

        long duration = System.currentTimeMillis() - start;

        System.out.println(duration);
    }
}
