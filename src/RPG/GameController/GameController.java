package RPG.GameController;




import RPG.Character.Mage;
import RPG.Character.Ranger;
import RPG.Character.Rogue;
import RPG.Character.Warrior;

import java.util.Scanner;



public class GameController  {
    static Mage mage = new Mage("Mage");
    static Ranger ranger = new Ranger("Ranger");
    static Rogue rogue = new Rogue("Rogue");
    static Warrior warrior = new Warrior("Warrior");




    public static void Input(){
        System.out.println("Enter the number to chose the character");
        System.out.println("<1>-Mage-\n<2>-Ranger-\n<3>-Rogue-\n<4>-Warrior-");
        Scanner scanner = new Scanner(System.in);
        int scan = scanner.nextInt();
        switch (scan) {
            case 1 -> mage.display();
            case 2 -> ranger.display();
            case 3 -> rogue.display();
            case 4 -> warrior.display();
            default -> System.out.println("This Character does not exit");
        }
    }
    public static void main(String[] args) {
        Input();
    }




}
