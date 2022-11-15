/**
 * Marketplace Class has features to run the whole Market for the hero to buy items from.
 * * Author : Harshitha T K
 * Date   : Nov 7
 */
import java.io.IOException;

public class MarketPlace {

    private static int selectedHero;

    public static void startMarket() throws IOException {
        System.out.println(" Welcome to the Hogwarts Market. ");
        for(;;) {
            BattleCommons.displayTeam("Heroes");
            System.out.println("Choose the Hero to whom you want to buy the equipments");
            selectedHero = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

            if (selectedHero <= -1 || selectedHero >= HeroesAndMonsters.getHeroTeam().getSizeOfTeam()) {
                throw new IllegalStateException("Invalid input for the hero, Kindly select a valid one");
            }

            System.out.println("The Hogwarts Market has the below options to choose for the Heroes Inventory");
            System.out.println("1. Weapons\n 2. Armour\n 3. Potions\n 4. Spells\n");
            int option = Integer.parseInt(CommonUtilities.input.readLine());


            switch (option) {

                case 1:
                    System.out.println("Please choose the weapon that you want to buy from the below weapon list");
                    displayWeapons();
                    chooseWeapon((Heroes) HeroesAndMonsters.getHeroTeam().getCharacter(selectedHero));
                    break;

                case 2:
                    System.out.println("Please choose the weapon that you want to buy from the below Armour list");
                    displayArmour();
                    chooseArmour((Heroes) HeroesAndMonsters.getHeroTeam().getCharacter(selectedHero));
                    break;

                case 3:
                    System.out.println("Please choose the weapon that you want to buy from the below potion list");
                    displayPotions();
                    choosePotion((Heroes) HeroesAndMonsters.getHeroTeam().getCharacter(selectedHero));
                    break;

                case 4:
                    System.out.println("Please choose the weapon that you want to buy from the below Spells list");
                    displaySpells();
                    chooseSpell((Heroes) HeroesAndMonsters.getHeroTeam().getCharacter(selectedHero));
                    break;
            }
            System.out.print("Press 1 to continue and any other number quit the market: ");
            if (!CommonUtilities.input.readLine().equals("1")) {
                break;
            }
        }


    }

    public static void chooseWeapon(Heroes hero) throws IOException {
        System.out.print("Please select a weapon that you that you know how to use: ");
        int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

        if (input < 0 || input > CommonUtilities.weaponsList.size() - 1) {
            System.out.println("The number is invalid, Please try again");
        }

        if (CommonUtilities.weaponsList.get(input).getCost() > hero.getGold()) {
            System.out.println("The gold you have is insufficient at this moment to buy this item, try again later");
            return;
        }

        hero.setGold(hero.getGold() - CommonUtilities.weaponsList.get(input).getCost());
        Weapon weapon = (Weapon) CommonUtilities.weaponsList.get(input);
        hero.getWeapons().add(new Weapon(weapon.getName(), weapon.getCost(), weapon.getLevel(), weapon.getDamageValue(), weapon.getNumberOfHandsRequried()));
    }

    public static void chooseArmour(Heroes hero) throws IOException {
        System.out.print("Please select an armour to guard yourself: ");
        int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

        if (input < 0 || input > CommonUtilities.armourList.size() - 1) {
            System.out.println("The number is invalid, Please try again");
        }

        if (CommonUtilities.armourList.get(input).getCost() > hero.getGold()) {
            System.out.println("The gold you have is insufficient at this moment to buy this item, try again later");
            return;
        }

        hero.setGold(hero.getGold() - CommonUtilities.armourList.get(input).getCost());
        Armour armour = (Armour) CommonUtilities.armourList.get(input);
        hero.getArmour().add(new Armour(armour.getName(), armour.getCost(), armour.getLevel(), armour.getDamageReduction()));
    }

    public static void choosePotion(Heroes hero) throws IOException {
        System.out.print("Please select a potion to use your magic powers : ");
        int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

        if (input < 0 || input > CommonUtilities.potionsList.size() - 1) {
            System.out.println("The number is invalid, Please try again");
        }

        if (CommonUtilities.potionsList.get(input).getCost() > hero.getGold()) {
            System.out.println("The gold you have is insufficient at this moment to buy this item, try again later");
            return;
        }

        hero.setGold(hero.getGold() - CommonUtilities.potionsList.get(input).getCost());
        Potions potion = (Potions) CommonUtilities.potionsList.get(input);
        hero.getPotions().add(new Potions(potion.getName(), potion.getCost(), potion.getLevel(), potion.getEffectAmount(), potion.getTypeOfPotion()));
    }

