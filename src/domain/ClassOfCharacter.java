package domain;

public enum ClassOfCharacter {
    GUERREIRO(1, "Guerreiro", 15),
    MAGO(2, "Mago", 10),
    ARQUEIRO(3, "Arqueiro", 12);

    public int value;
    private String name;
    private int strengthClass;

    ClassOfCharacter(int value, String name, int strengthClass) {
        this.value = value;
        this.name = name;
        this.strengthClass = strengthClass;
    }

    public static ClassOfCharacter typeClassOfCharacter(int valueOfClass) {
        for (ClassOfCharacter typeClass : values()) {
            if (typeClass.getValue() == valueOfClass) {
                return typeClass;
            }
        }
        return null;
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
