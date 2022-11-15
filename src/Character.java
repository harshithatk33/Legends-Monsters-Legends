/**
 * Character abstract class is an abstract class for the virtual constructor characterFactory. This class will hold common methods for Heros and Monsters and abstract functions.
 * Author : Harshitha T K
 * Date   : Nov 4
 */


public abstract class Character extends Piece {


    private Integer maximumHP;
   // Integer positions;
    private Integer currentHP;
    private Integer characterLevel;
   // Integer experiencePoints;

    Character(String characterName, Integer maximumHP, Integer characterLevel){
        super(characterName);
        this.setMaximumHP(maximumHP);
        this.setCurrentHP(maximumHP);
        this.setCharacterLevel(characterLevel);
    }

    Character(){

    }
    public Integer getMaximumHP() {
        return maximumHP;
    }

    public void setMaximumHP(Integer maximumHP) {
        this.maximumHP = maximumHP;
    }

    public void increaseHP(Integer currentHP){
        this.currentHP = (currentHP + this.currentHP);
    }

    public void decreaseHP(Integer damage){
        this.currentHP = (this.currentHP - damage);
    }
//    public Integer getPositions() {
//        return positions;
//    }
//
//    public void setPositions(Integer positions) {
//        this.positions = positions;
//    }

    public Integer getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(Integer currentHP) throws IllegalStateException {
        if(currentHP < 0){
            throw new IllegalStateException("Current Health Points cannot be lesser than zero");
        }
        this.currentHP = currentHP;
    }

    public Integer getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(Integer characterLevel) {
        this.characterLevel = characterLevel;
    }

    public void increaseLevel(Integer characterLevel){
        this.characterLevel = (this.characterLevel + 1);
    }
//    public Integer getExperiencePoints() {
//        return experiencePoints;
//    }
//
//    public void setExperiencePoints(Integer experiencePoints) {
//        this.experiencePoints = experiencePoints;
//    }



}
