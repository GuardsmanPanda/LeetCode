package Problem800;

import Types.Master;

import java.util.ArrayList;
import java.util.List;

public class Problem843 {
    record WordGuess(String word, int score) {}

    public void findSecretWord(String[] wordlist, Master master) {
        int[][] charCount = new int[wordlist[0].length()][26];
        for (String word : wordlist) {
            for (int i = 0; i < word.length(); i++) {
                charCount[i][word.charAt(i) - 'a']++;
            }
        }
        List<WordGuess> guesses = new ArrayList<>();
        for (String word : wordlist) {
            int score = 0;
            for (int i = 0; i < word.length(); i++) {
                score += charCount[i][word.charAt(i) - 'a'];
            }
            guesses.add(new WordGuess(word, score));
        }
        guesses.sort((a, b) -> b.score - a.score);

        List<WordGuess> list = new ArrayList<>();
        for (WordGuess ww : guesses) {
            String s = ww.word;
            boolean skip = false;
            for (WordGuess wordGuess : list) {
                int similarity = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == wordGuess.word.charAt(i)) similarity++;
                }
                if (similarity != wordGuess.score) {
                    System.out.println("skipping " + s + " because of " + wordGuess.word);
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                int score = master.guess(s);
                System.out.println(s + " " + score);
                if (score == s.length()) {
                    return;
                }
                list.add(new WordGuess(s, score));
            }
        }
    }
}
