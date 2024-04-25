package webscrapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class ScrapperMain {

    public static void main(String[] args) {
        var link = "https://www.bbc.com/";
        String result = getWebContent(link);

        System.out.println(result);
    }

    public static String getWebContent(String link) {
        try {
            URL url = new URL(link);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            String encoding = conn.getContentEncoding();

            InputStream inputStream = conn.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.joining());

            return result;
        } catch (IOException ex) {
            System.err.print(ex.getMessage());
        }

        return "";
    }
}
