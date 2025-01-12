package domain;

public enum Difficulty {
    // A dificul
    FACIL(1, "Facil", 3),
    NORMAL(2, "Normal", 5),
    DIFICIL(3, "Dificil", 7);

    public int value;
    private String name;
    private int defenseDifficulty;

    Difficulty(int value, String name, int defenseDifficulty) {
        this.value = value;
        this.name = name;
        this.defenseDifficulty = defenseDifficulty;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getDefenseDifficulty() {
        return defenseDifficulty;
    }
}
