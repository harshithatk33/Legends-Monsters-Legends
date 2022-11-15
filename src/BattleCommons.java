/**
 * BattaleCommons : This class consists of all the common methods to re-use that is needed for a hero and a monster to battle.
 * Author : Harshitha T K
 * Date   : Nov 5
 */

import java.io.IOException;

public class BattleCommons {


    private static Integer chosenHero;
    private static Integer chosenMonster;


    public static Integer getChosenHero() {
        return chosenHero;
    }

    public static void setChosenHero(Integer chosenHero) {
        BattleCommons.chosenHero = chosenHero;
    }

    public static Integer getChosenMonster() {
        return chosenMonster;
    }

    public static void setChosenMonster(Integer chosenMonster) {
        BattleCommons.chosenMonster = chosenMonster;
    }

    public static void chooseHero() {
        try {
            System.out.println("Find the chosen Heroes below");
            BattleCommons.displayTeam("Heroes");

            System.out.println("Please choose the Hero number, who you would like to start the battle with");
            int input = Integer.parseInt(CommonUtilities.input.readLine());

            if (input < 0 || input > HeroesAndMonsters.getHeroTeam().getSizeOfTeam() || ((Heroes)(HeroesAndMonsters.getHeroTeam().getListOfCharacters().get(input))).isFaint()) {
                throw new IllegalStateException("Bad Value");
            }

            setChosenHero(input);
        } catch (Exception error) {
            System.out.println("Internel Server Error!! Let's try again, shall we?");
            chooseHero();
        }
    }

    public static void chooseMonster() {
        setChosenMonster((int) Math.floor(Math.random() * HeroesAndMonsters.getMonsterTeam().getListOfCharacters().size()));
    }

    // This method is used to display the monster/Heroes list after the player chooses which heroes he wants and monsters gets swamped randomly
    public static void displayTeam(String teamType) throws IOException {
        Monsters monster;
        Heroes hero;
        System.out.println("Find the below List of ****** " + teamType.toUpperCase() + " ******");

        try {

            System.out.println("|----------------------------------------------------------------------------------------------------------------|");
            if (teamType.equalsIgnoreCase("monsters")) {
                System.out.format("|%5s  %22s  %10s %10s %10s %10s %10s    |\n", "No.", "Name", "level", "damage", "defense", "dodge", "HP");
                for (int i = 0; i < (HeroesAndMonsters.getMonsterTeam().getSizeOfTeam()); i++) {
                    monster = ((Monsters) HeroesAndMonsters.getMonsterTeam().getCharacter(i));
                    System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                    System.out.format("|%5s  %22s  %10d %10d %10d %10d %10d     |\n", (i + 1) + ".", monster.getNameOfObject(), monster.getCharacterLevel(), monster.getBaseDamage(), monster.getDefenseValue(), monster.getDodgeValue(), monster.getCurrentHP());
                }
            } else {
                System.out.format("|%5s  %22s  %10s %10s %10s %10s %10s %10s %10s    |\n", "No.", "Name", "mana", "strength", "agility", "dexterity", "gold", "experience", "HP");
                for (int i = 0; i < (HeroesAndMonsters.getHeroTeam().getSizeOfTeam()); i++) {
                    hero = ((Heroes) HeroesAndMonsters.getHeroTeam().getCharacter(i));
                    if (!hero.isFaint()) {
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.format("|%5s  %22s  %10d %10d %10d %10d %10d %10d %10d     |\n", (i + 1) + ".", hero.getNameOfObject(), hero.getMaximumMP(), hero.getStrengthValue(), hero.getAgilityValue(), hero.getDexterityValue(), hero.getGold(), hero.getExperience(), hero.getCurrentHP());
                    }
                }
            }
            System.out.println("|----------------------------------------------------------------------------------------------------------------|");

        } catch (Exception error) {
            System.out.println(error);
        }

    }

    public static Integer calculateDamageWithWeapon(Heroes hero) {
        return (int) ((hero.getStrengthValue() + ((Weapon) hero.getEquippedWeapon()).getDamageValue()) * 0.05);
    }

    public static Integer calculateDamageWithoutWeapon(Heroes hero) {
        return (int) (hero.getStrengthValue() * 0.05);
    }

    // this method is for calculating the effect after using a Spell

    public static boolean dodgeChance(Integer dodgeval) {

        return ((dodgeval / 5) % 3) == 0;
    }

    public static Integer calculateDamageWithoutArmour(Monsters mon) {
        return (int) (mon.getBaseDamage() * 0.05);
    }

