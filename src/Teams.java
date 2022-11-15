/**
 * Teams : Common Class used to create Teams inside the Monster and Heroes classes.
 * Author : Harshitha T K
 * Date   : Nov 5
 */
import java.util.ArrayList;

public class Teams {
    private ArrayList<Character> listOfCharacters;

    private Integer sizeOfTeam;
    public Integer getSizeOfTeam() {
        return sizeOfTeam;
    }

    public void setSizeOfTeam(Integer sizeOfTeam) {
        if (sizeOfTeam <= 0) {
            sizeOfTeam = 1;
        } else if (sizeOfTeam > 3) {
            sizeOfTeam = 3;
        }
        this.sizeOfTeam = sizeOfTeam;
    }



     public Teams() {
        listOfCharacters = new ArrayList<>();
    }

    public void setCharacter(int index, Character ch) {
        this.listOfCharacters.add(index, ch);
    }

    public void addCharacter(Character ch) {
        this.listOfCharacters.add(ch);
    }

    public Character getCharacter(int index) {
        return this.listOfCharacters.get(index);
    }

    public ArrayList<Character> getListOfCharacters() {
        return listOfCharacters;
    }

    public void initListOfCharacters() {
        this.listOfCharacters = new ArrayList<>();
    }
}
