package test;


import RPG.Character.Mage;
import RPG.Character.Ranger;
import RPG.Character.Rogue;
import RPG.Character.Warrior;
import RPG.Exceptions.InvalidArmorException;
import RPG.Exceptions.InvalidWeaponException;
import RPG.Item.Armor;
import RPG.Item.Item;
import RPG.Item.Slot;
import RPG.Item.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Mage testMage;
    Ranger testRanger;
    Rogue testRogue;
    Warrior testWarrior;

    @BeforeEach
    void setUp() {
        testMage = new Mage("testMage");
        testRanger = new Ranger("testRanger");
        testRogue = new Rogue("testRogue");
        testWarrior = new Warrior("testWarrior");
    }

    //Character attribute and level tests
    @Test
    void getStartLevel_ValidInputs_shouldReturnOne() {
        int expected = 1;
        int actual = testMage.getLevel();
        assertEquals(expected, actual);
    }

    @Test
    void levelUp_validInputs_shouldReturnTwo() {
        int expected = 2;
        testMage.levelup();
        int actual = testMage.getLevel();
        assertEquals(expected, actual);
    }

    @Test
    void mageDefaultAttributes_validInputs_ShouldReturnOneOneEight() {
        String expected = "1,1,8";
        String actual = testMage.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void rangerDefaultAttributes_validInputs_ShouldReturnOneSevenOne() {
        String expected = "1,7,1";
        String actual = testRanger.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void rogueDefaultAttributes_validInputs_ShouldReturnTwoSixOne() {
        String expected = "2,6,1";
        String actual = testRogue.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void warriorDefaultAttributes_validInputs_ShouldReturnFiveTwoOne() {
        String expected = "5,2,1";
        String actual= testWarrior.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void mageAttributeIncrease_validInputs_shouldReturnTwoTwoThirteen() {
        testMage.levelup();
        String expected = "2,2,13";
        String actual = testMage.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void rangerAttributeIncrease_validInputs_shouldReturnTwoTwelveTwo(){
        testRanger.levelup();
        String expected = "2,12,2";
        String actual = testRanger.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void rogueAttributesIncrease_validInputs_shouldReturnThreeTenTwo() {
        testRogue.levelup();
        String expected = "3,10,2";
        String actual = testRogue.getBaseAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void warriorAttributeIncrease_validInputs_shouldReturnEightFourTwo() {
        testWarrior.levelup();
        String expected = "8,4,2";
        String actual = testWarrior.getBaseAttributes();
        assertEquals(expected, actual);
    }

    //Items and equipment tests
    @Test
    void highLevelWeapon_invalidInputs_shouldThrowInvalidWeaponException() {
        Weapon testWeapon = new Weapon("Common Axe", 2, Slot.WEAPON, Weapon.Type.AXE, 7, 1.1);
        String expected = "The level of this weapon is to high for " + testWarrior.getName() + " to equip.";

        Exception exception = assertThrows(InvalidWeaponException.class, () -> testWarrior.Equip(testWeapon));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void highLevelArmor_invalidInputs_shouldThrowInvalidArmorException() {
        Armor testPlateBody = new Armor("Common Plate Body Armor", 2, Slot.BODY, Armor.Type.PLATE, 1, 0,0);
        String expected = "The level of this armor is to high for " + testWarrior.getName() + " to equip.";

        Exception exception = assertThrows(InvalidArmorException.class, () -> testWarrior.Equip(testPlateBody));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void wrongWeaponType_invalidInputs_shouldThrowInvalidWeaponException() {
        Weapon testBow = new Weapon("Common Bow", 1, Slot.WEAPON, Weapon.Type.BOW, 12, 0.8);
        String expected = testWarrior.getName() + " can't equip " + testBow.getWeaponType() + " but can equip: Axes, Hammers and Swords.";

        Exception exception = assertThrows(InvalidWeaponException.class, () -> testWarrior.Equip(testBow));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void wrongArmorType_invalidInputs_shouldThrowInvalidArmorException() {
        Armor testClothHead = new Armor("Common Plate Body Armor", 1, Slot.HEAD, Armor.Type.CLOTH, 0, 0,5);
        String expected = testWarrior.getName() + " can't equip " + testClothHead.getArmorType() + " but can equip: Mail, Plate.";

        Exception exception = assertThrows(InvalidArmorException.class, () -> testWarrior.Equip(testClothHead));
        String actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void equipCorrectWeapon_validInputs_shouldReturnTrue() throws InvalidWeaponException {
        Weapon testWeapon = new Weapon("Common Axe", 1, Slot.WEAPON, Weapon.Type.AXE, 7, 1.1);
        testWarrior.Equip(testWeapon);
        HashMap<Slot, Item> expected = new HashMap<>();
        expected.put(testWeapon.getSlot(), testWeapon);

        HashMap<Slot, Item> actual = testWarrior.getEquipment();

        assertTrue(expected.equals(actual));
    }

    @Test
    void equipCorrectArmor_validInputs_shouldReturnTrue() throws InvalidArmorException {
        Armor testPlateBody = new Armor("Common Plate Body Armor", 1, Slot.BODY, Armor.Type.PLATE, 1, 0,0);
        testWarrior.Equip(testPlateBody);
        HashMap<Slot, Item> expected = new HashMap<>();
        expected.put(testPlateBody.getSlot(), testPlateBody);

        HashMap<Slot, Item> actual = testWarrior.getEquipment();
        assertTrue(expected.equals(actual));
    }

    //DPS test
    @Test
    void calculateDPSNoWeapon_validInputs_shouldReturnDPS() {
        double expected = 1 * (1 + (5 / 100));
        double actual = testWarrior.getCharacterDPS();
        assertEquals(expected, actual);
    }

    @Test
    void calculateDPSWithWeapon_validInputs_shouldReturnDPS() throws InvalidWeaponException {
        Weapon testWeapon = new Weapon("Common Axe", 1, Slot.WEAPON, Weapon.Type.AXE, 7, 1.1);
        testWarrior.Equip(testWeapon);

        double expected = (7 * 1.1)*(1 + (5 / 100));
        double actual = testWarrior.getCharacterDPS();
        assertEquals(expected, actual);
    }

    @Test
    void calculateDPSWithWeaponArmor_validInputs_shouldReturnDPS() throws InvalidWeaponException, InvalidArmorException {
        Weapon testWeapon = new Weapon("Common Axe", 1, Slot.WEAPON, Weapon.Type.AXE, 7, 1.1);
        Armor testPlateBody = new Armor("Common Plate Body Armor", 1, Slot.BODY, Armor.Type.PLATE, 1, 0,0);
        testWarrior.Equip(testWeapon);
        testWarrior.Equip(testPlateBody);

        double expected =  (7 * 1.1) * (1 + ((5+1) / 100));
        double actual = testWarrior.getCharacterDPS();
        assertEquals(expected, actual);

    }

}
