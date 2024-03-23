package truelogichackerrank;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BestTvShow {

    public static String bestTvShowByGenre(String genre) throws IOException, ParseException {

        URL url = new URL("https://jsonmock.hackerrank.com/api/tvseries?page=1");

        // Open a connection to the URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Set the HTTP request method to GET
        con.setRequestMethod("GET");

        // Get the response code
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder responseSb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            responseSb.append(inputLine);
        }
        in.close();

        // Parse JSON response using Gson
        Gson gson = new Gson();
        ApiResponse response = gson.fromJson(responseSb.toString(), ApiResponse.class);

        var filteredShows = Arrays.stream(response.getData())
                .filter(s -> s.getGenre().toLowerCase().contains(genre))
                .sorted(Comparator.comparingDouble(Show::getImdb_rating).reversed()
                        .thenComparing(Show::getName))
                .collect(Collectors.toList());
        filteredShows.forEach(System.out::println);


        // Close the connection
        con.disconnect();

        return filteredShows.get(0).getName();
    }

    public static void main(String[] args) throws IOException, ParseException {
        var highestRatedShow = bestTvShowByGenre("drama");
        System.out.println(highestRatedShow);
    }
}
