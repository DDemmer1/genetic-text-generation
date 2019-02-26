package geneticGoogleQuery;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GoogleRequestJsoup {

    public static int getGoogleHits(String query){
        try {


        String urlString = "https://www.google.com/search?hl=de&as_q=&as_epq=" +query;
//        String urlString = "https://www.google.com/search?hl=de&q=" +query;

        Map<String, String> request_headers = new HashMap<>();
        request_headers.put("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        request_headers.put("accept-encoding","gzip, deflate, br");
        request_headers.put("accept-language","en-US,en;q=0.8");
        request_headers.put("upgrade-insecure-requests","1");
        request_headers.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");

        Jsoup.connect(urlString).headers(request_headers);
        Document doc = Jsoup.connect(urlString).get();
        Elements numberOfHits = doc.select("#resultStats");
        Element hits = numberOfHits.first();
        String hitsString = hits.text();
        String sub = hitsString.substring(0,hitsString.length()-20);
        sub = sub.replaceAll("\\D+", "");
        Application.requests++;

        return Integer.parseInt(sub);

        } catch (HttpStatusException e){
            System.err.println("Google ban after " + Application.requests + " requests");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return 0;
    }
}
