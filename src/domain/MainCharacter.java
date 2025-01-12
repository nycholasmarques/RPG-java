package domain;

import java.util.Random;
import java.util.Scanner;

public class MainCharacter {
    private String name;
    private String classOfCharacter;
    private int maxLife = 100;
    private int actualLife = maxLife;
    private int strength;
    private int difficultyChoose;

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

    public int getDifficultyChoose() {
        return difficultyChoose;
    }

    public void setDifficultyChoose(int difficultyChoose) {
        this.difficultyChoose = difficultyChoose;
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

    public boolean verifyLife () {
        if (getActualLife() <= 0) {
            System.out.println("Você perdeu pra uma linguagem de buxa \n" +
                    "Javascript te mandou uma mensagem: " +
                    "Eu te venci, bora larga essa bomba ai de java " +
                    "e começa um projetin em javascript PURO \n" +
                    "its over, tente novamente meu mano!");
            return true;
        }
        return false;
    }

    public void attack(Enemy enemy) {
        int damage = enemy.getLife() - getStrength();
        enemy.setLife(damage);
        System.out.println(ConsoleColor.GREEN.color + getName() + ConsoleColor.RESET.color + " atacou o " + ConsoleColor.RED.color +  enemy.getName() +
                ConsoleColor.RESET.color + " e causou " + getStrength() + " de dano");
        System.out.println(ConsoleColor.CYAN.color + "Vida do inimigo: " + enemy.getLife() + ConsoleColor.RESET.color);
    }

    public boolean defend() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int numberRandom1 = random.nextInt( 9);
        int numberRandom2 = random.nextInt( 9);
        int numberRandom3 = random.nextInt( 9);

        System.out.println("Você tem 4 segundos!!!");
        System.out.println("Digite os seguintes numeros para esquivar: " +
                numberRandom1 + " - " + numberRandom2 + " - " + numberRandom3);

        long init = System.currentTimeMillis();
        String dodge = input.next();
        long end = System.currentTimeMillis();
        long result = end - init;
        if (result >= 4000) {
            System.out.println("Você demorou muito para esquivar");
            return false;
        }

        if (Character.getNumericValue(dodge.charAt(0)) == numberRandom1 && Character.getNumericValue(dodge.charAt(1)) == numberRandom2 && Character.getNumericValue(dodge.charAt(2)) == numberRandom3) {
            System.out.println("Você se esquivou do ataque!");
            System.out.println(ConsoleColor.CYAN.color + "Sua vida: " + getActualLife() + ConsoleColor.RESET.color);
            return true;
        }
        System.out.println("Você errou a esquiva!");
        return false;
    }
}
