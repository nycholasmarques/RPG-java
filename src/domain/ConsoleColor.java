package domain;

public enum ConsoleColor {
    // Cores ANSI
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    CYAN("\u001B[36m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m");

    public String color;

    ConsoleColor(String color) {
        this.color = color;
    }
}
