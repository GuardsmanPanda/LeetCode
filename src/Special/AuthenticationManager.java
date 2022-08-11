package Special;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AuthenticationManager {
    private record Token(String id, int expiry) {
    }

    private final PriorityQueue<Token> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.expiry));
    private final HashMap<String, Integer> tokenMap = new HashMap<>();
    private final int ttl;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + ttl);
        queue.add(new Token(tokenId, currentTime + ttl));
        prune(currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        prune(currentTime);
        if (tokenMap.containsKey(tokenId)) {
            tokenMap.put(tokenId, currentTime + ttl);
            queue.add(new Token(tokenId, currentTime + ttl));
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        prune(currentTime);
        return tokenMap.size();
    }

    private void prune(int currentTime) {
        while (!queue.isEmpty() && queue.peek().expiry <= currentTime) {
            Token token = queue.remove();
            if (tokenMap.getOrDefault(token.id, Integer.MAX_VALUE) <= currentTime) {
                tokenMap.remove(token.id);
            }
        }
    }
}
