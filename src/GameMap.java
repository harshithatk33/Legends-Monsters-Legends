/**
 * This Class consists of entire play arena for the game of Legends (8X8) and the methods to have fixed spots on the Board.
 * Author : Harshitha T K
 *  Date   : Nov 1
 */
public class GameMap extends Map {



    GameMap(Integer length, String boardColor){
        super(length, boardColor);
    }

    GameMap(Integer length, Integer breadth, String boardColor){
        super(length,breadth, boardColor);
    }


    //creating the Legend Game Map function - > it creates the board according to the dimension provided by the player.
    public void createMap(){
        arrayofBoardDimension = new SingleBlocks[length][breadth];
        for (int indexI = 0; indexI < length; indexI++) {
            for (int indexJ = 0; indexJ < breadth; indexJ++) {
                arrayofBoardDimension[indexI][indexJ] = new LegendBlock((breadth * indexI) + 1 + indexJ, indexI, indexJ);
            }
        }
    }

    public void inaccesible(Integer percentageOfInaccesibleCells){
        Integer boardSize = length * breadth;
        Integer randomNumber = 0, indexI = 0, indexJ = 0;
        for (int count = 0; count < ((boardSize * percentageOfInaccesibleCells) / 100);) {
                randomNumber = (int)(Math.floor(Math.random() * (boardSize - 1)));
                if(randomNumber != 0) {
                    indexI = randomNumber / length;
                    indexJ = (int) Math.round(((randomNumber * 1.0 / length) - indexI) * length);
                    if (((LegendBlock) this.getMap()[indexI][indexJ]).getBlockType() == BlockTypes.COMMON) {
                        ((LegendBlock) this.getMap()[indexI][indexJ]).setBlockType(BlockTypes.INACCESSIBLE);
                        count ++;
                    }
                }
            }

    }

    public void marketplace(Integer precentageOfMarketPlace){
        Integer boardSize = length * breadth;
        Integer randomNumber = 0, indexI = 0, indexJ = 0;
        for (int count = 0; count < ((boardSize * precentageOfMarketPlace) / 100);) {
            randomNumber = (int)(Math.floor(Math.random() * (boardSize - 1)));
            if(randomNumber != 0) {
                indexI = randomNumber / length;
                indexJ = (int) Math.round(((randomNumber * 1.0 / length) - indexI) * length);
                if (((LegendBlock) this.getMap()[indexI][indexJ]).getBlockType() == BlockTypes.COMMON) {
                    ((LegendBlock) this.getMap()[indexI][indexJ]).setBlockType(BlockTypes.MARKETPLACE);
                    count ++;
                }
            }
        }
    }

    public void displayMap(){
        //arrayofBoardDimension = new LegendBlock[length][breadth];
        System.out.print(this.getBoardColor());
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                System.out.print("+----");
            }
            System.out.println("+ ");
            for (int j = 0; j < breadth; j++) {
                if (arrayofBoardDimension[i][j].teamPresent()) {
                    System.out.print(" | " + "" + AsciiColors.CYAN + "H" + this.getBoardColor() +" ");
                } else {
                    System.out.print(" | " + "" + BlockTypes.getColors(((LegendBlock) arrayofBoardDimension[i][j]).getBlockType()) + BlockTypes.getSymbols(((LegendBlock) arrayofBoardDimension[i][j]).getBlockType()) + this.getBoardColor() + " ");
                }
            }
            System.out.println(" | ");
        }
        for (int j = 0; j < breadth; j++) {
            System.out.print("+----");
        }
        System.out.println("+ " + AsciiColors.RESET);

        System.out.println("" + BlockTypes.getColors(BlockTypes.INACCESSIBLE) + BlockTypes.getSymbols(BlockTypes.INACCESSIBLE) + AsciiColors.RESET + " - Inaccessible spot where hero cannot move into!");
        System.out.println("" + BlockTypes.getColors(BlockTypes.MARKETPLACE) + BlockTypes.getSymbols(BlockTypes.MARKETPLACE) + AsciiColors.RESET + " - Marketplace where hero can buy weapons, armours, potions, spells");
        System.out.println("" + AsciiColors.CYAN + "H - Hero Team" + AsciiColors.RESET);
    }



}