    public static void chooseSpell(Heroes hero) throws IOException {
        System.out.print("Please select a spell that excited you while it was taught in magic school : ");
        int input = Integer.parseInt(CommonUtilities.input.readLine()) - 1;

        if (input < 0 || input > CommonUtilities.spellsList.size() - 1) {
            System.out.println("The number is invalid, Please try again");
        }

        if (CommonUtilities.spellsList.get(input).getCost() > hero.getGold()) {
            System.out.println("The gold you have is insufficient at this moment to buy this item, try again later");
            return;
        }

        hero.setGold(hero.getGold() - CommonUtilities.spellsList.get(input).getCost());
        Spells spell = (Spells) CommonUtilities.spellsList.get(input);
        hero.getSpells().add(new Spells(spell.getName(), spell.getCost(), spell.getLevel(), spell.getDamageValue(), spell.getManaCost(), spell.getSpellType()));
    }

    public static void displayWeapons() {

        Weapon weap;
        try {
            System.out.format("|%5s  %22s  %10s %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage", "RequiredHands");

            for (int i = 0; i < (CommonUtilities.weaponsList.size()); i++) {
                weap = (Weapon) CommonUtilities.weaponsList.get(i);
                System.out.println("|--------------------------------------------------------------------------------|");
                System.out.format("|%5s  %22s  %10d %10d %10d %10d      |\n", (i + 1) + ".", weap.getName(), weap.getCost(), weap.getLevel(), weap.getDamageValue(), weap.getNumberOfHandsRequried());

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public static void displayArmour() {

        Armour armour;
        System.out.format("|%5s  %22s  %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage");

        for (int i = 0; i < (CommonUtilities.armourList.size()); i++) {
            armour = (Armour) CommonUtilities.armourList.get(i);
            System.out.println("|---------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %10d      |\n", (i + 1) + ".", armour.getName(), armour.getCost(), armour.getLevel(), armour.getDamageReduction());

        }
    }

    public static void displayPotions() {
        Potions potions;
        System.out.format("|%5s  %22s  %10s %10s %15s %15s   |\n", "No.", "Name", "cost", "level", "attributeIncrease", "atrributeAffected");

        for (int i = 0; i < (CommonUtilities.potionsList.size()); i++) {
            potions = (Potions) CommonUtilities.potionsList.get(i);
            System.out.println("|-----------------------------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %15d %15s      |\n", (i + 1) + ".", potions.getName(), potions.getCost(), potions.getLevel(), potions.getEffectAmount(), potions.getTypeOfPotion());

        }
    }

    public static void displaySpells() {
        Spells spells;
        System.out.format("|%5s  %22s  %10s %10s %10s %10s   |\n", "No.", "Name", "cost", "level", "damage", "mana_cost", "type");

        for (int i = 0; i < (CommonUtilities.spellsList.size()); i++) {
            spells = (Spells) CommonUtilities.spellsList.get(i);
            System.out.println("|--------------------------------------------------------------------------------|");
            System.out.format("|%5s  %22s  %10d %10d %10d %10d      |\n", (i + 1) + ".", spells.getName(), spells.getCost(), spells.getLevel(), spells.getDamageValue(), spells.getManaCost(), spells.getSpellType());

        }
    }

    public static void main(String[] args) throws IOException {
        CommonUtilities.characterPool();
        CommonUtilities.itemPool();
        HeroesAndMonsters.setHeroTeam(new Teams());
        HeroesAndMonsters.getHeroTeam().setSizeOfTeam(3);

        HeroesAndMonsters.setMonsterTeam(new Teams());
        HeroesAndMonsters.createTeamHeroes(HeroesAndMonsters.getHeroTeam());
        startMarket();
       // BattleCommons.displayingHeroesWeapons(HeroesAndMonsters.getHeroTeam().getCharacter(1));
    }


}
