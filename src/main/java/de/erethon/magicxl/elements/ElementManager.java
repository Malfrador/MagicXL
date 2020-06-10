package de.erethon.magicxl.elements;

import de.erethon.magicxl.MagicXL;
import de.erethon.magicxl.player.EPlayer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ElementManager {

    MagicXL plugin = MagicXL.getInstance();

    private Set<Element> loadedElements = new HashSet<>();

    public Element getByName(String name) {
        for (Element e : loadedElements) {
            if (e.getName().equalsIgnoreCase(name)) {
                return e;
            }
        }
        return null;
    }

    //public Map<Element, Integer> getElementsOfPlayer(EPlayer eplayer) {
      //  plugin.getPlayerCache().getEPlayers();
   // }

    public Map<Element, Integer> generateStarting() {
        Map<Element, Integer> elementIntegerMap = new HashMap<>();
        for (Element e : loadedElements) {
            elementIntegerMap.put(e, 0);
        }
        return elementIntegerMap;
    }
}
