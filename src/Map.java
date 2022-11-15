/**
 * This class consists of the scalable board function for creation of any Board. class holds constructor methods and getters and setters for the dimension of the layout of any game
 * Name : Harshitha
 * date : 2 Nov
 */

public abstract class Map {

    protected SingleBlocks[][] arrayofBoardDimension;
    protected Integer length;
    protected Integer breadth;
    private String boardColor;

    public void setBoardColor(String boardColor) {
        this.boardColor = boardColor;
    }
    public abstract void createMap();
    public abstract void displayMap();



    public SingleBlocks[][] getMap(){
        return arrayofBoardDimension;
    }
    Map(Integer dimensionLength, Integer dimensionBreadth, String boardColor){
        this.setBreadth(dimensionBreadth);
        this.setLength(dimensionLength);
        this.setBoardColor(boardColor);
    }
    Map(Integer mapSize, String boardColor){
        this.setLength(mapSize);
        this.setBreadth(mapSize);
        this.setBoardColor(boardColor);
    }

    public String getBoardColor(){ return this.boardColor; }
    public Integer getLength(){ return this.length; }
    public Integer getBreadth(){ return this.breadth; }

    public void setLength(Integer length) throws IllegalStateException {
        if (length <= 0) throw new IllegalStateException();

        this.length = length;
    }

    public void setBreadth(Integer breadth) throws IllegalStateException {
        if (breadth <= 0) throw new IllegalStateException();

        this.breadth = breadth;
    }




}
