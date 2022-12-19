package RPG.Character;

import RPG.Character;
import RPG.Exceptions.InvalidArmorException;
import RPG.Exceptions.InvalidWeaponException;
import RPG.Item.Armor;
import RPG.Item.Weapon;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 5, 2, 1);
        setCharacterDPS("strength");
    }

    // level up + set attributes.
    public void levelup() {
        setLevel();
        updateBaseAttributes(3, 2, 1);
        //call set CharacterDPS to re-calculate
        setCharacterDPS("strength");
    }

    //equip weapon
    public void Equip(Weapon weapon) throws InvalidWeaponException {
        //check weapon types else throw
        if (weapon.getWeaponType() == Weapon.Type.AXE || weapon.getWeaponType() == Weapon.Type.HAMMER || weapon.getWeaponType() == Weapon.Type.SWORD) {
            setEquipment(weapon);
            //call set CharacterDPS to re-calculate
            setCharacterDPS("strength");
        } else {
            throw new InvalidWeaponException(super.getName() + " can't equip " + weapon.getWeaponType() + " but can equip: Axes, Hammers and Swords.");
        }
    }

    //equip armor
    public void Equip(Armor armor) throws InvalidArmorException {
        //check armor types else throw
        if (armor.getArmorType() == Armor.Type.MAIL || armor.getArmorType() == Armor.Type.PLATE) {
            setEquipment(armor);
            //call set CharacterDPS to re-calculate
            setCharacterDPS("strength");
        } else {
            throw new InvalidArmorException(super.getName() + " can't equip " + armor.getArmorType() + " but can equip: Mail, Plate.");
        }
    }
}
