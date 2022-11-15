/**
 * CharacterFactory : is an abstract class for the virtual constructor for producing Characters for the game.
 * Author : Harshitha T K
 * Date   : Nov 5
 */
import java.util.HashMap;

public class CharacterFactory {
    public Character createCharacter(String characterType, HashMap<String, String> characterDetails) throws IllegalStateException {
        if (characterType.equals("Heroes")) {
            return new Heroes(characterDetails.get("name"), 100, 1, Integer.parseInt(characterDetails.get("mana")),
                    Integer.parseInt(characterDetails.get("strength")), Integer.parseInt(characterDetails.get("dexterity")),
                    Integer.parseInt(characterDetails.get("gold")), Integer.parseInt(characterDetails.get("agility")),
                    Integer.parseInt(characterDetails.get("experience")));
        } else if (characterType.equals("Monsters")) {
            return new Monsters(characterDetails.get("name"), Integer.parseInt(characterDetails.get("level")) * 100,
                    Integer.parseInt(characterDetails.get("level")), Integer.parseInt(characterDetails.get("damage")), Integer.parseInt(characterDetails.get("defense")),
                    Integer.parseInt(characterDetails.get("dodge")));
        } else {
            throw new IllegalStateException("Invalid Character type");
        }

    }
}
