package domain;

public class Enemy implements Actions {

    private String name;
    private int life;
    private int strength;

    public Enemy() {

    }

    public Enemy(String name, int life, int strength) {
        this.name = name;
        this.life = life;
        this.strength = strength;
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


    @Override
    public void attack(MainCharacter character) {
//        int damage = character.getActualLife() - getStrength();
        character.decreaseActualLife(getStrength());
    }

    @Override
    public void attack(Enemy enemy) {

    }

    @Override
    public void defend() {

    }
}
