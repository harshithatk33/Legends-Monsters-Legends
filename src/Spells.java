/**
 * Spells : This class consists of different fields methods under spells and has getters and setters for this.
 * Author : Harshitha T K
 * Date   : Nov 1
 */
public class Spells extends Collectible {

    private Integer damageValue;
    private Integer manaCost;
    private String spellType;

    public Spells(String name, Integer cost, Integer level, Integer damageValue, Integer manaCost, String spellType) {
        super(name, cost, level);
        this.setDamageValue(damageValue);
        this.setManaCost(manaCost);
        this.setSpellType(spellType);
    }

    public Integer getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(Integer damageValue) {
        this.damageValue = damageValue;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(Integer manaCost) {
        this.manaCost = manaCost;
    }

    public String getSpellType() {
        return spellType;
    }

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }
}
