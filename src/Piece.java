/**
 * Piece is the abstract Super class which can be inherited by various games to have the common functionalities of the pawns in the game
 * Author : Harshitha T K
 * Date   : Nov 1
 */
public abstract class Piece {
    private String  nameOfObject;
    private String colorOfObject;
    private String typeOfObject;

    Piece(String nameOfObject){
        this.setNameOfObject(nameOfObject);
    }
    Piece(){

    }
    Piece(String nameOfObject, String colorOfObject, String typeOfObject){
        this.setNameOfObject(nameOfObject);
        this.setColorOfObject(colorOfObject);
        this.setTypeOfObject(typeOfObject);
    }
    public String getNameOfObject(){ return this.nameOfObject; }

    public void setNameOfObject(String nameOfObject){ this.nameOfObject = nameOfObject;}

    public String getColorOfObject(){ return this.colorOfObject; }

    public void setColorOfObject(String colorOfObject){this.colorOfObject = colorOfObject;}

    public String getTypeOfObject(){ return this.typeOfObject; }

    public void setTypeOfObject(String typeOfObject){ this.typeOfObject = typeOfObject;}

}
