package com.adventure;

public class InventoryItem {

    private String name;
    private int hitpointModifier;
    private GameText gameText;

    public InventoryItem(String name, int hitpointModifier, GameText gameText) {
        this.name = name;
        this.hitpointModifier = hitpointModifier;
        this.gameText = gameText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitpointModifier() {
        return hitpointModifier;
    }

    public void setHitpointModifier(int hitpointModifier) {
        this.hitpointModifier = hitpointModifier;
    }

}
