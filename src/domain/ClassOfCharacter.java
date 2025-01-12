package domain;

public enum ClassOfCharacter {
    GUERREIRO(1, "Guerreiro", 15, 18),
    MAGO(2, "Mago", 10, 8),
    ARQUEIRO(3, "Arqueiro", 12, 14);

    public int value;
    private String name;
    private int strengthClass;
    private int defenseLevel;

    ClassOfCharacter(int value, String name, int strengthClass, int defenseLevel) {
        this.value = value;
        this.name = name;
        this.strengthClass = strengthClass;
        this.defenseLevel = defenseLevel;
    }

    public static ClassOfCharacter typeClassOfCharacter(int valueOfClass) {
        for (ClassOfCharacter typeClass : values()) {
            if (typeClass.getValue() == valueOfClass) {
                return typeClass;
            }
        }
        return null;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getStrengthClass() {
        return strengthClass;
    }

}
