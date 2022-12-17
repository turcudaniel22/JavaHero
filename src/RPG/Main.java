package RPG;

import RPG.Character.Warrior;
import RPG.Item.Armor;
import RPG.Item.Slot;
import RPG.Item.Weapon;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        Warrior thor = new Warrior("Thor");

        Weapon mjolnir = new Weapon("Mjolnir", 1, Slot.WEAPON, Weapon.Type.HAMMER,5, 4.5);
        thor.Equip(mjolnir);

        Armor chestPlate = new Armor("Chest plate", 1, Slot.BODY, Armor.Type.PLATE, 10, 2, 1);
        thor.Equip(chestPlate);


        thor.display();
    }
}
