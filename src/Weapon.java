/**
 * Weapons : This class consists of different fields methods under weapons and has getters and setters for this, Class Collectible implemented.
 * Author : Harshitha T K
 * Date   : Nov 8
 */
public class Weapon extends Collectible {

    private Integer damageValue;
    private Integer numberOfHandsRequried;

    public Weapon(String name, Integer cost, Integer level, Integer damageValue, Integer numberOfHandsRequried) {
        super(name, cost, level);
        this.setDamageValue(damageValue);
        this.setNumberOfHandsRequried(numberOfHandsRequried);
    }

    public Integer getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(Integer damageValue) {
        this.damageValue = damageValue;
    }

    public Integer getNumberOfHandsRequried() {
        return numberOfHandsRequried;
    }

    public void setNumberOfHandsRequried(Integer numberOfHandsRequried) {
        this.numberOfHandsRequried = numberOfHandsRequried;
    }

    public static void useWeapon(Character heroObj, Character monsterObj, Collectible weapon) {
        monsterObj.decreaseHP((int)((((Heroes) heroObj).getStrengthValue() + ((Weapon) weapon).getDamageValue()) * 0.05));
    }
}
