/**
 * Class consists of each object(player type) which would sit in the blocks
 * Author : Harshitha T K
 * Date   : Nov 1
 */
public class GamePiece extends Piece{


    private Integer levelOfObject;
    private Integer healthPowerOfObject;

    GamePiece(String nameOfObject, String colorOfObject, String typeOfObject){
        super(nameOfObject,colorOfObject,typeOfObject);
    }

    public Integer getLevelOfObject(){ return this.levelOfObject; }

    public void setLevelOfObject(Integer levelOfObject){ this.levelOfObject = levelOfObject;}

    public Integer gethealthPowerOfObject(){ return this.healthPowerOfObject; }

    public void sethealthPowerOfObject(Integer healthPowerOfObject){ this.healthPowerOfObject = healthPowerOfObject; }

}
