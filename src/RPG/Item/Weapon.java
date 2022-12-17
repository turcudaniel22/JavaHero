package RPG.Item;

public class Weapon extends Item {
    private final double DPS;

        //took some inspiration from: https://stackoverflow.com/questions/48627744/how-do-you-implement-an-enum-in-an-object-class-java/48627811
        public enum Type {
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    //constructor
    public Weapon(String name, int requiredLevel, Slot slot, Type type, int damage, double attackPerSec) {
        super(name, requiredLevel, slot, type);
        this.DPS = damage * attackPerSec;
    }

    public double getDPS() {
        return DPS;
    }


}
