package de.erethon.magicxl.elements;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class Element {

    private String name;
    private int maxLevel;
    private Map<Integer, Double> expPerLevel;

    public Element(String n, int mLvl, Map<Integer, Double> exp) {
        name = n;
        maxLevel = mLvl;
        expPerLevel = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public Map<Integer, Double> getExpPerLevel() {
        return expPerLevel;
    }

}
