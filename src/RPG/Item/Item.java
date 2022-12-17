package RPG.Item;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final Slot slot;
    private Weapon.Type weaponType;
    private Armor.Type armorType;

    // constructor for weapon
    public Item(String name, int requiredLevel, Slot slot, Weapon.Type type) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
        this.weaponType = type;
    }

    //constructor for Armor
    public Item(String name, int requiredLevel, Slot slot, Armor.Type type) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
        this.armorType = type;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }

    public Weapon.Type getWeaponType() {
        return weaponType;
    }

    public Armor.Type getArmorType() {
        return armorType;
    }
}
