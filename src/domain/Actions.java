package domain;

public interface Actions {

    void attack(Enemy enemy);
    void attack(MainCharacter mainCharacter);
    void defend();
}
