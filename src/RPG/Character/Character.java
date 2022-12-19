package RPG.Character;

import RPG.Exceptions.InvalidArmorException;
import RPG.Exceptions.InvalidWeaponException;
import RPG.Item.Armor;
import RPG.Item.Item;
import RPG.Item.Slot;
import RPG.Item.Weapon;
import java.util.HashMap;

public abstract class Character {
    //fields
    private final String name;
    private int level;
    private double characterDamage;
    private PrimaryAttribute basePrimaryAttributes;
    private PrimaryAttribute totalPrimaryAttributes;
    private HashMap<Slot, Item> equipment;

    //constructor
    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.level = 1;
        this.basePrimaryAttributes = new PrimaryAttribute(strength, dexterity, intelligence); //set up PrimaryAttribute
        this.totalPrimaryAttributes = new PrimaryAttribute(); //set up empty total PrimaryAttribute
        this.equipment = new HashMap<>();
    }

    //getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getBaseAttributes() {
        return this.basePrimaryAttributes.getAllAttributes();
    }

    public HashMap<Slot, Item> getEquipment() {
        // cycle through all equipment and print type + name
        for (Slot i: this.equipment.keySet()) {
            System.out.println(i + " " + this.equipment.get(i).getName());
        }
        return equipment;
    }

    public String getTotalPrimaryAttributes() {
        //first go to setTotal to check the gear and get up to date attributes
        updateTotalPrimaryAttributes();
        return totalPrimaryAttributes.getAllAttributes();
    }

    public double getCharacterDPS() {
        return characterDamage;
    }

    //setters
    public void setLevel(){
        this.level++;
    }

    public void setCharacterDPS(String main) {
        //first go to setTotal to check the gear and get up to date attributes
        updateTotalPrimaryAttributes();
        //  initialize mainAttr
        int mainAttribute = 0;
        // check which is main attribute + get.
              if  (main.equals("strength")){
                  mainAttribute = totalPrimaryAttributes.getStrength();
              }  else if (main.equals("dexterity")) {
                  mainAttribute = totalPrimaryAttributes.getDexterity();
              } else if (main.equals("intelligence")) {
                  mainAttribute = totalPrimaryAttributes.getIntelligence();
              }
              // if weapon slot is not empty
        if (this.equipment.get(Slot.WEAPON) != null) {
            double weaponDPS = ((Weapon) this.equipment.get(Slot.WEAPON)).getDPS();
            this.characterDamage = weaponDPS * (1 + (mainAttribute / 100));
        } else {
            this.characterDamage = (1 + (mainAttribute / 100));
        }
    }

    //methods
    //update base attributes (happens when level up to add new attributes)
    public void updateBaseAttributes(int strength, int dexterity, int intelligence) {
        this.basePrimaryAttributes.setAllAttributes(
                this.basePrimaryAttributes.getStrength() + strength,
                this.basePrimaryAttributes.getDexterity() + dexterity,
                this.basePrimaryAttributes.getIntelligence() + intelligence
        );
    }

    public void updateTotalPrimaryAttributes() {
        int strength = 0;
        int dexterity = 0;
        int intelligence = 0;
        //loop through gear character is wearing now
        for (Slot i: this.equipment.keySet()) {
            // check only for armor
            if (i == Slot.HEAD || i == Slot.BODY || i == Slot.LEGS) {
                //split armor attributes in array
                String[] parts = ((Armor) this.equipment.get(i)).getArmorAttributes().split(",");
                //getting right indexes + get base attr
                strength = Integer.parseInt(parts[0]) + this.basePrimaryAttributes.getStrength();
                dexterity = Integer.parseInt(parts[1]) + this.basePrimaryAttributes.getDexterity();
                intelligence = Integer.parseInt(parts[2]) + this.basePrimaryAttributes.getIntelligence();
            }
        }
        this.totalPrimaryAttributes.setAllAttributes(strength, dexterity, intelligence);
    }

    public void setEquipment(Weapon weapon) throws InvalidWeaponException {
        // level check else throw
        if (weapon.getRequiredLevel() <= this.level) {
            // add to HashMap
            equipment.put(weapon.getSlot(), weapon);
        } else {
            throw new InvalidWeaponException("The level of this weapon is to high for " + this.getName() + " to equip.");
        }
    }

    public void setEquipment(Armor armor) throws InvalidArmorException {
        // level check else throw
        if (armor.getRequiredLevel() <= this.level) {
            // add to HashMap
            equipment.put(armor.getSlot(), armor);
        } else {
            throw new InvalidArmorException("The level of this armor is to high for " + this.getName() + " to equip.");
        }
    }

    //return summary of character
    public void display() {
        StringBuilder charStats = new StringBuilder();

        charStats.append(
                "Character = " + this.getName() + '\n' +
                        "level = " + this.getLevel() + '\n' +
                        "Strength = " + this.totalPrimaryAttributes.getStrength() + '\n' +
                        "Dexterity = " + this.totalPrimaryAttributes.getDexterity() + '\n' +
                        "Intelligence = " + this.totalPrimaryAttributes.getIntelligence() + '\n' +
                        "characterDPS = " + characterDamage).toString();

        System.out.println(charStats);
    }
}
