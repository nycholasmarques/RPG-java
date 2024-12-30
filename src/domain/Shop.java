package domain;

import java.util.Arrays;

public class Shop {
    private Potion[] potions;
    private int coin = 50;

    public Shop(Potion[] potions) {
        this.potions = potions;
    }

    public void showItems () {
        System.out.println("Você tem: " + getCoin() + " moedas");
        for (int i = 0; i < potions.length; i++) {
            System.out.println((i + 1) + " - " + potions[i].showPotion());
        }
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin += coin;
    }

    public boolean decreaseCoin(int coin) {
        if (this.coin < coin) {
            System.out.println("Você não tem moedas suficientes, vá lutar meu mano");
            return false;
        }
        this.coin -= coin;
        return true;
    }
}
