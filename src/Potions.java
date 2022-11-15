/**
 * Potions : This class consists of different fields methods under potions and has getters and setters for this, Class Collectible implemented.
 * Author : Harshitha T K
 * Date   : Nov 5
 */
public class Potions extends Collectible {

    private Integer effectAmount;
    private String typeOfPotion;

    public Potions(String name, Integer cost, Integer level, Integer effectAmount, String typeOfPotion) {
        super(name, cost, level);
        this.setEffectAmount(effectAmount);
        this.setTypeOfPotion(typeOfPotion);
    }

    public Integer getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(Integer effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getTypeOfPotion() {
        return typeOfPotion;
    }

    public void setTypeOfPotion(String typeOfPotion) {
        this.typeOfPotion = typeOfPotion;
    }
}
