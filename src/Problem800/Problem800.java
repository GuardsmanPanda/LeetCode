package Problem800;

public class Problem800 {
    public String similarRGB(String color) {
        return "#" + getHexthing(color.substring(1,3)) + getHexthing(color.substring(3,5)) + getHexthing(color.substring(5,7));
    }

    private String getHexthing(String input) {
        String a = new StringBuilder().appendCodePoint(input.charAt(0)+1).toString();
        String b = new StringBuilder().appendCodePoint(input.charAt(0)-1).toString();
        String out  = input.charAt(0) + input.substring(0,1);
        int min = Math.abs(Integer.parseInt(input, 16) - Integer.parseInt(out, 16));
        a = input.charAt(0) == '9' ? "aa" : a+a;
        b = input.charAt(0) == 'a' ? "99" : b+b;
        if (input.charAt(0) != 'f' &&  Math.abs(Integer.parseInt(a, 16) - Integer.parseInt(input, 16)) < min) {
            out = a;
            min =  Math.abs(Integer.parseInt(a, 16) - Integer.parseInt(input, 16));
        }
        if (input.charAt(0) != '0' &&  Math.abs(Integer.parseInt(b, 16) - Integer.parseInt(input, 16)) < min) {
            out = b;
        }
        return out;
    }
}
