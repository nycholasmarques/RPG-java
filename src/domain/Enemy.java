package domain;

import java.util.Random;

public class Enemy {

    private String name;
    private int life;
    private int strength;
    private int difficultyChoose;


    public Enemy(String name, int life, int strength, int difficultyChoose) {
        this.name = name;
        this.life = life;
        this.strength = strength;
        this.difficultyChoose = difficultyChoose;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", strength=" + strength +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public int getDifficultyChoose() {
        return difficultyChoose;
    }

    public void setDifficultyChoose(int difficultyChoose) {
        this.difficultyChoose = difficultyChoose;
    }

    public boolean verifyLife () {
        if (getLife() <= 0) {
//            System.out.println(GREEN + "Você derrotou o " + getName() + "! BOA MEU NOBRE!" + RESET);
            System.out.println("Você derrotou o " + getName() + "! BOA MEU NOBRE!");
            return true;
        }
        return false;
    }

    public void attack(MainCharacter character) {
//        int damage = character.getActualLife() - getStrength();
        character.decreaseActualLife(getStrength());
        System.out.println(ConsoleColor.RED.color +  getName() +
                ConsoleColor.RESET.color + " te atacou " + " e causou " + getStrength() + " de dano");
        System.out.println(ConsoleColor.CYAN.color + "Sua vida: " + character.getActualLife() + ConsoleColor.RESET.color);
    }

    public boolean defend() {
        Random random = new Random();
        int numberRandom = random.nextInt( 10);
        return numberRandom <= difficultyChoose;
    }
}
