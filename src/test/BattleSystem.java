package test;

import domain.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(ConsoleColor.YELLOW.color + " Bem-vindo ao jogo de aventura! " + ConsoleColor.RESET.color);
        System.out.println(ConsoleColor.CYAN.color + "Lute contra as linguagens paias para alcançar sua vaga de dev!" + ConsoleColor.RESET.color);
        System.out.println("---------------------");

        System.out.print("Escolha o nome do seu personagem: ");
        String nameCharacter = input.nextLine();
        MainCharacter character = new MainCharacter(nameCharacter);

        do {
            System.out.println(ConsoleColor.PURPLE.color + "----- CLASSES -----" + ConsoleColor.RESET.color);
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Mago");
            System.out.println("3 - Arqueiro");
            System.out.print("Escolha sua classe: ");
            int classOfCharacter = input.nextInt();

            if (classOfCharacter < 1 || classOfCharacter > 3) {
                System.out.println(ConsoleColor.RED.color + "Digite uma classe válida!" + ConsoleColor.RESET.color);
            } else {
                character.setClassOfCharacter(classOfCharacter);
                break;
            }
        } while (true);

        do {
            System.out.println("Escolha o nivel de dificuldade do jogo:");
            System.out.println("1 - Facil");
            System.out.println("2 - Normal");
            System.out.println("3 - Dificil");
            System.out.print("Escolha a opção: ");
            int getDifficulty = input.nextInt();
            switch (getDifficulty) {
                case 1:
                    character.setDifficultyChoose(Difficulty.FACIL.getDefenseDifficulty());
                    break;
                case 2:
                    character.setDifficultyChoose(Difficulty.NORMAL.getDefenseDifficulty());
                    break;
                case 3:
                    character.setDifficultyChoose(Difficulty.DIFICIL.getDefenseDifficulty());
                    break;
                default:
                    System.out.println(ConsoleColor.RED.color + "Escolha incorreta, digite novamente." + ConsoleColor.RESET.color);
            }
            break;
        } while (true);

        System.out.println("---------------------");
        System.out.println(ConsoleColor.GREEN.color + "" + character + ConsoleColor.RESET.color);
        System.out.println("---------------------");

        Potion potion1 = new Potion("Poção de Vida", 10, 30, "life");
        Potion potion2 = new Potion("Poção de Força", 15, 5, "strength");
        Potion potion3 = new Potion("Poção Grande de Vida", 25, 50, "life");
        Potion[] potions = new Potion[]{potion1, potion2, potion3};
        Shop shop = new Shop(potions);
        ArrayList<Potion> potionsOfCharacter = new ArrayList<>();

        do {
            System.out.println(ConsoleColor.BLUE.color + "===== LOJA DE POÇÕES =====" + ConsoleColor.RESET.color);
            shop.showItems();
            System.out.print("Digite o número da poção que deseja comprar (ou 0 para sair): ");
            int numberOfPotion = input.nextInt();

            switch (numberOfPotion) {
                case 1:
                    boolean isPurchased = shop.decreaseCoin(potion1.getPrice());
                    if (isPurchased) {
                        potionsOfCharacter.add(potion1);
                        System.out.println(ConsoleColor.GREEN.color + "Você comprou: " + potion1.getName() + ConsoleColor.RESET.color);
                    }
                    break;
                case 2:
                    boolean isPurchased2 = shop.decreaseCoin(potion2.getPrice());
                    if (isPurchased2) {
                        potionsOfCharacter.add(potion2);
                        System.out.println(ConsoleColor.GREEN.color + "Você comprou: " + potion2.getName() + ConsoleColor.RESET.color);
                    }
                    break;
                case 3:
                    boolean isPurchased3 = shop.decreaseCoin(potion3.getPrice());
                    if (isPurchased3) {
                        potionsOfCharacter.add(potion3);
                        System.out.println(ConsoleColor.GREEN.color + "Você comprou: " + potion1.getName() + ConsoleColor.RESET.color);
                    }
                    break;
                case 0:
                    System.out.println(ConsoleColor.YELLOW + "Boa sorte na batalha, meu nobre!" + ConsoleColor.RESET.color);
                    break;
                default:
                    System.out.println(ConsoleColor.RED.color + "Escolha incorreta, digite novamente." + ConsoleColor.RESET.color);
            }
            if (numberOfPotion == 0) break;
        } while (true);

        Enemy enemy = new Enemy("Javascript", 50, 30, character.getDifficultyChoose());

        System.out.println(ConsoleColor.RED.color + "Você encontrou o inimigo: " + enemy.getName() + ConsoleColor.RESET.color);
        System.out.println(ConsoleColor.CYAN.color + "Força do inimigo: " + enemy.getStrength() + ConsoleColor.RESET.color);
        System.out.println(ConsoleColor.CYAN.color + "Vida do inimigo: " + enemy.getLife() + ConsoleColor.RESET.color);
        boolean fight = true;
        Random random = new Random();

        do {
            System.out.println("---------------------");
            System.out.println("Seu turno:");
            System.out.println("1 - Atacar   2 - Usar Poção ");
            System.out.print("Escolha uma ação: ");
            int numberOfAction = input.nextInt();

            switch (numberOfAction) {
                case 1:
                    if (enemy.defend()) {
                        System.out.println("O inimigo defendeu seu ataque");
                        System.out.println(ConsoleColor.CYAN.color + "Vida do inimigo: " + enemy.getLife() + ConsoleColor.RESET.color);
                    } else {
                        character.attack(enemy);
                        if (enemy.verifyLife()) {
                            fight = false;
                            break;
                        }
                        System.out.println("---------------------");
                    }

                    System.out.println("Turno do inimigo:");

                    int numberRandom = random.nextInt(10);
                    if (numberRandom <= 3) {
                        enemy.attack(character);
                        if (character.verifyLife()) {
                            fight = false;
                            break;
                        }
                        break;
                    }
                    if (numberRandom > 3) {
                        boolean isDodge = character.defend();
                        if (isDodge) {
                            break;
                        }
                        enemy.attack(character);
                        if (character.verifyLife()) {
                            fight = false;
                            break;
                        }
                        System.out.println("---------------------");
                        break;
                    }
                case 2:
                    System.out.println(ConsoleColor.BLUE.color + "Suas poções disponíveis:" + ConsoleColor.RESET.color);
                    for (int i = 0; i < potionsOfCharacter.size(); i++) {
                        System.out.println((i + 1) + " - " + potionsOfCharacter.get(i).showPotion());
                    }
                    System.out.print("Digite o número da poção que deseja usar (ou 0 para sair): ");
                    int potionChoice = input.nextInt();
                    if (potionChoice > 0 && potionChoice <= potionsOfCharacter.size()) {
                        Potion chosenPotion = potionsOfCharacter.get(potionChoice - 1);
                        if (chosenPotion.getType().equals("life")) {
                            character.setActualLife(chosenPotion.getEffect());
                            System.out.println(ConsoleColor.GREEN.color + "Você restaurou sua vida!" + ConsoleColor.RESET.color);
                        }
                        if (chosenPotion.getType().equals("strength")) {
                            character.setStrength(chosenPotion.getEffect());
                            System.out.println(ConsoleColor.GREEN.color + "Sua força aumentou!" + ConsoleColor.RESET.color);
                        }
                        potionsOfCharacter.remove(potionChoice - 1);
                    }
                    break;
                default:
                    System.out.println(ConsoleColor.RED.color + "Ação inválida, tente novamente." + ConsoleColor.RESET.color);
            }
        } while (fight);
    }
}