    public static Integer calculateDamageWithoutArmour(Heroes hero, Monsters mon) {
        return (int) ((mon.getBaseDamage() * 0.05) - (((Armour) (hero.getEquippedArmour())).getDamageReduction() * 0.005));
    }

    public static void heroAttack(Teams hero, Teams monster) {
        Monsters mon = (Monsters) monster.getCharacter(getChosenMonster());
        if (dodgeChance(mon.getDodgeValue())) {
            System.out.println("Monster dodged the Hero's Attack");
            return;
        }
        Heroes her = (Heroes) hero.getCharacter(getChosenHero());
        int attackValue;

        if (her.isWeaponExists()) {
            attackValue = calculateDamageWithWeapon(her);
        } else {
            attackValue = calculateDamageWithoutWeapon(her);
        }

        System.out.println("**********************ATTACK DETAILS FOR THIS ROUND********************");
        System.out.println("Hero Name (Attacker) :" + hero.getCharacter(getChosenHero()).getNameOfObject());
        System.out.println("Monster Name (Attack happend on) :" + monster.getCharacter(getChosenMonster()).getNameOfObject());
        System.out.println(" Monster has a damage of :" + attackValue);

        if (attackValue >= mon.getCurrentHP()) {
            try {
                CommonUtilities.start("MonsterDies.wav");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Monster is dead :)");
                monster.getListOfCharacters().remove(getChosenMonster());
                // Selecting random monster
            }
        } else {
            mon.setCurrentHP(mon.getCurrentHP() - attackValue);
        }

    }

    public static void monsterAttack(Teams hero, Teams monster) {
        Monsters mon = (Monsters) monster.getCharacter(getChosenMonster());
        Heroes her = (Heroes) hero.getCharacter(getChosenHero());
        int attackValue;

        if (dodgeChance(her.getAgilityValue())) {
            System.out.println("Hero dodged the monsters's Attack");
            return;
        }

        if (her.isArmourExists()) {
            attackValue = calculateDamageWithoutArmour(mon);
        } else {
            attackValue = calculateDamageWithoutArmour(her, mon);
        }

        System.out.println("********************** ATTACK DETAILS FOR THIS ROUND ********************");
        System.out.println("Monster Name (Attacker) :" + monster.getCharacter(getChosenMonster()).getNameOfObject());
        System.out.println("Hero Name (Attack happend on) :" + hero.getCharacter(getChosenHero()).getNameOfObject());
        System.out.println(" Hero has a damage of :" + attackValue);


        if (attackValue >= her.getCurrentHP()) {
            her.setFaint(true);
            System.out.println(" Hero fainted :( ");
            //hero.getListOfCharacters().remove(getChosenHero());
            // Selecting random monster
        } else {
            her.setCurrentHP(mon.getCurrentHP() - attackValue);
        }
    }

    public static void displayHeroesWeapons(Heroes hero) {

        Weapon weap;
        try {
            System.out.format("|%5s  %22s  %10s %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage", "RequiredHands");

            for (int i = 0; i < (hero.getWeapons()).size(); i++) {
                weap = (Weapon) hero.getWeapons().get(i);
                System.out.println("|********************************************************************************|");
                System.out.format("|%5s  %22s  %10d %10d %10d %10d      |\n", (i + 1) + ".", weap.getName(), weap.getCost(), weap.getLevel(), weap.getDamageValue(), weap.getNumberOfHandsRequried());

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void displayHeroesArmour(Heroes hero) {
        Armour armour;
        System.out.format("|%5s  %22s  %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage");

        for (int i = 0; i < (hero.getArmour()).size(); i++) {
            armour = (Armour) hero.getArmour().get(i);
            System.out.println("|---------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %10d      |\n", (i + 1) + ".", armour.getName(), armour.getCost(), armour.getLevel(), armour.getDamageReduction());

        }
    }

    public static void displayHeroesPotions(Heroes hero) {
        Potions potions;
        System.out.format("|%5s  %22s  %10s %10s %15s %15s   |\n", "No.", "Name", "cost", "level", "attributeIncrease", "atrributeAffected");

        for (int i = 0; i < (hero.getPotions().size()); i++) {
            potions = (Potions) hero.getPotions().get(i);
            System.out.println("|-----------------------------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %15d %15s      |\n", (i + 1) + ".", potions.getName(), potions.getCost(), potions.getLevel(), potions.getEffectAmount(), potions.getTypeOfPotion());

        }
    }

    public static void displayHeroesSpells(Heroes hero) {
        Spells spells;
        System.out.format("|%5s  %22s  %10s %10s %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage", "mana_cost", "type");

        for (int i = 0; i < (hero.getSpells().size()); i++) {
            spells = (Spells) hero.getSpells().get(i);
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %10d %10d %10s      |\n", (i + 1) + ".", spells.getName(), spells.getCost(), spells.getLevel(), spells.getDamageValue(), spells.getManaCost(), spells.getSpellType());

        }
    }

    public static boolean drinkPotion(Teams hero) {
        Heroes her = (Heroes) hero.getCharacter(getChosenHero());

        try {
            if (her.getPotions().size() > 0) {
                System.out.print("Below are the potions which the hero has, please select one among them to drink potion : ");
                displayHeroesPotions(her);
                System.out.print("Input : ");
                int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

                if (input >= her.getPotions().size()) {
                    throw new Exception("Invalid entry!");
                }

                switch (((Potions)(her.getPotions().get(input))).getTypeOfPotion()) {
                    case "Health":
                        her.setCurrentHP(her.getCurrentHP() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's Health Power increased to :" + her.getCurrentHP() + " using " + her.getPotions().get(input).getName());
                        break;
                    case "Strength":
                        her.setStrengthValue(her.getStrengthValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's strength increased to :" + her.getStrengthValue() + " using " + her.getPotions().get(input).getName());
                        break;
                    case "Mana":
                        her.setCurrentMP(her.getCurrentMP() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's Mana increased to :" + her.getCurrentMP() + " using " + her.getPotions().get(input).getName());
                        break;
                    case "Agility":
                        her.setAgilityValue(her.getAgilityValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's Agility increased to :" + her.getAgilityValue() + " using " + her.getPotions().get(input).getName());
                        break;
                    case "Dexterity":
                        her.setDexterityValue(her.getDexterityValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's Dexterity increased to :" + her.getDexterityValue() + " using " + her.getPotions().get(input).getName());
                        break;
                    default:
                        her.setDexterityValue(her.getDexterityValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        her.setAgilityValue(her.getAgilityValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        her.setCurrentHP(her.getCurrentHP() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        her.setStrengthValue(her.getStrengthValue() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        her.setCurrentMP(her.getCurrentMP() + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                        System.out.println("Hero : " + her.getNameOfObject() + "\nHero's all attributes increased by " + ((Potions)(her.getPotions().get(input))).getEffectAmount());
                }

                her.getPotions().remove(input);
                return true;
            }
            else {
                System.out.println("No potions to use!! Please buy more potions from the market!!");
                return false;
            }
        } catch (Exception error) {
            System.out.println("Error Encountered : " + error.getMessage());
            return false;
        }
    }

    public static boolean castSpell(Teams hero, Teams monster) {
        Heroes her = (Heroes) hero.getCharacter(getChosenHero());
        Monsters mon = (Monsters) monster.getCharacter(getChosenMonster());

        try {
            if (her.getSpells().size() > 0) {
                System.out.print("Below are the spells which the hero has, please select one among them to drink potion : ");
                displayHeroesSpells(her);
                System.out.print("Input : ");
                int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

                if (input >= her.getSpells().size()) {
                    throw new Exception("Invalid entry!");
                }

                if (((Spells)(her.getSpells().get(input))).getManaCost() > her.getCurrentMP()) {
                    throw new Exception("The hero does not have enough mana to cast spell");
                }

                her.setMaximumMP(her.getMaximumMP() - ((Spells)(her.getSpells().get(input))).getManaCost());

                switch (((Spells)(her.getSpells().get(input))).getSpellType()) {
                    case "ice":
                        mon.setBaseDamage(mon.getBaseDamage() - ((Spells)(her.getSpells().get(input))).getDamageValue());
                        System.out.println("Monster: " + mon.getNameOfObject() + "\nHero: " + her.getNameOfObject() + "\nMonster's base damage value: " + mon.getBaseDamage());
                        break;
                    case "fire":
                        mon.setDefenseValue(mon.getDefenseValue() - ((Spells)(her.getSpells().get(input))).getDamageValue());
                        System.out.println("Monster: " + mon.getNameOfObject() + "\nHero: " + her.getNameOfObject() + "\nMonster's defense value: " + mon.getDefenseValue());
                        break;
                    case "lightning":
                        mon.setDodgeValue(mon.getDodgeValue() - ((Spells)(her.getSpells().get(input))).getDamageValue());
                        System.out.println("Monster: " + mon.getNameOfObject() + "\nHero: " + her.getNameOfObject() + "\nMonster's dodge value: " + mon.getDodgeValue());
                        break;
                }
                her.getSpells().remove(input);
                return true;
            } else {
                System.out.println("No spells to use!! Please buy more spells from the market!!");
                return false;
            }

        } catch (Exception error) {
            System.out.println("Error Encountered : " + error.getMessage());
            return false;
        }
    }

    public static boolean holdWearItem(Teams hero, String item) {
        Heroes her = (Heroes) hero.getCharacter(getChosenHero());
        Collectible collectible;
        int input;

        try {
            switch (item.toLowerCase()) {
                case "weapon":
                    if (her.getWeapons().size() == 0) {
                        throw new Exception("The hero does not have any weapons in the inventory, please buy some more!");
                    }
                    System.out.println("Below are the weapons which the hero has : ");
                    displayHeroesWeapons(her);
                    System.out.print("Please choose a weapon num which you would like to equip the hero with : ");
                    input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

                    if (input >= her.getWeapons().size()) {
                        throw new Exception("Invalid entry!");
                    }

                    if (her.getEquippedWeapon() != null) {
                        collectible = her.getEquippedWeapon();
                        her.getWeapons().add(collectible);
                    }
                    collectible = her.getWeapons().get(input);
                    her.setEquippedWeapon(collectible);
                    System.out.println("Hero: " + her.getNameOfObject() + "\nEquipped Weapon : " + collectible.getName());
                    return true;
                case "armour" :
                    if (her.getArmour().size() == 0) {
                        throw new Exception("The hero does not have any armours in the inventory, please buy some more!");
                    }
                    System.out.println("Below are the armours which the hero has : ");
                    displayHeroesArmour(her);
                    System.out.print("Please choose a armour num which you would like to equip the hero with : ");
                    input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

                    if (input >= her.getWeapons().size()) {
                        throw new Exception("Invalid entry!");
                    }

                    if (her.getEquippedArmour() != null) {
                        collectible = her.getEquippedArmour();
                        her.getArmour().add(collectible);
                    }
                    collectible = her.getArmour().get(input);
                    her.setEquippedWeapon(collectible);
                    System.out.println("Hero: " + her.getNameOfObject() + "\nEquipped Armour : " + collectible.getName());
                    return true;
                default:
                    throw new IllegalStateException("Invalid item type");
            }

        } catch (Exception error) {
            System.out.println("Error Encountered : " + error.getMessage());
            return false;
        }
    }

    public static String WinnerWinnerChickenDinner(Teams hero, Teams monster){
         int flag = 0;
         for (int i = 0 ; i < hero.getSizeOfTeam(); i++) {
             if (((Heroes) (hero.getListOfCharacters().get(i))).isFaint()) {
                 flag++;
             }
         }
        if(flag == hero.getSizeOfTeam()){
            System.out.println("Monsters has won the Game ");
            return "Monsters";
        }
        else if(monster.getListOfCharacters().size() == 0){
             System.out.println("Heroes has won the game versus the monsters team of Voldemort");
             return "Heroes";
        }
        return "None";
    }

    public static void heroLevelCheck(Heroes hero) {
        if (hero.getExperience() > (hero.getCharacterLevel() * 12)) {
            hero.setMaximumMP((int)Math.floor(hero.getMaximumMP() * 1.1));
            hero.setCurrentMP(hero.getMaximumMP());
            hero.setExperience(0);
            hero.setAgilityValue((int)Math.floor(hero.getAgilityValue() * 1.05));
            hero.setDexterityValue((int)Math.floor(hero.getDexterityValue() * 1.05));
            hero.setMaximumHP((int)Math.floor(hero.getMaximumHP() * 1.1));
            hero.setCurrentHP(hero.getMaximumHP());
            hero.setStrengthValue((int)Math.floor(hero.getStrengthValue() * 1.05));
            hero.setCharacterLevel(hero.getCharacterLevel() + 1);
        }
    }

    public static void heroWinProcess(Teams hero) {
        for (Character her: hero.getListOfCharacters()) {
            if (((Heroes) her).isFaint()) {
                ((Heroes) her).setFaint(false);
                ((Heroes) her).setCurrentMP(((Heroes) her).getMaximumMP() / 2);
                her.setCurrentHP(her.getCurrentHP() / 2);
            } else {
                her.setCurrentHP(her.getCurrentHP());
                ((Heroes) her).setCurrentMP(((Heroes) her).getMaximumMP());
                ((Heroes) her).setExperience((hero.getSizeOfTeam() * 2) + ((Heroes) her).getExperience());
                ((Heroes) her).setGold((hero.getSizeOfTeam() * 286) + ((Heroes) her).getGold());
                heroLevelCheck(((Heroes) her));
            }
        }
    }
}

