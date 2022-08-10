package Problem100;

public class Problem65 {
    public boolean isNumber(String s) {
        return s.matches("[+-]?(\\d+|(\\d+\\.(\\d+)?|\\.\\d+))([eE][+-]?\\d+)?");
    }
}
