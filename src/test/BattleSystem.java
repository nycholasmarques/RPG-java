package test;

import domain.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Cores ANSI
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String CYAN = "\u001B[36m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";

        System.out.println(YELLOW + "Bem-vindo ao jogo de aventura!" + RESET);
        System.out.println(CYAN + "Lute contra as linguagens paias para alcançar sua vaga de dev!" + RESET);
        System.out.println("---------------------");

        System.out.print("Escolha o nome do seu personagem: ");
        String nameCharacter = input.nextLine();
        MainCharacter character = new MainCharacter(nameCharacter);

        do {
            System.out.println(PURPLE + "----- CLASSES -----" + RESET);
            System.out.println("1 - Guerreiro");
            System.out.println("2 - Mago");
            System.out.println("3 - Arqueiro");
            System.out.print("Escolha sua classe: ");
            int classOfCharacter = input.nextInt();

            if (classOfCharacter < 1 || classOfCharacter > 3) {
                System.out.println(RED + "Digite uma classe válida!" + RESET);
            } else {
                character.setClassOfCharacter(classOfCharacter);
                break;
            }
        } while (true);

        System.out.println("---------------------");
        System.out.println(GREEN + character + RESET);
        System.out.println("---------------------");

        Potion potion1 = new Potion("Poção de Vida", 10, 30, "life");
        Potion potion2 = new Potion("Poção de Força", 15, 5, "strength");
        Potion potion3 = new Potion("Poção Grande de Vida", 25, 50, "life");
        Potion[] potions = new Potion[]{potion1, potion2, potion3};
        Shop shop = new Shop(potions);
        ArrayList<Potion> potionsOfCharacter = new ArrayList<>();

        do {
            System.out.println(BLUE + "===== LOJA DE POÇÕES =====" + RESET);
            shop.showItems();
            System.out.print("Digite o número da poção que deseja comprar (ou 0 para sair): ");
            int numberOfPotion = input.nextInt();

            switch (numberOfPotion) {
                case 1:
                    boolean isPurchased = shop.decreaseCoin(potion1.getPrice());
                    if (isPurchased) {
                        potionsOfCharacter.add(potion1);
                        System.out.println(GREEN + "Você comprou: " + potion1.getName() + RESET);
                    }
                    break;
                case 2:
                    boolean isPurchased2 = shop.decreaseCoin(potion2.getPrice());
                    if (isPurchased2) {
                        potionsOfCharacter.add(potion2);
                        System.out.println(GREEN + "Você comprou: " + potion2.getName() + RESET);
                    }
                    break;
                case 3:
                    boolean isPurchased3 = shop.decreaseCoin(potion3.getPrice());
                    if (isPurchased3) {
                        potionsOfCharacter.add(potion3);
                        System.out.println(GREEN + "Você comprou: " + potion1.getName() + RESET);
                    }
                    break;
                case 0:
                    System.out.println(YELLOW + "Boa sorte na batalha, meu nobre!" + RESET);
                    break;
                default:
                    System.out.println(RED + "Escolha incorreta, digite novamente." + RESET);
            }
            if (numberOfPotion == 0) break;
        } while (true);

        Enemy enemy = new Enemy("Javascript", 50, 30);

        System.out.println(RED + "Você encontrou o inimigo: " + enemy.getName() + RESET);
        System.out.println(CYAN + "Força do inimigo: " + enemy.getStrength() + RESET);
        System.out.println(CYAN + "Vida do inimigo: " + enemy.getLife() + RESET);
//        System.out.println(CYAN + "Sua vida: " + character.getActualLife() + RESET);
        boolean fight = true;
        do {
            System.out.println("---------------------");
            System.out.println("Seu turno:");
            System.out.println("1 - Atacar   2 - Usar Poção ");
            System.out.print("Escolha uma ação: ");
            int numberOfAction = input.nextInt();

            switch (numberOfAction) {
                case 1:
                    character.attack(enemy);
                    if (enemy.getLife() <= 0) {
                        System.out.println(GREEN + "Você derrotou o " + enemy.getName() + "! BOA MEU NOBRE!" + RESET);
                        fight = false;
                        break;
                    }
                    System.out.println(GREEN + character.getName() + RESET + " atacou o " + RED +  enemy.getName() +
                            RESET + " e causou " + character.getStrength() + " de dano");
                    System.out.println(CYAN + "Vida do inimigo: " + enemy.getLife() + RESET);
                    System.out.println("---------------------");
                    System.out.println("Turno do inimigo:");
                    enemy.attack(character);
                    if (character.getActualLife() <= 0) {
                        System.out.println("Você perdeu pra uma linguagem de buxa \n" +
                                "você é buxa ao quadrado, tente novamente meu mano!");
                        fight = false;
                        break;
                    }
                    System.out.println(RED +  enemy.getName() +
                            RESET + " atacou o " + GREEN + character.getName()
                            + RESET + " e causou " + enemy.getStrength() + " de dano");
                    System.out.println(CYAN + "Sua vida: " + character.getActualLife() + RESET);
                    break;
                case 2:
                    System.out.println(BLUE + "Suas poções disponíveis:" + RESET);
                    for (int i = 0; i < potionsOfCharacter.size(); i++) {
                        System.out.println((i + 1) + " - " + potionsOfCharacter.get(i).showPotion());
                    }
                    System.out.print("Digite o número da poção que deseja usar (ou 0 para sair): ");
                    int potionChoice = input.nextInt();
                    if (potionChoice > 0 && potionChoice <= potionsOfCharacter.size()) {
                        Potion chosenPotion = potionsOfCharacter.get(potionChoice - 1);
                        if (chosenPotion.getType().equals("life")) {
                            character.setActualLife(chosenPotion.getEffect());
                            System.out.println(GREEN + "Você restaurou sua vida!" + RESET);
                        }
                        if (chosenPotion.getType().equals("strength")) {
                            character.setStrength(chosenPotion.getEffect());
                            System.out.println(GREEN + "Sua força aumentou!" + RESET);
                        }
                        potionsOfCharacter.remove(potionChoice - 1);
                    }
                    break;
                default:
                    System.out.println(RED + "Ação inválida, tente novamente." + RESET);
            }
        } while (fight);
    }
}
