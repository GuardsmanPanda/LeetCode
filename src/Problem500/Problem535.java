package Problem500;

import java.util.HashMap;
import java.util.Map;

public class Problem535 {
    public class Codec {
        private int currentId = 0;
        private final Map<String, String> urlMap = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = ""+currentId;
            currentId++;
            urlMap.put(shortUrl, longUrl);
            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return urlMap.get(shortUrl);
        }
    }
}
