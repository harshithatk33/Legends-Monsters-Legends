import java.util.ArrayList;

/**
 * Heroes class is inherited by the abstract class character, this class has specifics to the Heroes class
 * Author : Harshitha T K
 * Date   : Nov 4
 */
public class Heroes extends Character {
    private Integer maximumMP;
    private Integer currentMP;
    private Integer strengthValue;
    private Integer dexterityValue;
    private Integer gold;

    private ArrayList<Collectible> weapons;
    private ArrayList<Collectible> spells;
    private ArrayList<Collectible> armour;
    private ArrayList<Collectible> potions;

    private Integer agilityValue;
    private Integer experience;
    private boolean faint;
    private Collectible equippedWeapon;
    private Collectible equippedArmour;

    Heroes(String characterName, Integer maximumHP, Integer characterLevel, Integer maximumMP, Integer strengthValue, Integer dexterityValue, Integer gold, Integer agilityValue, Integer experience) {
        super(characterName, maximumHP, characterLevel);
        this.setMaximumMP(maximumMP);
        this.setCurrentHP(maximumMP);
        this.setStrengthValue(strengthValue);
        this.setDexterityValue(dexterityValue);
        this.setGold(gold);
        this.setAgilityValue(agilityValue);
        this.setExperience(experience);
        this.setFaint(false);
        this.setEquippedWeapon(null);
        this.setEquippedArmour(null);
        this.initializeInventory();
    }

    public void initializeInventory() {
        weapons = new ArrayList<>();
        spells = new ArrayList<>();
        armour = new ArrayList<>();
        potions = new ArrayList<>();
    }

    public Integer getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(Integer currentMP) {
        this.currentMP = currentMP;
    }

    public ArrayList<Collectible> getWeapons() {
        return weapons;
    }

    public ArrayList<Collectible> getSpells() {
        return spells;
    }

    public ArrayList<Collectible> getArmour() {
        return armour;
    }

    public ArrayList<Collectible> getPotions() {
        return potions;
    }

    public Integer getMaximumMP() {
        return maximumMP;
    }

    public void setMaximumMP(Integer maximumMP) {
        this.maximumMP = maximumMP;
    }

    public Integer getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(Integer strengthValue) {
        this.strengthValue = strengthValue;
    }

    public Integer getDexterityValue() {
        return dexterityValue;
    }

    public void setDexterityValue(Integer dexterityValue) {
        this.dexterityValue = dexterityValue;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }


    public Integer getAgilityValue() {
        return agilityValue;
    }

    public void setAgilityValue(Integer agilityValue) {
        this.agilityValue = agilityValue;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public boolean isFaint() {
        return faint;
    }

    public void setFaint(boolean faint) {
        this.faint = faint;
    }

    public Collectible getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Collectible equippedweapon) {
        this.equippedWeapon = equippedweapon;
    }

    public Collectible getEquippedArmour() {
        return equippedArmour;
    }

    public void setEquippedArmour(Collectible equippedArmour) {
        this.equippedArmour = equippedArmour;
    }

    public boolean isWeaponExists() {
        return this.equippedWeapon != null;
    }


    public boolean isArmourExists() {
        return this.equippedArmour != null;
    }
}
