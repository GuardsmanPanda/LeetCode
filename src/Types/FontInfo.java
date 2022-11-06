package Types;

public interface FontInfo {
    // Return the width of char ch when fontSize is used.
    int getWidth(int fontSize, char ch);

    // Return Height of any char when fontSize is used.
    int getHeight(int fontSize);
}
