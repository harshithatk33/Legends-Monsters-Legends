/**
The Single Blocks Class will hold the game plots each piece - block. This may be further used to create the whole Map structure
Author : Harshitha T K
Date   : Nov 1
 */
public class SingleBlocks {

    private Integer positionOfObject;
    private Integer objA; //index/position of the unit
    private Integer objB; //index/position of the unit
    private Teams team;


    SingleBlocks(Integer positionOfObject, Integer objA, Integer objB){
        this.setPositionOfObject(positionOfObject);
        this.setObjA(objA);
        this.setObjB(objB);
    }

    public void setPositionOfObject(Integer blockIndex) throws IllegalStateException{
        if (blockIndex < 0) throw new IllegalStateException();

        this.positionOfObject = blockIndex;
    }

    public Integer getPositionOfObject(){
        return this.positionOfObject;
    }
//
//    public String getBlockColors(){
//        return this.blockColors;
//
//        //do different colors for M block and inaccesible blocks
//    }

    public void placeTeam(Teams team){ this.team = team; }

    public void removeTeam(){
        this.team = null;
    }

    public boolean teamPresent() {
        return this.team != null;
    }

    public void setObjA(Integer objA) throws IllegalStateException{
        if(objA < 0) throw new IllegalStateException();

        this.objA = objA;
    }

    public Integer getObjA(){ return this.objA; }

    public Integer getObjB(){ return this.objB; }

    public void setObjB(Integer objB) throws IllegalStateException{
        if(objA < 0) throw new IllegalStateException();

        this.objB = objB;
    }

}
