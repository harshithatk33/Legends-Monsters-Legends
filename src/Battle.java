import java.io.IOException;
import java.util.HashMap;

public class Battle {

    public static String battleDriver() throws IOException {

        System.out.println("You have stepped in for a battle\n Choose a hero to run in this battle");

        HeroesAndMonsters.setMonsterTeam(new Teams());
        HeroesAndMonsters.createTeamMonsters(HeroesAndMonsters.getMonsterTeam(), HeroesAndMonsters.getHeroTeam());
        BattleCommons.displayTeam("monsters");


        BattleCommons.chooseHero();
        BattleCommons.chooseMonster();
        String statusOfBattle;
        boolean monsterAttack;

        while (true) {
            try {
                monsterAttack = false;
                System.out.println("Please type any one of the below options for your turn in battle: \nA - Attack the monster\nEW - Equip Weapon\nEA - Equip Armour\nP - Drink Potion\nS - Cast Spell\nI - Current Hero and monster stats (you wont loose your turn here)");
                System.out.print("Input : ");

                switch ((CommonUtilities.input.readLine()).toUpperCase()) {
                    case "A":
                        BattleCommons.heroAttack(HeroesAndMonsters.getHeroTeam(), HeroesAndMonsters.getMonsterTeam());
                        System.out.println("Now the monster is gearing up for an attack!!");
                        monsterAttack = true;
                        break;
                    case "EW":
                        if(BattleCommons.holdWearItem(HeroesAndMonsters.getHeroTeam(), "Weapon")) {
                            monsterAttack = true;
                        }
                        break;
                    case "EA":
                        if(BattleCommons.holdWearItem(HeroesAndMonsters.getHeroTeam(), "Armour")) {
                            monsterAttack = true;
                        }
                        break;
                    case "P":
                        if (BattleCommons.drinkPotion(HeroesAndMonsters.getHeroTeam())) {
                            monsterAttack = true;
                        }
                    case "S":
                        if (BattleCommons.castSpell(HeroesAndMonsters.getHeroTeam(), HeroesAndMonsters.getMonsterTeam())) {
                            monsterAttack = true;
                        }
                        break;
                    case "I":
                        System.out.println("\nHero Stats: \n");
                        BattleCommons.displayTeam("heroes");
                        System.out.println("\nMonster Stats: \n");
                        BattleCommons.displayTeam("monsters");
                        break;
                    default:
                        System.out.println("Invalid choice!! PLease choose among the given options!");
                }
                statusOfBattle = BattleCommons.WinnerWinnerChickenDinner(HeroesAndMonsters.getHeroTeam(), HeroesAndMonsters.getMonsterTeam());
                if (!statusOfBattle.equalsIgnoreCase("None")) {
                    break;
                }
                if (monsterAttack) {
                    BattleCommons.monsterAttack(HeroesAndMonsters.getHeroTeam(), HeroesAndMonsters.getMonsterTeam());
                    System.out.println();
                }
                statusOfBattle = BattleCommons.WinnerWinnerChickenDinner(HeroesAndMonsters.getHeroTeam(), HeroesAndMonsters.getMonsterTeam());
                if (!statusOfBattle.equalsIgnoreCase("None")) {
                    break;
                }
            } catch (Exception error) {
                System.out.println("Error in battle: " + error.getMessage());
            }
        }

        if (statusOfBattle.equalsIgnoreCase("Heroes")) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Congratulations!!!!! Heroes won the battle!!");

            BattleCommons.heroWinProcess(HeroesAndMonsters.getHeroTeam());
        } else {
            System.out.println("Damn!! That was a great battle, But all your heroes have fainted.");
        }

        return statusOfBattle;

    }

//    public static void main(String[] args) throws IOException {
//        CommonUtilities.characterPool();
//        CommonUtilities.itemPool();
//        HeroesAndMonsters.setHeroTeam(new Teams());
//        HeroesAndMonsters.getHeroTeam().setSizeOfTeam(3);
//
//        HeroesAndMonsters.setMonsterTeam(new Teams());
//        HeroesAndMonsters.createTeamHeroes(HeroesAndMonsters.getHeroTeam());
//        battleDriver();
//        // BattleCommons.displayingHeroesWeapons(HeroesAndMonsters.getHeroTeam().getCharacter(1));
//    }

}


