/**
 * Monsters class is inherited by the abstract class character, this class has specifics to the Monster class.
 * Author : Harshitha T K
 * Date   : Nov 4
 */
public class Monsters extends Character{
    Integer baseDamagevalue;
    Integer defenseValue;
    Integer dodgeValue;

    Monsters(String characterName, Integer maximumHP, Integer characterLevel,Integer baseDamagevalue,Integer defenseValue,Integer dodgeValue){
        super(characterName,maximumHP,characterLevel);
        this.setBaseDamage(baseDamagevalue);
        this.setDefenseValue(defenseValue);
        this.setDodgeValue(dodgeValue);

    }
    public Integer getBaseDamage() {
        return baseDamagevalue;
    }

    public void setBaseDamage(Integer baseDamage) {
        this.baseDamagevalue = baseDamage;
    }

    public Integer getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(Integer defenseValue) {
        this.defenseValue = defenseValue;
    }

    public Integer getDodgeValue() {
        return dodgeValue;
    }

    public void setDodgeValue(Integer dodgeValue) {
        this.dodgeValue = dodgeValue;
    }




}
