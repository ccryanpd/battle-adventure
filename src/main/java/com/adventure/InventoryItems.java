package com.adventure;


public class InventoryItems {
    private String itemName;
    private int hpModifier;
    private int mpModifier;
    private int regularAttackModifier;
    private int magicAttackModifier;
    private int defenseModifier;
    private String itemDescription;
    private boolean isItemEquippable;

    public InventoryItems(String itemName, int hpModifier, int mpModifier, int regularAttackModifier, int magicAttackModifier, int defenseModifier, String itemDescription, boolean isItemEquippable) {
        this.itemName = itemName;
        this.hpModifier = hpModifier;
        this.mpModifier = mpModifier;
        this.regularAttackModifier = regularAttackModifier;
        this.magicAttackModifier = magicAttackModifier;
        this.defenseModifier = defenseModifier;
        this.itemDescription = itemDescription;
        this.isItemEquippable = isItemEquippable;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getHpModifier() {
        return hpModifier;
    }

    public void setHpModifier(int hpModifier) {
        this.hpModifier = hpModifier;
    }

    public int getMpModifier() {
        return mpModifier;
    }

    public void setMpModifier(int mpModifier) {
        this.mpModifier = mpModifier;
    }

    public int getRegularAttackModifier() {
        return regularAttackModifier;
    }

    public void setRegularAttackModifier(int regularAttackModifier) {
        this.regularAttackModifier = regularAttackModifier;
    }

    public int getMagicAttackModifier() {
        return magicAttackModifier;
    }

    public void setMagicAttackModifier(int magicAttackModifier) {
        this.magicAttackModifier = magicAttackModifier;
    }

    public int getDefenseModifier() {
        return defenseModifier;
    }

    public void setDefenseModifier(int defenseModifier) {
        this.defenseModifier = defenseModifier;
    }
}
