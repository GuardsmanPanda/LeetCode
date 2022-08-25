package Problem300;

public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] letterCount = new char[26];
        for (char c : magazine.toCharArray()) letterCount[c-97]++;
        for (char cr : ransomNote.toCharArray()) {
            if (letterCount[cr-97] == 0) return false;
            letterCount[cr-97]--;
        }
        return true;
    }
}
