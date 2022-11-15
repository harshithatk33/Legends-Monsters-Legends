/**
 * CharacterProducer : Character Producer Class consists of methods to call and produce the Hero or Monster Character.
 * Author : Harshitha T K
 * Date   : Nov 5
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterProducer {

    public static ArrayList<Character> produceCharacters(ArrayList<Character> characterList, String filename, String characterType) throws IOException {
        //String file;

        File file = new File("" + System.getProperty("user.dir") + "/src/gamedata/" + filename);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String[] array;
        HashMap<String, String> characterData = new HashMap<>();
        CharacterFactory factory = new CharacterFactory();

        read.readLine();
        for (; ; ) {
            String eachLine = read.readLine();
            if (eachLine == null) {
                break;
            }
            array = eachLine.split("#");

            if (characterType.equals("Heroes")) {
                characterData.put("name", array[0]);
                characterData.put("mana", array[1]);
                characterData.put("strength", array[2]);
                characterData.put("agility", array[3]);
                characterData.put("dexterity", array[4]);
                characterData.put("gold", array[5]);
                characterData.put("experience", array[6]);
            } else if (characterType.equals("Monsters")) {
                characterData.put("name", array[0]);
                characterData.put("level", array[1]);
                characterData.put("damage", array[2]);
                characterData.put("defense", array[3]);
                characterData.put("dodge", array[4]);
            }

            characterList.add(factory.createCharacter(characterType, characterData));
        }
        return characterList;
    }

//    public static void main(String args[]) throws IOException{
//
//        ArrayList<Character> c = new ArrayList<>();
//        System.out.println(produceCharacters(c,"dragons.txt","Monsters"));
//    }





}
