/**
 * Collectible : Class to hold the items needed for my marketPlace Class.
 * Author : Harshitha T K
 * Date   : Nov 5
 */
public abstract class Collectible {

    private String name;
    private Integer cost;
    private Integer level;

    public Collectible(String name, Integer cost, Integer level) {
        this.setName(name);
        this.setCost(cost);
        this.setLevel(level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
