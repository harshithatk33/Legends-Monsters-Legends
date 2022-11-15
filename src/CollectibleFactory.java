/**
 * CollectibleFactory : design pattern/virtual constructor implemented to hold common functionalities of the Collectible class for this game.
 * Author : Harshitha T K
 * Date   : Nov 5
 */

import java.util.HashMap;

public class CollectibleFactory {
        public Collectible createSWAP(String collectibleType, HashMap<String, String> itemdetails){
            switch (collectibleType){
                case "Weapon" : return new Weapon(itemdetails.get("name"),Integer.parseInt(itemdetails.get("cost")),Integer.parseInt(itemdetails.get("level")),Integer.parseInt(itemdetails.get("damage")),Integer.parseInt(itemdetails.get("numberOfHandsRequired")));

                case "Spells" : return new Spells(itemdetails.get("name"),Integer.parseInt(itemdetails.get("cost")),Integer.parseInt(itemdetails.get("level")),Integer.parseInt(itemdetails.get("damage")), Integer.parseInt(itemdetails.get("manaCost")),itemdetails.get("spelltype"));

                case "Armour" : return new Armour(itemdetails.get("name"),Integer.parseInt(itemdetails.get("cost")),Integer.parseInt(itemdetails.get("level")),Integer.parseInt(itemdetails.get("damageReduction")));

                case "Potions" : return new Potions(itemdetails.get("name"),Integer.parseInt(itemdetails.get("cost")),Integer.parseInt(itemdetails.get("level")),Integer.parseInt(itemdetails.get("effectAmount")),itemdetails.get("typeOfPotion"));

                default:
                    throw new IllegalStateException("Invalid value provided for collectible type!!");
            }
    }
}
