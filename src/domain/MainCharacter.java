package domain;

public class MainCharacter implements Actions {
    private String name;
    private String classOfCharacter;
    private int maxLife = 100;
    private int actualLife = maxLife;
    private int strength;

    public MainCharacter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Seu personagem: " + "\n" +
                "nome: " + name + "\n" +
                "classe: " + classOfCharacter + "\n" +
                "vida: " + actualLife + "\n" +
                "força: " + strength;
    }

    public String getName() {
        return name;
    }

    public String getClassOfCharacter() {
        return classOfCharacter;
    }

    public void setClassOfCharacter(int classOfCharacter) {
        ClassOfCharacter classCharacter = ClassOfCharacter.typeClassOfCharacter(classOfCharacter);
        assert classCharacter != null;
        this.strength = classCharacter.getStrengthClass();
        this.classOfCharacter = classCharacter.getName();
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getActualLife() {
        return actualLife;
    }

    public void setActualLife(int actualLife) {
        this.actualLife += actualLife;
        if (this.actualLife > this.maxLife) {
            this.actualLife = this.maxLife;
        }
    }

    public void decreaseActualLife(int actualLife) {
        this.actualLife -= actualLife;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    @Override
    public void attack(Enemy enemy) {
        int damage = enemy.getLife() - getStrength();
        enemy.setLife(damage);
    }

    @Override
    public void attack(MainCharacter mainCharacter) {

    }

    @Override
    public void defend() {
        System.out.println("VOCÊ TEM 2 a 7 SEGUNDOS PRA ESQUIVAR");
//        System.out.println("Tecle as letras " + words);
    }
}
