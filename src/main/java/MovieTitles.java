import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class MovieTitles {

    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */
    static String[] getMovieTitles(String substr) throws IOException {
        List<String> titles = new ArrayList<>();

        final int maxCalls = 100;
        final Gson gson = new Gson();
        int currentPage = 1;
        Integer totalPages = null;

        do {
            String content;

            URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + currentPage);
            URLConnection connection = url.openConnection();
            try (InputStream inputStream = connection.getInputStream()) {
                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                content = scanner.hasNext() ? scanner.next() : "";
            }

            JsonObject result = gson.fromJson(content, JsonObject.class);
            JsonArray data = result.getAsJsonArray("data");

            for (int i = 0; i < data.size(); i++) {
                String title = data.get(i).getAsJsonObject().get("Title").getAsString();
                titles.add(title);
            }

            if (totalPages == null) {
                totalPages = result.get("total_pages").getAsInt();
            }
            currentPage++;

        } while (currentPage <= totalPages && currentPage <= maxCalls);

        return titles.stream().sorted().toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getMovieTitles(_substr);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

}
