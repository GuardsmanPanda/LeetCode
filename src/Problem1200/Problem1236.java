package Problem1200;

import Types.HtmlParser;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Pattern pattern = Pattern.compile("http://([^/]*)/?");
        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> found = new HashSet<>();
        String hostname = "";
        Matcher matcher = pattern.matcher(startUrl);
        if (matcher.find()) {
            hostname = matcher.group(1);
        }
        found.add(startUrl);
        queue.add(startUrl);
        while (!queue.isEmpty()) {
            String url = queue.remove();
            found.add(url);
            List<String> urls = htmlParser.getUrls(url);
            for (String u : urls) {
                Matcher m2 = pattern.matcher(u);
                if (m2.find() && m2.group(1).equals(hostname) && found.add(u)) {
                    queue.add(u);
                }
            }
        }
        return List.copyOf(found);
    }
}
