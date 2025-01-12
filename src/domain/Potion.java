package domain;

public class Potion {
    private String name;
    private int price;
    private int effect;
    private String type;

    public Potion(String name, int price, int effect, String type) {
        this.name = name;
        this.price = price;
        this.effect = effect;
        this.type = type;
    }

    public String showPotion () {
        if (type == "life") {
            return name + " (restaura " + effect + " de vida)" +  " - " + price + " moedas";
        } else {
            return name + " (aumenta " + effect + " de força)" +  " - " + price + " moedas";
        }
    }

    @Override
    public String toString() {
        return "Potion{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", effect=" + effect +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getEffect() {
        return effect;
    }

    public String getType() {
        return type;
    }

}