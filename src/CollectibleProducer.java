/**
 * CollectibleProducer :  produces the collectibles to create inventory to be used for heroes.
 * Author : Harshitha T K
 * Date   : Nov 5
 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CollectibleProducer {
    public static ArrayList<Collectible> produceCollectible(ArrayList<Collectible> collectibles, String filename, String collectibleType) throws FileNotFoundException, IOException {

        File file = new File("" + System.getProperty("user.dir") + "/src/gamedata/" + filename);
        BufferedReader itemRead = new BufferedReader(new FileReader(file));
        String[] array;
        HashMap<String, String> collectibleData = new HashMap<>();
        CollectibleFactory factory = new CollectibleFactory();
        itemRead.readLine();

        for (; ; ) {
            String eachLine = itemRead.readLine();
            if (eachLine == null) {
                break;
            }
            array = eachLine.split("#");

            if (collectibleType.equals("Weapon"))
            {
                collectibleData.put("name", array[0]);
                collectibleData.put("cost", array[1]);
                collectibleData.put("level", array[2]);
                collectibleData.put("damage", array[3]);
                collectibleData.put("numberOfHandsRequired", array[4]);
            }
            else if (collectibleType.equals(("Armour")))
            {
                collectibleData.put("name", array[0]);
                collectibleData.put("cost", array[1]);
                collectibleData.put("level", array[2]);
                collectibleData.put("damageReduction", array[3]);

            }
            else if ( collectibleType.equals("Potions"))
            {
                collectibleData.put("name", array[0]);
                collectibleData.put("cost", array[1]);
                collectibleData.put("level", array[2]);
                collectibleData.put("effectAmount", array[3]);
                collectibleData.put("typeOfPotion", array[4]);
            }
            else if (collectibleType.equals("Spells"))
            {
                collectibleData.put("name", array[0]);
                collectibleData.put("cost", array[1]);
                collectibleData.put("level", array[2]);
                collectibleData.put("damage", array[3]);
                collectibleData.put("manaCost", array[4]);
                collectibleData.put("spelltype", array[5]);
            }


            collectibles.add(factory.createSWAP(collectibleType, collectibleData));
        }
        return collectibles;
    }



}
