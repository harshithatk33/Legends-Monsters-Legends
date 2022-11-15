/**
 * This is the Driver class for the whole application, where the interface of the game is written for the game users to follow.
 * Author : Harshitha T K
 * Date   : Nov 1
 */

import java.io.IOException;

public class HeroesAndMonsters {
    private static Teams heroTeam;
    private static Teams monsterTeam;

    public static Teams getHeroTeam() {
        return heroTeam;
    }

    public static void setHeroTeam(Teams heroTeam) {
        HeroesAndMonsters.heroTeam = heroTeam;
    }

    public static Teams getMonsterTeam() {
        return monsterTeam;
    }

    public static void setMonsterTeam(Teams monsterTeam) {
        HeroesAndMonsters.monsterTeam = monsterTeam;
    }

    public static void displayMonsters() {
        for (int i = 0; i < monsterTeam.getSizeOfTeam(); i++) {
            System.out.println(monsterTeam.getCharacter(i));
        }
    }

    public static void createTeamHeroes(Teams heroTeam) throws IOException {

        String input;
        heroTeam.initListOfCharacters();

        for (int j = 0; j < heroTeam.getSizeOfTeam(); ) {
            System.out.println("Welcome to the school of heroes:\n There are three types of heroes. \n1. Paladins\n2. Warriors\n3. Sorcerers");
            System.out.println("Please enter the number: ");
            try {
                switch (Integer.parseInt(CommonUtilities.input.readLine())) {
                    case 1:
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.println("Please choose from the below list of paladins\n ");
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.format("|%5s  %22s  %10s %10s %10s %10s %10s %10s %10s    |\n", "No.", "Name", "mana", "strength", "agility", "dexterity", "gold", "experience", "HP");
                        for (int i = 1; i < (CommonUtilities.paladinsList.size()); i++) {
                            System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                            System.out.format("|%5s  %22s  %10d %10d %10d %10d %10d %10d %10d     |\n", i + ".", CommonUtilities.paladinsList.get(i).getNameOfObject(), ((Heroes) CommonUtilities.paladinsList.get(i)).getMaximumMP(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getStrengthValue(), ((Heroes) CommonUtilities.paladinsList.get(i)).getAgilityValue(), ((Heroes) CommonUtilities.paladinsList.get(i)).getDexterityValue(), ((Heroes) CommonUtilities.paladinsList.get(i)).getGold(), ((Heroes) CommonUtilities.paladinsList.get(i)).getExperience(), ((Heroes) CommonUtilities.paladinsList.get(i)).getCurrentHP());
                        }
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.print("Please type the number of the hero you would like to choose : ");
                        input = CommonUtilities.input.readLine();
                        heroTeam.addCharacter(CommonUtilities.paladinsList.get(Integer.parseInt(input)));
                        CommonUtilities.paladinsList.remove(Integer.parseInt(input));

                        j++;
                        break;

                    case 2:
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.println("Please choose from the below list of Warriors\n ");
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.format("\"|%5s  %22s  %10s %10s %10s %10s %10s %10s %10s     |\n", "No.", "Name", "mana", "strength", "agility", "dexterity", "gold", "experience", "HP");
                        for (int i = 1; i < (CommonUtilities.warriorsList.size()); i++) {
                            System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                            System.out.format("|%5s  %22s  %10d %10d %10d %10d %10d %10d %10d     |\n", i + ".", CommonUtilities.warriorsList.get(i).getNameOfObject(), ((Heroes) CommonUtilities.warriorsList.get(i)).getMaximumMP(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getStrengthValue(), ((Heroes) CommonUtilities.warriorsList.get(i)).getAgilityValue(), ((Heroes) CommonUtilities.warriorsList.get(i)).getDexterityValue(), ((Heroes) CommonUtilities.warriorsList.get(i)).getGold(), ((Heroes) CommonUtilities.warriorsList.get(i)).getExperience(), ((Heroes) CommonUtilities.warriorsList.get(i)).getCurrentHP());

                        }
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.print("Please type the number of the hero you would like to choose : ");
                        input = CommonUtilities.input.readLine();
                        heroTeam.addCharacter(CommonUtilities.warriorsList.get(Integer.parseInt(input)));
                        CommonUtilities.warriorsList.remove(Integer.parseInt(input));
                        j++;
                        break;

                    case 3:
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.println("Please choose from the below list of Sorcerers\n ");
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.format("|%5s  %22s  %10s %10s %10s %10s %10s %10s %10s     |\n", "No.", "Name", "mana", "strength", "agility", "dexterity", "gold", "experience", "HP");
                        for (int i = 1; i < (CommonUtilities.sorcerersList.size()); i++) {
                            System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                            System.out.format("|%5s  %22s  %10d %10d %10d %10d %10d %10d %10d     |\n", i + ".", CommonUtilities.sorcerersList.get(i).getNameOfObject(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getMaximumMP(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getStrengthValue(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getAgilityValue(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getDexterityValue(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getGold(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getExperience(), ((Heroes) CommonUtilities.sorcerersList.get(i)).getCurrentHP());

                        }
                        System.out.println("|----------------------------------------------------------------------------------------------------------------|");
                        System.out.print("Please type the number of the hero you would like to choose : ");
                        input = CommonUtilities.input.readLine();
                        heroTeam.addCharacter(CommonUtilities.sorcerersList.get(Integer.parseInt(input)));
                        CommonUtilities.sorcerersList.remove(Integer.parseInt(input));
                        j++;
                        break;
                }
            } catch (Exception error) {
                System.out.println("Invalid Input, Please try again!!");
            }
        }


    }

    public static void createTeamMonsters(Teams monsterTeam, Teams heroTeam) throws IOException {
        int maxLevel = 0;
        Character monster;

        monsterTeam.setSizeOfTeam(heroTeam.getSizeOfTeam());
        monsterTeam.initListOfCharacters();

        for (Character ch : heroTeam.getListOfCharacters()) {
            if (((Heroes) ch).getCharacterLevel() > maxLevel) {
                maxLevel = ((Heroes) ch).getCharacterLevel();
            }
        }

        for (int j = 0; j < heroTeam.getSizeOfTeam(); ) {
            monster = CommonUtilities.monsterList.get(CommonUtilities.generateRandomNumber(CommonUtilities.monsterList.size()));
            if (((Monsters) monster).getCharacterLevel() <= maxLevel) {
                monsterTeam.addCharacter(monster);
                j++;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        System.out.println("______________________________________________________________________________________________________________");

//
//        try {
//            GraphicsEnvironment ge =
//                    GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/Users/htk/personal/Assignments2022/CS611Java/assignments/BlackJack/HerosAndMonsters/src/Fonts.harry-potter-font/HARRYP.TTF")));
//        } catch (IOException|FontFormatException e) {
//            //Handle exception
//        }

        do {
            try {
                System.out.println("        **              ***********         ****       ***********      **         **       **** **                 ");
                System.out.println("        **              **                **           **               ****       **       **     **              ");
                System.out.println("        **              **               **            **               **  **     **       **      **         ");
                System.out.println("        **              ***********      **            ***********      **    **   **       **       **        ");
                System.out.println("        **              **               **     **     **               **      ** **       **       **      ");
                System.out.println("        **              **                **     **    **               **       ****       **      **       ");
                System.out.println("        ************    ************        *****      ************     **         **       ****  **          ");
                System.out.println("______________________________________________________________________________________________________________");

                System.out.println(AsciiColors.YELLOW + " *******************************************************WELCOME TO LEGENDS GAME***************************************************************************************** " + AsciiColors.RESET);
                System.out.println(AsciiColors.GREEN + " +\"\"\"\"\"+          Heros and Monsters game. Heros and Monsters are two kinds of characters in the game" + AsciiColors.RESET);
                System.out.println("[| o o |]          This Layout Map will have the number of Heros selected by you in one part of the board");
                System.out.println(" |  ^  |           There will three kinds of spaces in this game, the common space would lead the hero/heros to have a battle with monsters");
                System.out.println(" | '-' |           The winner of the game is decided based on the faints of heros OR killed monsters");
                System.out.println(" +-----+ ");
                try {
                    CommonUtilities.start("Harry_Potter_Theme_Song_Hedwigs_Theme.wav");
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(AsciiColors.BLUE + " +\"\"\"\"\"+               EXCITED TO PLAY, GAME STARTS IN 3.......2.......1......" + AsciiColors.RESET);
                System.out.println("[| * * |]");
                System.out.println(" |  ^  | ");
                System.out.println(" | 'O' | ");
                System.out.println(" +-----+ ");

                System.out.println(AsciiColors.YELLOW + "************************************************************************************************************************************************************************" + AsciiColors.RESET);


                CommonUtilities.characterPool();
                CommonUtilities.itemPool();

                GameMap game = new GameMap(8, AsciiColors.BLUE);

                for (; ; ) {
                    game.createMap();
                    game.inaccesible(20);
                    game.marketplace(30);
                    game.displayMap();

                    System.out.println("Would you like to generate the map again? (Y/N)");
                    if (CommonUtilities.input.readLine().equalsIgnoreCase("N")) {
                        break;
                    }
                }

                System.out.println("How many heroes would you like to be in your team? (1/2/3) - ");
                HeroesAndMonsters.setHeroTeam(new Teams());
                HeroesAndMonsters.getHeroTeam().setSizeOfTeam(Integer.parseInt(CommonUtilities.input.readLine()));

                System.out.println("Let us select the heroes for your team : ");
                createTeamHeroes(HeroesAndMonsters.getHeroTeam());

                game.getMap()[0][0].placeTeam(HeroesAndMonsters.getHeroTeam());

                game.displayMap();

                System.out.println("\n\n Let us play!!");
                int i = 0, j = 0;
                String move;

                do {
                    System.out.print("Please select a move to be played: (a-move left, w-move up, s-move down, d-move right, q-quit game) : ");
                    move = CommonUtilities.input.readLine();
                    try {
                        switch (move.toLowerCase()) {
                            case "w":
                                if ((i - 1) < 0) {
                                    throw new Exception("Wrong/Invalid Move!!");
                                }
                                if (((LegendBlock) game.getMap()[i - 1][j]).getBlockType() == BlockTypes.INACCESSIBLE) {
                                    System.out.println("Sorry!! This space is not accessible");
                                } else {
                                    game.getMap()[i][j].removeTeam();
                                    i -= 1;
                                    game.getMap()[i][j].placeTeam(HeroesAndMonsters.getHeroTeam());
                                    game.displayMap();
                                    if(((LegendBlock) game.getMap()[i][j]).getBlockType() == BlockTypes.MARKETPLACE){
                                        System.out.println("MarketPlace is here buy market, enter? (y/n)");
                                        if((CommonUtilities.input.readLine()).equalsIgnoreCase("Y")) {
                                            MarketPlace.startMarket();
                                        }

                                    } else {
                                        Battle.battleDriver();
                                    }
                                }
                                break;
                            case "s":
                                if ((i + 1) > 7) {
                                    throw new Exception("Wrong/Invalid Move!!");
                                }
                                if (((LegendBlock) game.getMap()[i + 1][j]).getBlockType() == BlockTypes.INACCESSIBLE) {
                                    System.out.println("Sorry!! This space is not accessible!");
                                } else {
                                    game.getMap()[i][j].removeTeam();
                                    i += 1;
                                    game.getMap()[i][j].placeTeam(HeroesAndMonsters.getHeroTeam());
                                    game.displayMap();
                                    if(((LegendBlock) game.getMap()[i][j]).getBlockType() == BlockTypes.MARKETPLACE){
                                        System.out.println("MarketPlace is here buy market, enter? (y/n)");
                                        if((CommonUtilities.input.readLine()).equalsIgnoreCase("Y")) {
                                            MarketPlace.startMarket();
                                        }

                                    } else {
                                        Battle.battleDriver();
                                    }
                                }
                                break;
                            case "a":
                                if ((j - 1) < 0) {
                                    throw new Exception("Wrong/Invalid Move!!");
                                }
                                if (((LegendBlock) game.getMap()[i][j - 1]).getBlockType() == BlockTypes.INACCESSIBLE) {
                                    System.out.println("Sorry!! This space is not accessible");
                                } else {
                                    game.getMap()[i][j].removeTeam();
                                    j -= 1;
                                    game.getMap()[i][j].placeTeam(HeroesAndMonsters.getHeroTeam());
                                    game.displayMap();
                                    if(((LegendBlock) game.getMap()[i][j]).getBlockType() == BlockTypes.MARKETPLACE){
                                        System.out.println("MarketPlace is here buy market, enter? (y/n)");
                                        if((CommonUtilities.input.readLine()).equalsIgnoreCase("Y")) {
                                            MarketPlace.startMarket();
                                        }

                                    } else {
                                        Battle.battleDriver();
                                    }
                                }
                                break;
                            case "d":
                                if ((j + 1) > 7) {
                                    throw new Exception("Wrong/Invalid Move!!");
                                }
                                if (((LegendBlock) game.getMap()[i][j + 1]).getBlockType() == BlockTypes.INACCESSIBLE) {
                                    System.out.println("Sorry!! This space is not accessible");
                                } else {
                                    game.getMap()[i][j].removeTeam();
                                    j += 1;
                                    game.getMap()[i][j].placeTeam(HeroesAndMonsters.getHeroTeam());
                                    game.displayMap();
                                    if(((LegendBlock) game.getMap()[i][j]).getBlockType() == BlockTypes.MARKETPLACE){
                                        System.out.println("MarketPlace is here buy market, enter? (y/n)");
                                        if((CommonUtilities.input.readLine()).equalsIgnoreCase("Y")) {
                                            MarketPlace.startMarket();
                                        }

                                    } else {
                                        Battle.battleDriver();
                                    }
                                }
                                break;
                            case "q":
                                break;
                            default:
                                throw new Exception("This input is not allowed");
                        }
                    } catch (Exception error) {
                        System.out.println("This input is not allowed - Invalid Move");
                    }
                } while (!move.equalsIgnoreCase("q"));

//        HeroesAndMonsters.setMonsterTeam(new Teams());
//        HeroesAndMonsters.createTeamHeroes(HeroesAndMonsters.getHeroTeam());
//        battleDriver();
//        Teams t = new Teams();
//        t.setSizeOfTeam(3);
//        createTeamHeroes(t);
//
//        t.getCharacter(1).setCharacterLevel(3);
//        Teams m = new Teams();
//
//        createTeamMonsters(m, t);
            } catch (Exception error) {
                System.out.println("Internal Server Error!! " + error.getMessage());
            }
            System.out.println("Would you like to play again? (Y/N)");
        } while (CommonUtilities.input.readLine().equalsIgnoreCase("Y"));
    }
}
