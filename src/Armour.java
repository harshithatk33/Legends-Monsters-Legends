/**
 * Armour class is inherited by the abstract class  Collectible, this class has specifics to the Armour feature of the game
 * Author : Harshitha T K
 * Date   : Nov 5
 */
public class Armour extends Collectible {

    private Integer damageReduction;

    public Armour(String name, Integer cost, Integer level, Integer damageReduction) {
        super(name, cost, level);
        this.setDamageReduction(damageReduction);
    }

    public Integer getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(Integer damageReduction) {
        this.damageReduction = damageReduction;
    }
}
