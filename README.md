
![Java](https://img.shields.io/badge/Java-17+-blue?style=for-the-badge&logo=java)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-brightgreen?style=for-the-badge&logo=intellij-idea)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Development-orange?style=for-the-badge)

# 🎮 RPG Console Game

A console-based role-playing game (RPG) package containing classes for creating and managing characters and items.

---

## 🛠️ Classes

- **Mage**: Represents a character with magical abilities.
- **Warrior**: Represents a character with physical combat abilities.
- **Armor**: Represents a piece of armor that increases a character's defense.
- **Weapon**: Represents a weapon that increases a character's attack power.

---

## 🚀 How to Run the Project in IntelliJ IDEA

Follow these steps to run the project in **IntelliJ IDEA**:

1. **Open Your Project**:
   - Launch IntelliJ IDEA and open the project folder.

2. **Mark `src` as Sources Root**:
   - In the project navigation panel (left side), right-click the `src` folder.
   - Select **Mark Directory as** > **Sources Root**.

3. **Set Up Run Configuration**:
   - In the toolbar at the top, click the green **Run** button.
   - If no configuration exists, click **Edit Configurations** and create a new one for the project's main class.

4. **Run the Application**:
   - Select the correct run configuration from the dropdown menu.
   - Click the green **Run** button to start the game.

---

## 📦 Usage

To use this package, import the necessary classes into your Java files. For example:

```java
import RPG.Characters.Mage;
import RPG.Characters.Ranger;
import RPG.Characters.Rogue;
import RPG.Characters.Warrior;
import RPG.Item.Armor;
import RPG.Item.Slot;
import RPG.Item.Weapon;

🛡️ Equipable Weapons
Each hero can equip specific weapon types:

Mages: Staff, Wand
Rangers: Bow
Rogues: Dagger, Sword
Warriors: Axe, Hammer, Sword
👕 Equipable Armor
Heroes can also equip specific armor types:

Mages: Cloth
Rangers: Leather, Mail
Rogues: Leather, Mail
Warriors: Mail, Plate
📖 Example Code

Below is a complete example to demonstrate how to create characters, equip items, and display their attributes.

Character and Item Creation
// Create a Warrior named Thor
Warrior thor = new Warrior("Thor");

// Create a weapon and equip it
Weapon mjolnir = new Weapon("Mjolnir", 1, Slot.WEAPON, Weapon.Type.HAMMER, 5, 4.5);
thor.Equip(mjolnir);

// Create a piece of armor and equip it
Armor chestPlate = new Armor("Chest plate", 1, Slot.BODY, Armor.Type.PLATE, 10, 2, 1);
thor.Equip(chestPlate);

Displaying Character Stats
// Display the character's current stats and equipped items
thor.display();

Full Example
import RPG.Characters.Warrior;
import RPG.Item.Armor;
import RPG.Item.Slot;
import RPG.Item.Weapon;

public class RPGGame {
    public static void main(String[] args) {
        // Create a Warrior named Thor
        Warrior thor = new Warrior("Thor");

        // Create a weapon and equip it
        Weapon mjolnir = new Weapon("Mjolnir", 1, Slot.WEAPON, Weapon.Type.HAMMER, 5, 4.5);
        thor.Equip(mjolnir);

        // Create a piece of armor and equip it
        Armor chestPlate = new Armor("Chest plate", 1, Slot.BODY, Armor.Type.PLATE, 10, 2, 1);
        thor.Equip(chestPlate);

        // Display the character's current stats
        thor.display();
    }
}


📝 Additional Notes

The display() method in the Warrior class displays the character's current attributes, including equipped items.
Customize and expand the game by adding new characters, items, or features!
