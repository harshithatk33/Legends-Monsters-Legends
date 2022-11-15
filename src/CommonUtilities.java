/**
 * CommonsUtilities : This class consists of all the common utilities that is useful for directly calling frequently used functionalities.
 * Author : Harshitha T K
 * Date   : Nov 5
 */

//import javax.print.attribute.standard.Media;

import javax.sound.sampled.*;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class CommonUtilities {
    public static ArrayList<Character> paladinsList;
    public static ArrayList<Character> sorcerersList;
    public static ArrayList<Character> warriorsList;

    public static ArrayList<Character> monsterList;

    public static ArrayList<Collectible> weaponsList;
    public static ArrayList<Collectible> potionsList;
    public static ArrayList<Collectible> armourList;
    public static ArrayList<Collectible> spellsList;

    public static InputStreamReader reader;
    public static BufferedReader input;

    static {
        reader = new InputStreamReader(System.in);
        input = new BufferedReader(reader);
    }

    public static Boolean spawnMonster() {
        int randomNumber = generateRandomNumber(12);
        return randomNumber == 2 || randomNumber % 5 == 0;
    }

    public static Integer generateRandomNumber(Integer range) {
        return (int) Math.floor(Math.random() * range);
    }

    public static void characterPool() {

        try {

            paladinsList = CharacterProducer.produceCharacters(new ArrayList<>(), "Paladins.txt", "Heroes");
            sorcerersList = CharacterProducer.produceCharacters(new ArrayList<>(), "Sorcerers.txt", "Heroes");
            warriorsList = CharacterProducer.produceCharacters(new ArrayList<>(), "Warriors.txt", "Heroes");

            monsterList = new ArrayList<>();

            monsterList = CharacterProducer.produceCharacters(monsterList, "Dragons.txt", "Monsters");
            monsterList = CharacterProducer.produceCharacters(monsterList, "Exoskeletons.txt", "Monsters");
            monsterList = CharacterProducer.produceCharacters(monsterList, "Spirits.txt", "Monsters");

        } catch (Exception error) {
            System.out.println(error);
        }

    }

    public static void itemPool() {
        try {
            potionsList = new ArrayList<>();
            spellsList = new ArrayList<>();
            weaponsList = new ArrayList<>();
            armourList = new ArrayList<>();

            weaponsList = CollectibleProducer.produceCollectible(weaponsList, "Weaponry.txt", "Weapon");
            potionsList = CollectibleProducer.produceCollectible(potionsList, "Potions.txt", "Potions");
            armourList = CollectibleProducer.produceCollectible(armourList, "Armory.txt", "Armour");

            spellsList = CollectibleProducer.produceCollectible(spellsList, "FireSpells.txt", "Spells");
            spellsList = CollectibleProducer.produceCollectible(spellsList, "IceSpells.txt", "Spells");
            spellsList = CollectibleProducer.produceCollectible(spellsList, "LightningSpells.txt", "Spells");

        } catch (Exception error) {
            System.out.println(error);
        }

    }

    public static void start(String fileName) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        // for playing background MUSIC
        //File url = new File(fileName);
        File file = new File("" + System.getProperty("user.dir") + "/src/GameSounds/" + fileName);
        //BufferedReader read = new BufferedReader(new FileReader(file));
        Clip audio = AudioSystem.getClip();

        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        audio.open(ais);
        audio.start();

    }

}

