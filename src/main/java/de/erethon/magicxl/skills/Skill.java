package de.erethon.magicxl.skills;

import de.erethon.magicxl.elements.Element;
import de.erethon.magicxl.player.EPlayer;

public class Skill {

    String name;
    String[] description;
    Element element;
    int cooldown;
    int minLevel;

    public void onCast(EPlayer caster) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }
}
