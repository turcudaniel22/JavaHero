package RPG.Exceptions;

public class InvalidWeaponException extends Exception{

    // credit: https://alvinalexander.com/java/java-custom-exception-create-throw-exception/
    public InvalidWeaponException(String message) {
        super(message);
    }
}
