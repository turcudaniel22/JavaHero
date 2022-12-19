package RPG.Item;

import RPG.Character.PrimaryAttribute;

public class Armor extends Item {
    private PrimaryAttribute armorAttributes;

    //took some inspiration from: https://stackoverflow.com/questions/48627744/how-do-you-implement-an-enum-in-an-object-class-java/48627811
    public enum Type {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }
    public Armor(String name, int requiredLevel, Slot slot, Type type, int strength, int dexterity, int intelligence) {
        super(name, requiredLevel, slot, type);
        this.armorAttributes = new PrimaryAttribute(strength, dexterity, intelligence);
    }

    public String getArmorAttributes() {
        return this.armorAttributes.getAllAttributes();
    }

}
